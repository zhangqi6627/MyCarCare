package com.qust.zq.carcare.activity;

import com.qust.zq.carcare.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends Activity {
	private Context mContext = SplashActivity.this;
	private ImageView iv_logo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		iv_logo = (ImageView) findViewById(R.id.iv_logo);
		handler.sendEmptyMessageDelayed(1, 2000);
	}
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				startActivity(new Intent(mContext, LoginActivity.class));
				finish();
				break;
			}
		};
	};
}
