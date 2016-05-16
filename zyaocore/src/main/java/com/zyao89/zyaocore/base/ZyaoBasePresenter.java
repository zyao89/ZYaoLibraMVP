package com.zyao89.zyaocore.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.zyao89.zyaocore.base.inter.IZyaoBaseUIView;
import com.zyao89.zyaocore.base.inter.ZyaoBaseInterface;
import com.zyao89.zyaocore.base.presenter.ZyaoPresenterManager;
import com.zyao89.zyaocore.base.view.ZyaoBaseUIView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public abstract class ZyaoBasePresenter<RootType extends ZyaoBaseActivity> implements View.OnClickListener
{
	String id;
	private RootType root;
	private Bundle   mSavedState;
	protected final List<ZyaoConnectionHelper<? extends ZyaoBasePresenter, ? extends ZyaoBaseInterface>> mConnectionHelperList = new ArrayList<>();
	protected List<ZyaoBasePresenter<RootType>> mSubPresenterList;
	
	/**
	 * activity 第一次create直到到主动退出Activity之前都不会调用。
	 */
	protected void onCreate(@NonNull RootType root, Bundle savedState)
	{
	}
	
	private final void onCreated(@NonNull Bundle savedState)
	{
		if (mConnectionHelperList != null)
		{
			for (ZyaoConnectionHelper helper : mConnectionHelperList)
			{
				helper.onCreate(savedState);
			}
		}
	}
	
	/**
	 * presenter销毁时的回调。代表着activity正式退出
	 */
	protected void onDestroy()
	{
		Log.e("ZZZZZZZZZZ", "Presenter -- onDestroy");
		
		if (mConnectionHelperList != null)
		{
			for (ZyaoConnectionHelper helper : mConnectionHelperList)
			{
				helper.onDestroy();
			}
			synchronized (this)
			{
				mConnectionHelperList.clear();
			}
		}

		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onDestroy();
			}
			synchronized (this)
			{
				mSubPresenterList.clear();
				mSubPresenterList = null;
			}
		}

		ZyaoPresenterManager.getInstance().destroy(id);
	}

	protected void onResume()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onResume();
			}
		}
	}

	protected void onPause()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onPause();
			}
		}
	}

	public void onPostCreate(Bundle savedInstanceState)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onPostCreate(savedInstanceState);
			}
		}
	}

	protected void onSaveInstanceState(@NonNull Bundle outState)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onSaveInstanceState(outState);
			}
		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onActivityResult(requestCode, resultCode, data);
			}
		}
	}

	public void onContentChanged()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onContentChanged();
			}
		}
	}

	protected void onStart()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onStart();
			}
		}
	}

	protected void onRestart()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onRestart();
			}
		}
	}

	public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onPostCreate(savedInstanceState, persistentState);
			}
		}
	}

	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onRestoreInstanceState(savedInstanceState);
			}
		}
	}

	public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onRestoreInstanceState(savedInstanceState, persistentState);
			}
		}
	}

	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onSaveInstanceState(outState, outPersistentState);
			}
		}
	}

	protected void onUserLeaveHint()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onUserLeaveHint();
			}
		}
	}

	protected void onNewIntent(Intent intent)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onNewIntent(intent);
			}
		}
	}

	public void onLowMemory()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onLowMemory();
			}
		}
	}

	public void onTrimMemory(int level)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onTrimMemory(level);
			}
		}
	}

	public void onAttachFragment(Fragment fragment)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onAttachFragment(fragment);
			}
		}
	}

	protected void onResumeFragments()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onResumeFragments();
			}
		}
	}

	public void onBackPressed()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onBackPressed();
			}
		}
	}

	protected void onStop()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onStop();
			}
		}
	}

	protected void onPostResume()
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onPostResume();
			}
		}
	}

	public void onConfigurationChanged(Configuration newConfig)
	{
		if (mSubPresenterList != null)
		{
			for (ZyaoBasePresenter presenter : mSubPresenterList)
			{
				presenter.onConfigurationChanged(newConfig);
			}
		}
	}

	@NonNull
	public final RootType getRoot()
	{
		return root;
	}

	void create(RootType root, Bundle savedState)
	{
		this.root = root;
		this.mSavedState = savedState;
		onCreate(root, savedState);
		onCreated(savedState);
	}

	protected <ViewType extends IZyaoBaseUIView> void addUIView(@NonNull ViewType view)
	{
		synchronized (this)
		{
			ZyaoConnectionHelper<ZyaoBasePresenter, ViewType> helper = new ZyaoConnectionHelper<ZyaoBasePresenter, ViewType>(this, view);
			if (!mConnectionHelperList.contains(helper))
				mConnectionHelperList.add(helper);
			else
				helper = null;
		}
	}

	protected <IViewType extends IZyaoBaseUIView, ViewType extends IZyaoBaseUIView> IViewType addUIView(@NonNull ViewType view, Class<IViewType> IkClass)
	{
		synchronized (this)
		{
			ZyaoConnectionHelper<ZyaoBasePresenter, ViewType> helper = new ZyaoConnectionHelper<ZyaoBasePresenter, ViewType>(this, view);
			if (!mConnectionHelperList.contains(helper))
				mConnectionHelperList.add(helper);
			else
				helper = null;
		}
		return (IViewType)view;
	}

	protected <ModelType extends ZyaoBaseInterface> void addModel(@NonNull ModelType model)
	{
		synchronized (this)
		{
			ZyaoConnectionHelper<ZyaoBasePresenter, ModelType> helper = new ZyaoConnectionHelper<ZyaoBasePresenter, ModelType>(this, model);
			if (!mConnectionHelperList.contains(helper))
				mConnectionHelperList.add(helper);
			else
				helper = null;
		}
	}

	public int countConnectionHelpers()
	{
		return mConnectionHelperList.size();
	}

	public synchronized void deleteConnectionHelper(ZyaoBaseInterface helper)
	{
		mConnectionHelperList.remove(helper);
	}

	public synchronized void deleteConnectionHelpers()
	{
		mConnectionHelperList.clear();
	}

	protected <PresenterType extends ZyaoBasePresenter<RootType>> void addPresenter(@NonNull PresenterType presenter)
	{
		synchronized (this)
		{
			if (mSubPresenterList == null)
				mSubPresenterList = new ArrayList<>();
			if (!mSubPresenterList.contains(presenter))
				mSubPresenterList.add(presenter);
			presenter.onCreate(root, mSavedState);
			onCreated(mSavedState);
		}
	}

	public int countSubPresenters()
	{
		return mSubPresenterList != null ? mSubPresenterList.size() : 0;
	}

	public synchronized <PresenterType extends ZyaoBasePresenter<RootType>> void deleteSubPresenter(PresenterType presenter)
	{
		if (mSubPresenterList != null)
			mSubPresenterList.remove(presenter);
	}

	public synchronized void deleteSubPresenters()
	{
		if (mSubPresenterList != null)
			mSubPresenterList.clear();
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof ZyaoBasePresenter)
		{
			return this.id.equals(((ZyaoBasePresenter) o).id) && this.root.equals(((ZyaoBasePresenter) o).root);
		}
		return super.equals(o);
	}
}
