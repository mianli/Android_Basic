package com.mli.crown.mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.mli.crown.mine.R;
import com.mli.crown.mine.app.MContants;

import cn.bmob.v3.Bmob;

/**
 * Created by crown on 2016/7/12.
 */
public class SplashActivity extends BaseActivity {


//	private VideoView mVideoView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Bmob.initialize(this, MContants.APP_ID);

		initView();
	}

	private void initView() {
		/**
		mVideoView = (VideoView) findViewById(R.id.vedioview);
		android.widget.MediaController controller = new android.widget.MediaController(this);
		mVideoView.setMediaController(controller);
		mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_vedio));
		mVideoView.start();
		mVideoView.requestFocus();
		mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
//				mVideoView.start();
				startActivity(new Intent(SplashActivity.this, LoginActivity.class));
				finish();
			}
		});
		 **/
		startActivity(new Intent(SplashActivity.this, LoginActivity.class));
		finish();
	}

}
