package com.zyao89.zyaocore.base;

import android.os.Bundle;

import com.zyao89.zyaocore.base.inter.ZyaoBaseInterface;

/**
 * A helper class to control presenter's lifecycle.
 */
class ZyaoConnectionHelper<PresenterType extends ZyaoBasePresenter, ConnType extends ZyaoBaseInterface>
{
	public PresenterType getPresenter()
	{
		return presenter;
	}

	public ConnType getObj()
	{
		return obj;
	}

	PresenterType presenter;
	ConnType      obj;

	public ZyaoConnectionHelper(PresenterType presenter, ConnType obj)
	{
		this.presenter = presenter;
		this.obj = obj;
	}

	public void onCreate(Bundle savedInstanceState)
	{
		if (obj != null)
			this.obj.onCreate(presenter, savedInstanceState);
	}

	protected void onDestroy()
	{
		if (obj != null)
			this.obj.onDestroy();
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof ZyaoConnectionHelper)
		{
			return this.presenter == ((ZyaoConnectionHelper) o).presenter && this.obj == ((ZyaoConnectionHelper) o).obj;
		}
		return super.equals(o);
	}

}
