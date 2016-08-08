package com.qust.zq.carcare.activity;

import java.util.HashMap;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.BaseActivity;
import com.qust.zq.carcare.data.DatabaseHelper;
import com.qust.zq.carcare.utils.BitmapLoader;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class CarSelectActivity extends BaseActivity {
	private Context mContext = CarSelectActivity.this;
	private Spinner brands;
	private Spinner names;
	private Spinner deploys;
	private RadioGroup careType;
	private TextView tv_level;
	private TextView tv_length;
	private TextView tv_width;
	private TextView tv_height;
	private TextView tv_wheelbase;
	private ImageView iv_car;
	private Button btn_ok;
	private DatabaseHelper dbHelper;
	private int selectedId = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addContentView(R.layout.activity_select);
		brands = (Spinner) findViewById(R.id.brands);
		dbHelper = new DatabaseHelper(mContext);
		String[] brandNames = dbHelper.getBrands().toArray(new String[] {});
		ArrayAdapter<String> carAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, brandNames);
		brands.setAdapter(carAdapter);
		brands.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
				// TODO Auto-generated method stub
				names.setEnabled(true);
				if (view != null && view instanceof TextView) {
					String brand = ((TextView) view).getText().toString();
					String[] carNames = dbHelper.getCarNames(brand).toArray(new String[] {});
					names.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, carNames));
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				names.setEnabled(false);
			}
		});
		//
		names = (Spinner) findViewById(R.id.carnames);
		names.setEnabled(false);
		names.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
				// TODO Auto-generated method stub
				deploys.setEnabled(true);
				if (view != null && view instanceof TextView) {
					String name = ((TextView) view).getText().toString();
					String[] deployss = dbHelper.getDeploys(name).toArray(new String[] {});
					deploys.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, deployss));
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				deploys.setEnabled(false);
			}
		});
		//
		deploys = (Spinner) findViewById(R.id.deploys);
		deploys.setEnabled(false);
		deploys.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (view != null && view instanceof TextView) {
					String deploy = ((TextView) view).getText().toString();
					String name = ((TextView) names.getSelectedView()).getText().toString();
					String brand = ((TextView) brands.getSelectedView()).getText().toString();
					HashMap<String, Object> hashMap = dbHelper.getCarInfo(brand, name, deploy);
					int id = Integer.parseInt((String) hashMap.get("id"));
					selectedId = id;
					String name_cn = (String) hashMap.get("name_cn");
					String level = (String) hashMap.get("level");
					String width = (String) hashMap.get("width");
					String length = (String) hashMap.get("length");
					String height = (String) hashMap.get("height");
					String wheelbase = (String) hashMap.get("wheelbase");
					tv_level.setText(level);
					tv_length.setText(length);
					tv_width.setText(width);
					tv_height.setText(height);
					tv_wheelbase.setText(wheelbase);
					/*
					 * 
					 * 
					 * 
					 * get carinfo by brand,carname,deply
					 */
					int carBitmap = BitmapLoader.getCarBitmapByName(name);
					iv_car.setImageResource(carBitmap);
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		//
		tv_level = (TextView) findViewById(R.id.tv_level);
		tv_length = (TextView) findViewById(R.id.tv_length);
		tv_width = (TextView) findViewById(R.id.tv_width);
		tv_height = (TextView) findViewById(R.id.tv_height);
		tv_wheelbase = (TextView) findViewById(R.id.tv_wheelbase);
		iv_car = (ImageView) findViewById(R.id.iv_car);
		btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				HashMap<String, String> carInfo = dbHelper.getCarInfoById(selectedId);
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues contentValues = new ContentValues();
				String[] columns = new String[] { "id", "brandname", "name_cn", "name", "level", "length", "width", "height", "wheelbase", "deploy" };
				for (String column : columns) {
					contentValues.put(column, carInfo.get(column));
				}
				long id = db.insert("mycars", null, contentValues);
				if (id != -1) {
					startActivity(new Intent(mContext, CarCareActivity.class));
				}else{
					showToast("该车型已存在");
				}
			}
		});
	}
}
