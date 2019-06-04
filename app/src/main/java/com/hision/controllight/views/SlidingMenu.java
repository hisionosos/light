package com.hision.controllight.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.hision.controllight.R;
import com.hision.controllight.utils.ScreenUtils;

public class SlidingMenu extends HorizontalScrollView {
	private int mScreenWidth;
	private int mMenuRightPadding;
	private int mMenuWidth;
	private int mHalfMenuWidth;
	private boolean isOpen;
	private boolean once;
	
	public SlidingMenu(Context context) {
		this(context, null, 0);
	}
	
	public SlidingMenu(Context context, AttributeSet attrs) {
		this(context, attrs, 0);

		mScreenWidth = ScreenUtils.getScreenWidth(context);

		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SlidingMenu);
		int taCount = ta.getIndexCount();
		for (int i = 0; i < taCount; i++) {
			int index = ta.getIndex(i);
			System.out.println("index = " + index);

			switch (index) {
			case R.styleable.SlidingMenu_rightPadding:
				mMenuRightPadding = (int) ta.getDimension(index, 0);
				break;

			default:
				break;
			}
		}
	
	}

	public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mScreenWidth = ScreenUtils.getScreenWidth(context);

//		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
//				R.styleable.SlidingMenu, defStyle, 0);
//		int n = a.getIndexCount();
//		for (int i = 0; i < n; i++) {
//			int attr = a.getIndex(i);
//			switch (attr) {
//			case R.styleable.SlidingMenu_rightPadding:
//				mMenuRightPadding = a.getDimensionPixelSize(attr,
//						(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f,getResources().getDisplayMetrics()));// Ĭ��Ϊ10DP
//				break;
		
		
		
		
//			}
//		}
//		a.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (!once) {
			LinearLayout wrapper = (LinearLayout) getChildAt(0);
			ViewGroup menu = (ViewGroup) wrapper.getChildAt(0);
			ViewGroup content = (ViewGroup) wrapper.getChildAt(1);
			mMenuWidth = mScreenWidth - mMenuRightPadding;
			mHalfMenuWidth = mMenuWidth / 2;
			menu.getLayoutParams().width = mMenuWidth;
			content.getLayoutParams().width = mScreenWidth;

		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if (changed) {
			this.scrollTo(mMenuWidth, 0);
			once = true;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_UP:
			int scrollX = getScrollX();
			if (scrollX > mHalfMenuWidth) {
				this.smoothScrollTo(mMenuWidth, 0);
				isOpen = false;
			} else {
				this.smoothScrollTo(0, 0);
				isOpen = true;
			}
			return true;
		}
		return super.onTouchEvent(ev);
	}


	public void openMenu() {
		if (isOpen)
			return;
		this.smoothScrollTo(0, 0);
		isOpen = true;
	}


	public void closeMenu() {
		if (isOpen) {
			this.smoothScrollTo(mMenuWidth, 0);
			isOpen = false;
		}
	}

	public void toggle() {
		if (isOpen) {
			closeMenu();
		} else {
			openMenu();
		}
	}

}
