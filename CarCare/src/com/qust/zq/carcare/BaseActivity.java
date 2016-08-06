package com.qust.zq.carcare;

import com.qust.zq.carcare.data.DatabaseHelper;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {
	private Context mContext = BaseActivity.this;
	private DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	/** ��ʾ��Ϣ */
	protected void showToast(String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}
	/** ��ʾ�Ի��� */
	protected void showDialog(String title, String msg) {
	}
	/** ��ȡDatabaseHelper */
	protected DatabaseHelper getDatabaseHelper() {
		if (dbHelper == null) {
			dbHelper = new DatabaseHelper(mContext);
		}
		return dbHelper;
	}
}
