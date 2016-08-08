package com.qust.zq.carcare;

import com.qust.zq.carcare.data.DatabaseHelper;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends Activity {
	private Context mContext = BaseActivity.this;
	private TextView tv_title;
	private LinearLayout container;
	private DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(getTitle());
		container = (LinearLayout) findViewById(R.id.container);
	}
	protected void addContentView(int resId){
		LayoutInflater.from(mContext).inflate(resId, container);
	}
	protected void setTitleStr(int res) {
		if (tv_title != null) {
			tv_title.setText(res);
		}
	}
	protected void setTitleStr(String title) {
		if (tv_title != null) {
			tv_title.setText(title);
		}
	}
	/** 显示消息 */
	protected void showToast(String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}
	/** 显示对话框 */
	protected void showDialog(String title, String msg) {
	}
	/** 获取DatabaseHelper */
	protected DatabaseHelper getDatabaseHelper() {
		if (dbHelper == null) {
			dbHelper = new DatabaseHelper(mContext);
		}
		return dbHelper;
	}
}
