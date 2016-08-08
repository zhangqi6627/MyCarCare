package com.qust.zq.carcare.activity;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.BaseActivity;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.adapter.CareAdapter;
import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class CarCareActivity extends BaseActivity {
	private Context mContext = CarCareActivity.this;
	private ImageView iv_car;
	private GridView gv_care;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addContentView(R.layout.activity_carcare);
		iv_car = (ImageView) findViewById(R.id.iv_car);
		gv_care = (GridView) findViewById(R.id.gv_care);
		ArrayList<HashMap<String, Object>> careItems = new ArrayList<HashMap<String,Object>>();
		
		gv_care.setAdapter(new CareAdapter(mContext, careItems));	
		
	}
}

