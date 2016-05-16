package com.zyao89.zyaocore.base.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zyao89.zyaocore.base.ZyaoBaseActivity;
import com.zyao89.zyaocore.base.ZyaoBasePresenter;
import com.zyao89.zyaocore.base.helper.EventHelper;
import com.zyao89.zyaocore.base.inter.IZyaoBaseUIView;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public abstract class ZyaoBaseUIView<PresenterType extends ZyaoBasePresenter>
{
	protected PresenterType mPresenter;

	public <T extends ZyaoBasePresenter> void onCreate(T presenter, Bundle savedInstanceState)
	{
		mPresenter = (PresenterType) presenter;
		onCreate(savedInstanceState);
	}

	public void onDestroy()
	{

	}

	protected abstract void onCreate(Bundle savedInstanceState);

	public ZyaoBaseActivity getRoot()
	{
		return mPresenter.getRoot();
	}

	public void registerEventOnClick(View ...views)
	{
		EventHelper.click(mPresenter, views);
	}

	public void setContentView(int layoutResID)
	{
		this.setContentView(getRoot().getLayoutInflater().inflate(layoutResID, null, false));
	}

	public void setContentView(View view)
	{
		this.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
	}

	public void setContentView(View view, ViewGroup.LayoutParams params)
	{
		getRoot().setContentView(view, params);
	}

	protected final <E extends View> E $(@NonNull View view, @IdRes int id)
	{
		return (E) view.findViewById(id);
	}

	protected final <E extends View> E viewId(@NonNull View view, @IdRes int id)
	{
		return (E) view.findViewById(id);
	}

	protected final <E extends View> E $(@IdRes int id)
	{
		return (E) getRoot().findViewById(id);
	}

	protected final <E extends View> E viewId(@IdRes int id)
	{
		return (E) getRoot().findViewById(id);
	}

	protected final <E extends View> E findViewById(@IdRes int id)
	{
		return (E) getRoot().findViewById(id);
	}

	protected final <E extends View> E findViewById(@NonNull View view, @IdRes int id)
	{
		return (E) view.findViewById(id);
	}
}
