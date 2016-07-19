package com.mli.crown.mine.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mli.crown.mine.R;

/**
 * Created by crown on 2016/7/14.
 */
public class RegistView extends LinearLayout{

	private EditText mUserEdt;
	private EditText mPwdEdt;
	private EditText mEPwdEdt;
	private Button mReturnBtn;
	private Button mRegistBtn;

	public RegistView(Context context) {
		this(context, null);
	}

	public RegistView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RegistView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		initView();
	}

	//初始化
	private void initView() {
		LayoutInflater.from(getContext()).inflate(R.layout.layout_regist, this);
		mUserEdt = (EditText) findViewById(R.id.username_edt);
		mPwdEdt = (EditText) findViewById(R.id.password_edt);
		mEPwdEdt = (EditText) findViewById(R.id.ensure_password_edt);
		mReturnBtn = (Button) findViewById(R.id.return_btn);
		mRegistBtn = (Button) findViewById(R.id.regist_btn);

		mRegistBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mUserEdt.getText() == null || mPwdEdt.getText() == null || mEPwdEdt.getText() == null) {
					Toast.makeText(getContext(), "请输入用户名和密码", Toast.LENGTH_SHORT).show();
					return;
				}
				String userName = mUserEdt.getText().toString();
				String password = mPwdEdt.getText().toString();
				String rePassword = mEPwdEdt.getText().toString();

				if (password.equals(rePassword)) {
//					regist(userName, password);
				} else {
					Toast.makeText(getContext(), "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	public void setBackListener(final OnClickListener listener) {
		if(listener == null) {
			return;
		}
		mReturnBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
			}
		});
	}

}
