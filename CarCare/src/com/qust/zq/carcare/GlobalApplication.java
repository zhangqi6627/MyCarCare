package com.qust.zq.carcare;

import com.qust.zq.carcare.data.DatabaseHelper;
import android.app.Application;
import android.content.Context;

public class GlobalApplication extends Application {
	private Context mContext = GlobalApplication.this;
	private DatabaseHelper dbHelper;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
}
