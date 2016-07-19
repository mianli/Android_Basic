package com.mli.crown.mine.app;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 *
 * Created by crown on 2016/7/13.
 */
public class MContants {

	private static int mScreenHeight;
	private static int mScreenWidth;
	public static final String APP_ID = "b92415eb1624795a28b455266c52dc9a";

	public static int getScreenHeight(Activity activity) {
		if(mScreenHeight == 0) {
			WindowManager manager = activity.getWindowManager();
			DisplayMetrics outMetrics = new DisplayMetrics();
			manager.getDefaultDisplay().getMetrics(outMetrics);
			mScreenHeight = outMetrics.heightPixels;
		}
		return mScreenHeight;
	}

	public static int getScreenWidth(Activity activity) {
		if(mScreenWidth == 0) {
			WindowManager manager = activity.getWindowManager();
			DisplayMetrics outMetrics = new DisplayMetrics();
			manager.getDefaultDisplay().getMetrics(outMetrics);
			mScreenWidth = outMetrics.widthPixels;
		}
		return mScreenWidth;
	}
}
