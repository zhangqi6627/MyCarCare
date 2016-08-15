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
			{ "����", R.drawable.ic_launcher },//
			{ "����", R.drawable.ic_launcher },//
			{ "������", R.drawable.ic_launcher },//
			{ "�յ���", R.drawable.ic_launcher },//
			{ "����", R.drawable.ic_launcher },//
			{ "����Һ", R.drawable.ic_launcher },//
			{ "ɲ����", R.drawable.ic_launcher },//
			{ "��̥", R.drawable.ic_launcher },//
			{ "���", R.drawable.ic_launcher },//
			{ "ȼ����Ӽ�", R.drawable.ic_launcher },//
			{ "DIY����", R.drawable.ic_launcher } //
	};
	private Object[][] upgradeItemsArray = new Object[][] {
			//
			{ "�г���¼��", R.drawable.ic_launcher },//
			{ "����Ӱ��", R.drawable.ic_launcher },//
			{ "�����ֻ���", R.drawable.ic_launcher },//
			{ "���س����", R.drawable.ic_launcher },//
			{ "���ؾ�����", R.drawable.ic_launcher },//
			{ "����װ��", R.drawable.ic_launcher } //
	};
	private Object[][] beautyItemsArray = new Object[][] {
			//
			{ "�ŵ�", R.drawable.ic_launcher },//
			{ "����", R.drawable.ic_launcher },//
			{ "�����", R.drawable.ic_launcher },//
			{ "��ˮ�Ҽ�", R.drawable.ic_launcher },//
			{ "̿��", R.drawable.ic_launcher },//
			{ "����������", R.drawable.ic_launcher },//
			{ "ϴ������", R.drawable.ic_launcher },//
			{ "����", R.drawable.ic_launcher },//
	};
	private Object[][] safeItemsArray = new Object[][]{
			//
			{ "��̥����", R.drawable.ic_launcher },//
			{ "��êӦ��", R.drawable.ic_launcher },//
			{ "Ӧ����Ԯ��", R.drawable.ic_launcher },//
			{ "�����Ծ�", R.drawable.ic_launcher },//
			{ "�ݳ�����", R.drawable.ic_launcher },//
			{ "ȼ������", R.drawable.ic_launcher },//
			{ "�����Լ�", R.drawable.ic_launcher },//
			{ "�泵����", R.drawable.ic_launcher },//
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
