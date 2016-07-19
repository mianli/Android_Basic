package com.mli.crown.mine.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by crown on 2016/7/12.
 */
public class ToastUtils {

	public static void show(Activity activity, String msg, int duration){
		Toast.makeText(activity, msg, duration).show();
	}

}
