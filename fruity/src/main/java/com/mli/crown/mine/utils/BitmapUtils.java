package com.mli.crown.mine.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

/**
 * Created by crown on 2016/7/20.
 */
public class BitmapUtils {

	public static final int MAX_VALUE = 255;
	public static final int MID_VALUE = 127;

	public static final Bitmap beGray(Bitmap bitmap, float grayDegree) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		Bitmap greyBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(greyBitmap);
		Paint paint = new Paint();
		ColorMatrix matrix = new ColorMatrix();
		matrix.setSaturation(grayDegree);
		ColorMatrixColorFilter colorMatrixFilter = new ColorMatrixColorFilter(matrix);
		paint.setColorFilter(colorMatrixFilter);
		canvas.drawBitmap(greyBitmap, 0 , 0, paint);
		return greyBitmap;
	}

	public static Bitmap drawable2Bitmap(Drawable drawable) {
		if(drawable == null) {
			return null;
		}
		if (drawable instanceof BitmapDrawable) {
			return ((BitmapDrawable) drawable).getBitmap();
		} else if (drawable instanceof NinePatchDrawable) {
			Bitmap bitmap = Bitmap
					.createBitmap(
							drawable.getIntrinsicWidth(),
							drawable.getIntrinsicHeight(),
							drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
									: Bitmap.Config.RGB_565);
			Canvas canvas = new Canvas(bitmap);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
					drawable.getIntrinsicHeight());
			drawable.draw(canvas);
			return bitmap;
		} else {
			return null;
		}
	}

	//色相，饱和度，亮度
	public static Bitmap handleBitmapEffect(Bitmap bitmap, int hue, int saturation, int lum) {
		//(progress - midValue) * 1.0f /midValue * 180;
		//progress * 1.0f / midValue;
		//progress * 1.0f / midValue;
		Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bmp);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

		ColorMatrix hueMatrix = new ColorMatrix();
		hueMatrix.setRotate(0, hue);
		hueMatrix.setRotate(1, hue);
		hueMatrix.setRotate(2, hue);

		ColorMatrix saturationMatrix = new ColorMatrix();
		saturationMatrix.setSaturation(saturation);

		ColorMatrix lumMatrix = new ColorMatrix();
		lumMatrix.setScale(lum, lum, lum, 1);

		ColorMatrix imageMatrix = new ColorMatrix();
		imageMatrix.postConcat(hueMatrix);
		imageMatrix.postConcat(saturationMatrix);
		imageMatrix.postConcat(lumMatrix);

		paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
		canvas.drawBitmap(bitmap, 0, 0, paint);//why is not bmp?

		return bmp;
	}

}
