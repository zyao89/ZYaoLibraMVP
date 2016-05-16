package com.zyao89.zyaolib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.zyao89.zyaocore.base.ZyaoBasePresenter;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public class Presenter2 extends ZyaoBasePresenter<MainActivity>
{
	@Override
	protected void onCreate(@NonNull MainActivity view, Bundle savedState)
	{
		super.onCreate(view, savedState);
		view.setContentView(R.layout.activity_main);

		addUIView(new UIView());

		Log.e("ZZZZZZZZ", "Presenter -- onCreate2");
	}

	@Override
	public void onClick(View v)
	{

	}
}
