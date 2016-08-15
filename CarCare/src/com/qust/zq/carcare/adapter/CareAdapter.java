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
			converView = LayoutInflater.from(mContext).inflate(R.layout.adapter_care, null, false);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) converView.findViewById(R.id.imageView);
			viewHolder.textView = (TextView) converView.findViewById(R.id.textView);
			converView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) converView.getTag();
		}
		HashMap<String, Object> carInfo = careItems.get(position);
		String title = (String) carInfo.get("title");
		int image = (Integer) carInfo.get("image");
		viewHolder.imageView.setImageResource(image);
		viewHolder.textView.setText(title);
		return converView;
	}
	private static class ViewHolder{
		private ImageView imageView;
		private TextView textView;
	}
}