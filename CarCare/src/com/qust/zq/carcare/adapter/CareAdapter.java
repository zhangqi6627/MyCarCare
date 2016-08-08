package com.qust.zq.carcare.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import com.qust.zq.carcare.R;
import com.qust.zq.carcare.adapter.MyCarListAdapter.ViewHolder;
import com.qust.zq.carcare.utils.BitmapLoader;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CareAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<HashMap<String, Object>> careItems = new ArrayList<HashMap<String, Object>>();
	public CareAdapter(Context context,ArrayList<HashMap<String, Object>> careItems) {
		this.mContext = context;
		this.careItems = careItems;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return careItems.size();
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	@Override
	public View getView(int position, View converView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (converView == null) {
			converView = LayoutInflater.from(mContext).inflate(R.layout.adapter_car, null, false);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) converView.findViewById(R.id.iv_car);
			viewHolder.textView = (TextView) converView.findViewById(R.id.tv_name);
			converView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) converView.getTag();
		}
		HashMap<String, Object> carInfo = careItems.get(position);
		String name = (String) carInfo.get("name");
		viewHolder.imageView.setImageResource(BitmapLoader.getCarBitmapByName(name));
		viewHolder.textView.setText(name);
		return converView;
	}
	private static class ViewHolder{
		private ImageView imageView;
		private TextView textView;
	}
}