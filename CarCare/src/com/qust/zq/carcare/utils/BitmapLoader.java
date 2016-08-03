package com.qust.zq.carcare.utils;

import java.util.HashMap;
import com.qust.zq.carcare.R;
import android.graphics.Bitmap;
import android.text.TextUtils;

public class BitmapLoader {
	private static HashMap<String, Integer> carBitmaps = new HashMap<String, Integer>() {
		{
			this.put("–‹√®", R.drawable.car_1);
			this.put("µ€∫¿", R.drawable.car_3);
			this.put("F0", R.drawable.car_5);
			this.put("QQ", R.drawable.car_7);
			this.put("fortwo", R.drawable.car_9);
			this.put("Fit", R.drawable.car_11);
			this.put("Polo", R.drawable.car_13);
			this.put("Fiesta", R.drawable.car_15);
			this.put("Lavida", R.drawable.car_17);
		}
	};
	public static Bitmap getBrandBitmapByName(String name) {
		return null;
	}
	public static int getCarBitmapByName(String name) {
		int resId = -1;
		if (!TextUtils.isEmpty(name)) {
			resId = carBitmaps.get(name);
		}
		return resId;
	}
}
