<template>
	<view class="content">
		<p>Fvv audio manager</p>
		<button @click="init">初始化</button>
		<button @click="getVolume">获取当前媒体音量</button>
		<button @click="up">增加音量</button>
		<button @click="down">减少音量</button>
		<button @click="set">直接设置音量</button>
	</view>
</template>

<script>
	const FvvAudioManager = uni.requireNativePlugin('Fvv-UniAudioManager')
	export default {
		data() {
			return { 
			}
		},
		onLoad() {

		},
		methods: {
			init(){
				FvvAudioManager.init()
			},
			getVolume(){
				console.log(FvvAudioManager.getCurrentVolume("music"))
			},
			up(){
				FvvAudioManager.adjustVolume({
					type:"music",
					direction:"raise",
					flag:1|4
				})
			},
			down(){
				FvvAudioManager.adjustVolume({
					type:"music",
					direction:"lower",
					flag:1|4
				})
			},
			set(){
				FvvAudioManager.setVolume({
					type:"music",
					volume:100,
					flag:1|4
				})
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	 
</style>
