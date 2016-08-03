package com.qust.zq.carcare.data;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.utils.Util;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private Context mContext;
	private static String dbName = "cars.db";
	public final static String TABLE_CARS = "cars";
	public final static String TABLE_MYCARS = "mycars";
	public DatabaseHelper(Context context) {
		super(context, dbName, null, 1);
		this.mContext = context;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
	}
	public void insertData(SQLiteDatabase database) {
		ArrayList<ContentValues> cars = Util.readExcelFile(mContext);
		for (ContentValues car : cars) {
			long id = database.insert(DatabaseHelper.TABLE_CARS, null, car);
			Log.e("zhangqi", "car:" + id);
		}
	}
	public ArrayList<HashMap<String, String>> getAllCars(String tbName) {
		String[] cols = new String[] { "id", "brandname", "name_cn", "name", "level", "length", "width", "height", "wheelbase", "deploy" };
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(tbName, cols, null, null, null, null, null);
		ArrayList<HashMap<String, String>> cars = new ArrayList<HashMap<String, String>>();
		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> car = new HashMap<String, String>();
				for (String col : cols) {
					car.put(col, cursor.getString(cursor.getColumnIndex(col)));
				}
				cars.add(car);
			} while (cursor.moveToNext());
		}
		return cars;
	}
	public HashMap<String, Object> getCarInfo(String brandName, String carName, String deploy) {
		HashMap<String, Object> carInfo = new HashMap<String, Object>();
		SQLiteDatabase db = getReadableDatabase();
		String[] columns = new String[] { "id", "name_cn", "level", "length", "width", "height", "wheelbase" };
		Cursor cursor = db.query(TABLE_CARS, columns, "brandname=? and name=? and deploy=?", new String[] { brandName, carName, deploy }, null, null, null);
		if (cursor != null && cursor.moveToFirst()) {
			for (String column : columns) {
				carInfo.put(column, cursor.getString(cursor.getColumnIndex(column)));
			}
		}
		return carInfo;
	}
	/** 根据id查询车型信息 */
	public HashMap<String, String> getCarInfoById(int id) {
		HashMap<String, String> carInfo = new HashMap<String, String>();
		SQLiteDatabase db = getReadableDatabase();
		String[] columns = new String[] { "id", "brandname", "name_cn", "name", "level", "length", "width", "height", "wheelbase", "deploy" };
		Cursor cursor = db.query(TABLE_CARS, columns, "id = ?", new String[] { id + "" }, null, null, null);
		if (cursor != null && cursor.moveToFirst()) {
			for (String column : columns) {
				carInfo.put(column, cursor.getString(cursor.getColumnIndex(column)));
			}
		}
		return carInfo;
	}
	/** 获取所有品牌 */
	public ArrayList<String> getBrands() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(TABLE_CARS, new String[] { "brandname" }, null, null, null, null, null);
		ArrayList<String> brands = new ArrayList<String>();
		if (cursor.moveToFirst()) {
			do {
				String brandname = cursor.getString(cursor.getColumnIndex("brandname"));
				if (!brands.contains(brandname)) {
					brands.add(brandname);
				}
			} while (cursor.moveToNext());
		}
		return brands;
	}
	/** 获取所有车型 */
	public ArrayList<String> getCarNames(String brand) {
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(TABLE_CARS, new String[] { "name" }, "brandname=?", new String[] { brand }, null, null, null);
		ArrayList<String> carNames = new ArrayList<String>();
		if (cursor.moveToFirst()) {
			do {
				String carName = cursor.getString(cursor.getColumnIndex("name"));
				if (!carNames.contains(carName)) {
					carNames.add(carName);
				}
			} while (cursor.moveToNext());
		}
		return carNames;
	}
	/** 获取该车型所有配置 */
	public ArrayList<String> getDeploys(String carname) {
		SQLiteDatabase db = getReadableDatabase();
		String[] columns = new String[] { "deploy" };
		Cursor cursor = db.query(TABLE_CARS, columns, "name=?", new String[] { carname }, null, null, null);
		ArrayList<String> deploys = new ArrayList<String>();
		if (cursor.moveToFirst()) {
			do {
				String deploy = cursor.getString(cursor.getColumnIndex("deploy"));
				if (!deploys.contains(deploy)) {
					deploys.add(deploy);
				}
			} while (cursor.moveToNext());
		}
		return deploys;
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}
}
