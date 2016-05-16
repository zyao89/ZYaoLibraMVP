package com.zyao89.zyaolib;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.zyao89.zyaocore.base.ZyaoBasePresenter;
import com.zyao89.zyaocore.base.view.ZyaoBaseUIView;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public class UIView extends ZyaoBaseUIView<Presenter> implements ITestInter
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		Log.e("ZZZZZZZZZ", "UIView -- onCreate()。。。。");

		setContentView(R.layout.activity_main);

		Button btn1 = $(R.id.btn1);
		btn1.setTag("BTN1");
		registerEventOnClick(btn1);
	}

	@Override
	public void login()
	{
		Log.e("ZZZZZZZZZ", "UIView -- login()。。。。");
	}

}
