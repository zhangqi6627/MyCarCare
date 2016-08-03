package com.qust.zq.carcare.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import jxl.Image;
import jxl.Sheet;
import jxl.Workbook;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Util {
	public static ArrayList<ContentValues> readExcelFile(Context context) {
		ArrayList<ContentValues> cars = new ArrayList<ContentValues>();
		try {
			
			
			Workbook book = Workbook.getWorkbook(context.getResources().getAssets().open("20160703.xls"));
			Log.e("zhangqi", ">>>>>>number of sheet " + book.getNumberOfSheets());
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(1);
			int Rows = 54;
			int Cols = 11;
			Log.e("zhangqi", "当前工作表的名字:" + sheet.getName());
			Log.e("zhangqi", "总行数:" + Rows);
			Log.e("zhangqi", "总列数:" + Cols);
			int beginRow = 2;
			int colBrandName = 0;
			int colCarNameCn = 2;
			int colCarName = 3;
			int colCarLevel = 4;
			int colCarLength = 5;
			int colCarWidth = 6;
			int colCarHeight = 7;
			int colWheelbase = 8;
			int colDeploy = 9;
			for (int i = beginRow; i < Rows; ++i) {
				ContentValues car = new ContentValues();
				car.put("brandname", sheet.getCell(colBrandName, i).getContents());
				car.put("name_cn", sheet.getCell(colCarNameCn, i).getContents());
				car.put("name", sheet.getCell(colCarName, i).getContents());
				car.put("level", sheet.getCell(colCarLevel, i).getContents());
				car.put("length", sheet.getCell(colCarLength, i).getContents());
				car.put("width", sheet.getCell(colCarWidth, i).getContents());
				car.put("height", sheet.getCell(colCarHeight, i).getContents());
				car.put("wheelbase", sheet.getCell(colWheelbase, i).getContents());
				car.put("deploy", sheet.getCell(colDeploy, i).getContents());
				cars.add(car);
			}
			book.close();
		} catch (Exception e) {
			Log.e("zhangqi", "readExcelFile", e);
		}
		return cars;
	}
	public static void readExcelBitmaps(Context context) {
		try {
			Workbook book = Workbook.getWorkbook(context.getResources().getAssets().open("20160703.xls"));
			Sheet sheet = book.getSheet(1);
			int imageFileSize = sheet.getNumberOfImages();
			for (int i = 0; i < imageFileSize; i++) {
				Image image = sheet.getDrawing(i);
				Bitmap bitmap = BitmapFactory.decodeByteArray(image.getImageData(), 0, image.getImageData().length);
				File imageFile = new File("/storage/sdcard/Download/car_" + i + ".png");
				if (!imageFile.exists()) {
					boolean createSuccess = imageFile.createNewFile();
					if (createSuccess) {
						Log.e("zhangqi", "image file create success");
					} else {
						Log.e("zhangqi", "image file create failure");
					}
				}
				FileOutputStream fileOutputStream = null;
				try {
					fileOutputStream = new FileOutputStream(imageFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				boolean saveSuccess = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
				if (saveSuccess) {
					Log.e("zhangqi0000", "save image " + i + " Success");
				} else {
					Log.e("zhangqi0000", "save image " + i + " Failure");
				}
			}
		} catch (Exception e) {
			Log.e("zhangqi", "", e);
		}
	}
}
