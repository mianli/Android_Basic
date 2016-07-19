package com.mli.crown.mine.activity.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mli.crown.mine.R;

/**
 * Created by crown on 2016/7/14.
 */
public class LoginView extends LinearLayout {

	private ImageView mBackView;
	private LinearLayout mMainView;

	private EditText mUserEdt;
	private EditText mPwdEdt;
	public Button mRegistBtn;
	public Button mLoginBtn;

	public LoginView(Context context) {
		this(context, null);
	}

	public LoginView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LoginView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		initView();
	}

	//初始化
	private void initView() {
		LayoutInflater.from(getContext()).inflate(R.layout.layout_login, this);
		mBackView = (ImageView) findViewById(R.id.background_view);
		mMainView = (LinearLayout) findViewById(R.id.main_view);
		mUserEdt = (EditText) findViewById(R.id.username_edt);
		mPwdEdt = (EditText) findViewById(R.id.password_edt);
		mRegistBtn = (Button) findViewById(R.id.regist_btn);
		mLoginBtn = (Button) findViewById(R.id.login_btn);

	}

	public void setRegistListener(final OnClickListener listener) {
		if(listener == null) {
			return;
		}
		mRegistBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
			}
		});
	}

	public void setLoginListener(final OnClickListener listener) {
		if(listener == null) {
			return;
		}
		mLoginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
			}
		});
	}

}
