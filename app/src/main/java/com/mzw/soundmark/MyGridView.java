package com.mzw.soundmark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.GridView;

public class MyGridView extends GridView {

	private int index = -1;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MyGridView(Context context) {
		super(context);
		// TODO: do something here if you want
	}

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO: do something here if you want
	}

	public MyGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO: do something here if you want
	}

	/**
	 * 设置不滚动
	 * 其中onMeasure函数决定了组件显示的高度与宽度；
	 * makeMeasureSpec函数中第一个函数决定布局空间的大小，第二个参数是布局模式
	 * MeasureSpec.AT_MOST的意思就是子控件需要多大的控件就扩展到多大的空间
	 * 同样的道理，ListView也适用
	 */
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
//		return super.dispatchTouchEvent(ev);
		
		if(ev.getAction() == MotionEvent.ACTION_MOVE){
		           return true;//禁止Gridview进行滑动
		       }
		return super.dispatchTouchEvent(ev);
		
	}
	
}
