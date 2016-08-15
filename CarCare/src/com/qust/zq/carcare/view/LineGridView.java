package com.qust.zq.carcare.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.qust.zq.carcare.R;

public class LineGridView extends GridView {
	public LineGridView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public LineGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public LineGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		View localView1 = getChildAt(0);
		int column = 0;
		if(localView1 != null){
			column = getWidth() / localView1.getWidth();// 计算出一共有多少列，假设有3列
		}
		int childCount = getChildCount();// 子view的总数
		System.out.println("子view的总数childCount==" + childCount+" "+column);
		Paint localPaint;// 画笔
		localPaint = new Paint();
		localPaint.setStyle(Paint.Style.STROKE);
		localPaint.setColor(getContext().getResources().getColor(R.color.line));// 设置画笔的颜色
		for (int i = 0; i < childCount; i++) {// 遍历子view
			View cellView = getChildAt(i);// 获取子view
			if (i < column) {// 第一行
				//top line
				canvas.drawLine(cellView.getLeft(), cellView.getTop(), cellView.getRight(), cellView.getTop(), localPaint);
			}
			if (i % column == 0) {// 第一列
				//left line
				canvas.drawLine(cellView.getLeft(), cellView.getTop(), cellView.getLeft(), cellView.getBottom(), localPaint);
			}
			// bottom line
			canvas.drawLine(cellView.getLeft(), cellView.getBottom() -1, cellView.getRight(), cellView.getBottom()-1, localPaint);
			// right line
			canvas.drawLine(cellView.getRight()-1, cellView.getTop(), cellView.getRight()-1, cellView.getBottom(), localPaint);
		}
	}
}