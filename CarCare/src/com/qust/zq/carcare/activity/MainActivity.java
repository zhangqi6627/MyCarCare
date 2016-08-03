package com.qust.zq.carcare.activity;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.BaseActivity;
import com.qust.zq.carcare.data.DatabaseHelper;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
	private Context mContext = MainActivity.this;
	private EditText et_username;
	private EditText et_password;
	private ImageView imageView;
	private Button btn_login;
	private Button btn_register;
	private ListView listView;
	private DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}
	private void initView() {
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, MyCarListActivity.class));
			}
		});
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("hello");
			}
		});
		
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		imageView = (ImageView) findViewById(R.id.imageView);
		progressDialog = new ProgressDialog(mContext);
		progressDialog.setMessage("saving images");
		progressDialog.setCanceledOnTouchOutside(false);
	}
	private ProgressDialog progressDialog;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				if (progressDialog != null) {
					progressDialog.show();
				}
				break;
			case 1:
				if (progressDialog != null) {
					progressDialog.dismiss();
				}
				Toast.makeText(mContext, "Save images success", Toast.LENGTH_SHORT).show();
				break;
			}
		};
	};
	private void initData() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// handler.sendEmptyMessage(0);
				// Util.readExcelBitmaps(mContext);
				// handler.sendEmptyMessage(1);
			}
		}).start();
		// imageView.setImageBitmap(bitmap);
		dbHelper = new DatabaseHelper(mContext);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.execSQL("create table if not exists cars(id integer primary key autoincrement,brandname varchar,name_cn varchar,name varchar,level varchar,length varchar,width varchar,height varchar,wheelbase varchar,deploy varchar);");
		ArrayList<HashMap<String, String>> cars = dbHelper.getAllCars(DatabaseHelper.TABLE_CARS);
		Log.e("zhangqi", "cars size : " + cars.size());
		if (cars != null && cars.size() == 0) {
			dbHelper.insertData(db);
		}
		db.execSQL("create table if not exists mycars(id integer primary key autoincrement,brandname varchar,name_cn varchar,name varchar,level varchar,length varchar,width varchar,height varchar,wheelbase varchar,deploy varchar);");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
