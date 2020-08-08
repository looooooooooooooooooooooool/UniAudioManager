package uni.fvv.audiomanager;

import android.media.AudioManager;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

public class UniAudioManager extends WXModule {

    AudioManager mAudioManager;

    @JSMethod(uiThread = true)
    public void test(){
        Toast.makeText(mWXSDKInstance.getContext(),"test",Toast.LENGTH_LONG).show();
    }

    //初始化
    @JSMethod(uiThread = true)
    public void init(){
        mAudioManager = (AudioManager) mWXSDKInstance.getContext().getSystemService(mWXSDKInstance.getContext().AUDIO_SERVICE);
    }

    //获取当前音量
    @JSMethod(uiThread = false)
    public int getCurrentVolume(String type){
        type = type == null?"music":type;
        int max = mAudioManager.getStreamMaxVolume(SwitchType(type));
        int volume = mAudioManager.getStreamVolume(SwitchType(type));
        return 100 * volume / max;
    }

    //调整音量
    @JSMethod(uiThread = true)
    public void adjustVolume(JSONObject jsonObject){
        String type = SetValue(jsonObject,"type","music");
        String direction = SetValue(jsonObject,"direction","SAME");
        int flag = SetValue(jsonObject,"flag",0);

        mAudioManager.adjustStreamVolume(SwitchType(type),SwitchDirection(direction),flag);
    }

    //设置音量
    @JSMethod(uiThread = true)
    public void setVolume(JSONObject jsonObject){
        String type = SetValue(jsonObject,"type","music");
        int volume = SetValue(jsonObject,"volume",50);
        int flag = SetValue(jsonObject,"flag",0);

        int max = mAudioManager.getStreamMaxVolume(SwitchType(type));

        mAudioManager.setStreamVolume(SwitchType(type),(int)Math.ceil(volume * max * 0.01),flag);
    }

    //设置静音
    @JSMethod(uiThread = true)
    public void setMute(JSONObject jsonObject){
        String type = SetValue(jsonObject,"type","music");
        Boolean state = SetValue(jsonObject,"state",false);
        mAudioManager.setStreamMute(SwitchType(type),state);
    }


    //匹配调整方式
    private int SwitchDirection(String direction){
        switch (direction.toUpperCase()){
            case "LOWER":
                return AudioManager.ADJUST_LOWER;
            case "RAISE":
                return AudioManager.ADJUST_RAISE;
            case "SAME":
                return AudioManager.ADJUST_SAME;
        }
        return AudioManager.ADJUST_SAME;
    }

    //匹配操作类型
    private int SwitchType(String type){
        switch (type.toUpperCase()){
            case "MUSIC":
                return AudioManager.STREAM_MUSIC;
            case "ALARM":
                return AudioManager.STREAM_ALARM ;
            case "RING":
                return AudioManager.STREAM_RING ;
            case "SYSTEM":
                return AudioManager.STREAM_SYSTEM ;
            case "CALL":
                return AudioManager.STREAM_VOICE_CALL;
            case "NOTIFICATION":
                return AudioManager.STREAM_NOTIFICATION;
            case "DTMF":
                return AudioManager.STREAM_DTMF;
        }
        return AudioManager.STREAM_MUSIC;
    }

    //返回当前音频模式
    @JSMethod(uiThread = false)
    public String getMode(){
        int mode = mAudioManager.getMode();
        switch (mode){
            case AudioManager.MODE_NORMAL:
                return "NORMAL";
            case AudioManager.MODE_IN_CALL:
                return "CALL";
            case AudioManager.MODE_IN_COMMUNICATION:
                return "COMMUNICATION";
            case AudioManager.MODE_RINGTONE:
                return "RINGTONE";
            case AudioManager.MODE_INVALID:
                return "INVALID";
            case AudioManager.MODE_CURRENT:
                return "CURRENT";
        }
        return "NORMAL";
    }

    //设置音频模式
    @JSMethod(uiThread = false)
    public void setMode(String type){
        int mode = AudioManager.MODE_NORMAL;
        switch (type.toUpperCase()){
            case "NORMAL":
                mode = AudioManager.MODE_NORMAL;
                break;
            case "CALL":
                mode = AudioManager.MODE_IN_CALL;
                break;
            case "COMMUNICATION":
                mode = AudioManager.MODE_IN_COMMUNICATION;
                break;
            case "RINGTONE":
                mode = AudioManager.MODE_RINGTONE;
                break;
        }
        mAudioManager.setMode(mode);
    }

    //获取当前铃声模式
    @JSMethod(uiThread = false)
    public String getRingerMode(){
        int mode = mAudioManager.getRingerMode();
        switch (mode){
            case AudioManager.RINGER_MODE_NORMAL:
                return "NORMAL";
            case AudioManager.RINGER_MODE_SILENT:
                return "SILENT";
            case AudioManager.RINGER_MODE_VIBRATE:
                return "VIBRATE";
        }
        return "NORMAL";
    }

    //设置当前铃声模式
    @JSMethod(uiThread = false)
    public void setRingerMode(String type){
        int mode = AudioManager.RINGER_MODE_NORMAL;
        switch (type.toUpperCase()){
            case "NORMAL":
                mode =  AudioManager.RINGER_MODE_NORMAL;
                break;
            case "SILENT":
                mode =  AudioManager.RINGER_MODE_SILENT;
                break;
            case "VIBRATE":
                mode =  AudioManager.RINGER_MODE_VIBRATE;
                break;
        }
        mAudioManager.setRingerMode(mode);
    }

    //打开扩音器
    @JSMethod(uiThread = true)
    public void setSpeakerphoneOn(Boolean bool){
        mAudioManager.setSpeakerphoneOn(bool == null?false:bool);
    }

    //麦克风是否静音
    @JSMethod(uiThread = true)
    public void setMicrophoneMute(Boolean bool){
        mAudioManager.setMicrophoneMute(bool == null?false:bool);
    }

    //麦克风静音是否开启
    @JSMethod(uiThread = false)
    public Boolean isMicrophoneMute(){
        return mAudioManager.isMicrophoneMute();
    }

    //判断音乐活跃状态
    @JSMethod(uiThread = false)
    public Boolean isMusicActive(){
        return mAudioManager.isMusicActive();
    }

    //判断是否插入耳机
    @JSMethod(uiThread = false)
    public Boolean isWiredHeadsetOn(){
        return mAudioManager.isWiredHeadsetOn();
    }

    //检查是否A2DP蓝牙耳机音频路由是打开或关闭
    @JSMethod(uiThread = false)
    public Boolean isBluetoothA2dpOn(){
        return mAudioManager.isBluetoothA2dpOn();
    }

    //检查通讯是否使用蓝牙
    @JSMethod(uiThread = false)
    public Boolean isBluetoothScoOn(){
        return mAudioManager.isBluetoothScoOn();
    }

    //要求蓝牙进行通讯
    @JSMethod(uiThread = false)
    public void setBluetoothScoOn(Boolean bool){
        mAudioManager.setBluetoothScoOn(bool == null?false:bool);
    }

    //启动蓝牙sco音频连接
    @JSMethod(uiThread = false)
    public void startBluetoothSco(){
        mAudioManager.startBluetoothSco();
    }

    //停止蓝牙sco音频连接
    @JSMethod(uiThread = false)
    public void stopBluetoothSco(){
        mAudioManager.stopBluetoothSco();
    }

    public int SetValue(JSONObject object,String key,int defaultValue){
        object = object == null?new JSONObject():object;
        return object.containsKey(key)?object.getInteger(key):defaultValue;
    }
    public String SetValue(JSONObject object,String key,String defaultValue){
        object = object == null?new JSONObject():object;
        return object.containsKey(key)?object.getString(key):defaultValue;
    }
    public Boolean SetValue(JSONObject object,String key,Boolean defaultValue){
        object = object == null?new JSONObject():object;
        return object.containsKey(key)?object.getBoolean(key):defaultValue;
    }
}
