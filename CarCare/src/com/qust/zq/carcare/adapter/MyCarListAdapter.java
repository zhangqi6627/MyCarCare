package com.qust.zq.carcare.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.utils.BitmapLoader;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCarListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<HashMap<String, String>> myCars;
	public MyCarListAdapter(Context context, ArrayList<HashMap<String, String>> myCars) {
		this.context = context;
		this.myCars = myCars;
	}
	@Override
	public int getCount() {
		return myCars.size();
	}
	@Override
	public Object getItem(int arg0) {
		return arg0;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	@Override
	public View getView(int position, View converView, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (converView == null) {
			converView = LayoutInflater.from(context).inflate(R.layout.adapter_car, null, false);
			viewHolder = new ViewHolder();
			viewHolder.iv_car = (ImageView) converView.findViewById(R.id.iv_car);
			viewHolder.tv_name = (TextView) converView.findViewById(R.id.tv_name);
			converView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) converView.getTag();
		}
		HashMap<String, String> carInfo = myCars.get(position);
		String name = (String) carInfo.get("name");
		viewHolder.iv_car.setImageResource(BitmapLoader.getCarBitmapByName(name));
		viewHolder.tv_name.setText(name);
		return converView;
	}
	public static class ViewHolder {
		private ImageView iv_car;
		private TextView tv_name;
	}
}