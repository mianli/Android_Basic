package com.mli.crown.mine.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.mli.crown.mine.R;
import com.mli.crown.mine.activity.view.LoginView;
import com.mli.crown.mine.activity.view.RegistView;
import com.mli.crown.mine.app.MContants;
import com.mli.crown.mine.utils.BitmapUtils;

/**
 * Created by crown on 2016/7/12.
 */

public class LoginActivity extends BaseActivity {

	private static final int ANIMATION_DURATION = 1000;
	private ImageView mBackView;
	private LoginView mLoginView;
	private RegistView mRegistView;
	private Bitmap mBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	//初始化
	private void initView() {
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fruit);
		mBackView = (ImageView) findViewById(R.id.background_view);
		mLoginView = (LoginView) findViewById(R.id.login_view);
		mRegistView = (RegistView) findViewById(R.id.regist_view);
		mLoginView.setVisibility(View.GONE);
		mLoginView.setRegistListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startRegistAnimation();
			}
		});
		mRegistView.setBackListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startLoginAnimation();
			}
		});
		mBackView.setImageBitmap(mBitmap);

		ViewTreeObserver observer = mLoginView.getViewTreeObserver();
		observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				startAnimation();
				LoginActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
				return true;
			}
		});
	}

	private void startAnimation() {

		ObjectAnimator animator = ObjectAnimator.ofFloat(mLoginView, "Y", MContants.getScreenHeight(this), 0);
		ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(mBackView, "alpha", 1.0f, 1.0f);

		ValueAnimator valueAnimator = new ValueAnimator();
		valueAnimator.setDuration(ANIMATION_DURATION * 5);
		valueAnimator.setObjectValues(127, 0);
		valueAnimator.setTarget(mBackView);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int degree = (int) animation.getAnimatedValue();
				//proress limit 0~255
				Log.d("color", degree + "");
//				mBackView.setImageBitmap(BitmapUtils.handleBitmapEffect(mBitmap, 0, 0, 127));
			}
		});

		AnimatorSet set = new AnimatorSet();
		set.play(animator).with(valueAnimator);
		set.setDuration(ANIMATION_DURATION);
		set.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				mLoginView.setVisibility(View.VISIBLE);
			}
		});
		set.start();
	}

	private void startRegistAnimation() {
		final ObjectAnimator loginAnimator = ObjectAnimator.ofFloat(mLoginView, "rotationY", 0, 90);
		final ObjectAnimator registAnimator = ObjectAnimator.ofFloat(mRegistView, "rotationY", -90, 0);
		loginAnimator.setDuration(ANIMATION_DURATION/4);
		registAnimator.setDuration(ANIMATION_DURATION/4);
		loginAnimator.start();
		loginAnimator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				registAnimator.start();
				mRegistView.setVisibility(View.VISIBLE);
				mLoginView.setVisibility(View.GONE);
			}
		});
	}

	private void startLoginAnimation() {
		final ObjectAnimator loginAnimator = ObjectAnimator.ofFloat(mLoginView, "rotationY", 90, 0);
		final ObjectAnimator registAnimator = ObjectAnimator.ofFloat(mRegistView, "rotationY", 0, -90);
		loginAnimator.setDuration(ANIMATION_DURATION/4);
		registAnimator.setDuration(ANIMATION_DURATION/4);
		registAnimator.start();
		registAnimator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				loginAnimator.start();
				mRegistView.setVisibility(View.GONE);
				mLoginView.setVisibility(View.VISIBLE);
			}
		});
	}

}
