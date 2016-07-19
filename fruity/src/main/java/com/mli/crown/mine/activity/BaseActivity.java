package com.mli.crown.mine.activity;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by crown on 2016/7/14.
 */
public class BaseActivity extends Activity {

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(0, 0);
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, 0);
	}
}
