package com.qust.zq.carcare.activity;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.BaseActivity;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.adapter.CareAdapter;
import com.qust.zq.carcare.view.LineGridView;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

public class CarCareActivity extends BaseActivity {
	private Context mContext = CarCareActivity.this;
	private ImageView iv_car;
	private LineGridView gv_care;
	private LineGridView gv_upgrade;
	private LineGridView gv_beauty;
	private LineGridView gv_safe;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addContentView(R.layout.activity_carcare);
		iv_car = (ImageView) findViewById(R.id.iv_car);
		gv_care = (LineGridView) findViewById(R.id.gv_care);
		gv_care.setAdapter(new CareAdapter(mContext, getItems(careItemsArray)));
		//
		gv_upgrade = (LineGridView) findViewById(R.id.gv_upgrade);
		gv_upgrade.setAdapter(new CareAdapter(mContext, getItems(upgradeItemsArray)));
		//
		gv_beauty = (LineGridView) findViewById(R.id.gv_beauty);
		gv_beauty.setAdapter(new CareAdapter(mContext, getItems(beautyItemsArray)));
		//
		gv_safe = (LineGridView) findViewById(R.id.gv_safe);
		gv_safe.setAdapter(new CareAdapter(mContext, getItems(safeItemsArray)));
	}
	private Object[][] careItemsArray = new Object[][] {
			//
			{ "机油", R.drawable.ic_launcher },//
			{ "机滤", R.drawable.ic_launcher },//
			{ "空气滤", R.drawable.ic_launcher },//
			{ "空调滤", R.drawable.ic_launcher },//
			{ "火花塞", R.drawable.ic_launcher },//
			{ "防冻液", R.drawable.ic_launcher },//
			{ "刹车油", R.drawable.ic_launcher },//
			{ "轮胎", R.drawable.ic_launcher },//
			{ "雨刮", R.drawable.ic_launcher },//
			{ "燃油添加剂", R.drawable.ic_launcher },//
			{ "DIY工具", R.drawable.ic_launcher } //
	};
	private Object[][] upgradeItemsArray = new Object[][] {
			//
			{ "行车记录仪", R.drawable.ic_launcher },//
			{ "倒车影像", R.drawable.ic_launcher },//
			{ "车载手机架", R.drawable.ic_launcher },//
			{ "车载充电器", R.drawable.ic_launcher },//
			{ "车载净化器", R.drawable.ic_launcher },//
			{ "底盘装甲", R.drawable.ic_launcher } //
	};
	private Object[][] beautyItemsArray = new Object[][] {
			//
			{ "脚垫", R.drawable.ic_launcher },//
			{ "坐垫", R.drawable.ic_launcher },//
			{ "后备箱垫", R.drawable.ic_launcher },//
			{ "香水挂件", R.drawable.ic_launcher },//
			{ "炭包", R.drawable.ic_launcher },//
			{ "车载吸尘器", R.drawable.ic_launcher },//
			{ "洗车工具", R.drawable.ic_launcher },//
			{ "车蜡", R.drawable.ic_launcher },//
	};
	private Object[][] safeItemsArray = new Object[][]{
			//
			{ "补胎充气", R.drawable.ic_launcher },//
			{ "抛锚应急", R.drawable.ic_launcher },//
			{ "应急救援包", R.drawable.ic_launcher },//
			{ "紧急自救", R.drawable.ic_launcher },//
			{ "陷车防滑", R.drawable.ic_launcher },//
			{ "燃油续航", R.drawable.ic_launcher },//
			{ "舒适自驾", R.drawable.ic_launcher },//
			{ "随车电器", R.drawable.ic_launcher },//
	};
	
	private ArrayList<HashMap<String, Object>> getItems(Object[][] items) {
		ArrayList<HashMap<String, Object>> careItems = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < items.length; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("title", items[i][0]);
			hashMap.put("image", items[i][1]);
			careItems.add(hashMap);
		}
		return careItems;
	}
}
