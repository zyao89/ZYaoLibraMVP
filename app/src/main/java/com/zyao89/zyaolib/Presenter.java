package com.zyao89.zyaolib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zyao89.zyaocore.base.ZyaoBasePresenter;
import com.zyao89.zyaocore.base.helper.GenericHelper;

import java.util.List;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public class Presenter extends ZyaoBasePresenter<MainActivity>
{
	@Override
	protected void onCreate(@NonNull MainActivity root, Bundle savedState)
	{
		super.onCreate(root, savedState);

		ITestInter uiView1 = addUIView(new UIView(), ITestInter.class);

		Log.e("ZZZZZZZZ", "Presenter -- onCreate");

		uiView1.login();
	}

	@Override
	public void onClick(View v)
	{
		if (v.getTag().equals("BTN1")){
			Toast.makeText(getRoot(), "HHHHHAA", Toast.LENGTH_SHORT).show();
		}
	}
}
