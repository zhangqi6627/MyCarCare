package com.qust.zq.carcare.activity;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.BaseActivity;
import com.qust.zq.carcare.adapter.MyCarListAdapter;
import com.qust.zq.carcare.data.DatabaseHelper;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MyCarListActivity extends BaseActivity {
	private ListView list_cars;
	private Button btn_add;
	private Context mContext = MyCarListActivity.this;
	private MyCarListAdapter myCarListAdapter;
	private ArrayList<HashMap<String, String>> myCars;
	private DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mycar);
		myCars = getMyCars();
		list_cars = (ListView) findViewById(R.id.list_cars);
		myCarListAdapter = new MyCarListAdapter(mContext, myCars);
		list_cars.setAdapter(myCarListAdapter);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(mContext, CarSelectActivity.class));
			}
		});
		list_cars.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2, long arg3) {
				startActivity(new Intent(mContext, CarCareActivity.class));
				finish();
			}
		});
	}
	private ArrayList<HashMap<String, String>> getMyCars() {
		dbHelper = new DatabaseHelper(mContext);
		return dbHelper.getAllCars(DatabaseHelper.TABLE_MYCARS);
	}
}
