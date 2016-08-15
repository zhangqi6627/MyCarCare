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
			column = getWidth() / localView1.getWidth();// �����һ���ж����У�������3��
		}
		int childCount = getChildCount();// ��view������
		System.out.println("��view������childCount==" + childCount+" "+column);
		Paint localPaint;// ����
		localPaint = new Paint();
		localPaint.setStyle(Paint.Style.STROKE);
		localPaint.setColor(getContext().getResources().getColor(R.color.line));// ���û��ʵ���ɫ
		for (int i = 0; i < childCount; i++) {// ������view
			View cellView = getChildAt(i);// ��ȡ��view
			if (i < column) {// ��һ��
				//top line
				canvas.drawLine(cellView.getLeft(), cellView.getTop(), cellView.getRight(), cellView.getTop(), localPaint);
			}
			if (i % column == 0) {// ��һ��
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