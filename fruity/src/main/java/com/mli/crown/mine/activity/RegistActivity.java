package com.mli.crown.mine.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mli.crown.mine.R;
import com.mli.crown.mine.model.User;
import com.mli.crown.mine.utils.ToastUtils;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by crown on 2016/7/12.
 */
public class RegistActivity extends Activity {

	private EditText mUserEdt;
	private EditText mPwdEdt;
	private EditText mEPwdEdt;
	private Button mReturnBtn;
	private Button mRegistBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_regist);

		initView();
	}

	//初始化
	private void initView() {
		mUserEdt = (EditText) findViewById(R.id.username_edt);
		mPwdEdt = (EditText) findViewById(R.id.password_edt);
		mEPwdEdt = (EditText) findViewById(R.id.ensure_password_edt);
		mReturnBtn = (Button) findViewById(R.id.return_btn);
		mRegistBtn = (Button) findViewById(R.id.regist_btn);

		mRegistBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mUserEdt.getText() == null || mPwdEdt.getText() == null || mEPwdEdt.getText() == null) {
					Toast.makeText(RegistActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
					return;
				}
				String userName = mUserEdt.getText().toString();
				String password = mPwdEdt.getText().toString();
				String rePassword = mEPwdEdt.getText().toString();

				if (password.equals(rePassword)) {
					regist(userName, password);
				} else {
					Toast.makeText(RegistActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	//注册用户
	private void registUser(String username, String password) {
		User newUser = new User(username, password);
		newUser.save(new SaveListener<String>() {
			@Override
			public void done(String s, BmobException e) {
				if (e == null) {
					Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(RegistActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void regist(final String userName, final String password) {
		BmobQuery<User> query = new BmobQuery<User>();
		query.addWhereContains("userName", userName);
		query.findObjects(new FindListener<User>() {
			@Override
			public void done(List<User> list, BmobException e) {
				if(e == null && list != null && list.size() > 0) {
					ToastUtils.show(RegistActivity.this, "用户名已存在", Toast.LENGTH_SHORT);
				}else if(e != null) {
					registUser(userName, password);
				}else {
					ToastUtils.show(RegistActivity.this, "服务器出错", Toast.LENGTH_SHORT);
				}
			}
		});
	}
}
