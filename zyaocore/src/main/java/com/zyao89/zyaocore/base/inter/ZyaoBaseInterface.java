package com.zyao89.zyaocore.base.inter;

import android.os.Bundle;

import com.zyao89.zyaocore.base.ZyaoBasePresenter;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public interface ZyaoBaseInterface
{
	<T extends ZyaoBasePresenter> void onCreate(T presenter, Bundle savedInstanceState);

	void onDestroy();
}
