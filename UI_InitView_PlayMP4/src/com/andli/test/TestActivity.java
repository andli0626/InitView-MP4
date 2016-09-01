package com.andli.test;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;

import com.andli.init.playmp4.R;

public class TestActivity extends Activity {

	private FullScreenVideoView mVideoView;
	MediaController mMediaController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.testactivity);
		mVideoView = (FullScreenVideoView) findViewById(R.id.video1);
		mMediaController = new MediaController(this);
		mMediaController.setVisibility(View.GONE);// 隐藏播放控制条

		// File file = new File("/mnt/sdcard/通话录音/1.mp4");
		// if (file.exists()) {
		// // VideoView与MediaController进行关联
		// video1.setVideoPath(file.getAbsolutePath());
		// video1.setMediaController(mediaco);
		// mediaco.setMediaPlayer(video1);
		// // 让VideiView获取焦点
		// video1.requestFocus();
		// }

		// 播放Raw下的文件
		Uri mUri = Uri.parse("android.resource://" + getPackageName() + "/"
				+ R.raw.welcome);
		mVideoView.setVideoURI(mUri);
		mVideoView.setMediaController(mMediaController);
		mMediaController.setMediaPlayer(mVideoView);
		mVideoView.requestFocus();
		mVideoView.start();
	}
}
