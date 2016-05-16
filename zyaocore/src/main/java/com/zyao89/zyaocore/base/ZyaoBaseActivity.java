package com.zyao89.zyaocore.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.zyao89.zyaocore.base.presenter.ZyaoPresenterManager;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public abstract class ZyaoBaseActivity<PresenterType extends ZyaoBasePresenter> extends AppCompatActivity
{
	private PresenterType mPresenter;
	public static final String PRESENTER_ID = "presenter_id";
	private boolean hasPresenter;

	public PresenterType getPresenter()
	{
		return mPresenter;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		preCreatePresenter(savedInstanceState);
	}

	private void preCreatePresenter(Bundle savedInstanceState)
	{
		String id;
		if (savedInstanceState == null || (id = savedInstanceState.getString(PRESENTER_ID)) == null)
		{
			createPresenter(savedInstanceState);
		}
		else
		{
			mPresenter = ZyaoPresenterManager.getInstance().get(id);
			if (mPresenter == null)
			{
				createPresenter(savedInstanceState);
			}
		}
	}

	private void createPresenter(Bundle savedInstanceState)
	{
		mPresenter = ZyaoPresenterManager.getInstance().create(this);
		hasPresenter = ensurePresenterInstance();
		if (hasPresenter)
			mPresenter.create(this, savedInstanceState);
	}

	private boolean ensurePresenterInstance()
	{
		if (mPresenter == null)
		{
			if (hasPresenter)
			{
				//能执行到这里就是见鬼了。表示View所对应的Presenter莫名其妙消失了。单独的View存在是很容易空指针的，所以直接重建最好。
				recreate();
			}
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		if (ensurePresenterInstance())
		{
			mPresenter.onDestroy();
			ZyaoPresenterManager.getInstance().destroy(mPresenter.id);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		if (ensurePresenterInstance())
			mPresenter.onPostCreate(savedInstanceState);
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		super.onPostCreate(savedInstanceState, persistentState);
		if (ensurePresenterInstance())
			mPresenter.onPostCreate(savedInstanceState, persistentState);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		if (ensurePresenterInstance())
			mPresenter.onResume();
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		if (ensurePresenterInstance())
			mPresenter.onPause();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		if (ensurePresenterInstance())
		{
			outState.putString(PRESENTER_ID, mPresenter.id);
			mPresenter.onSaveInstanceState(outState);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if (ensurePresenterInstance())
			mPresenter.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onContentChanged()
	{
		super.onContentChanged();
		if (ensurePresenterInstance())
			mPresenter.onContentChanged();
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		if (ensurePresenterInstance())
			mPresenter.onStart();
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		if (ensurePresenterInstance())
			mPresenter.onRestart();
	}

	@Override
	protected void onPostResume()
	{
		super.onPostResume();
		if (ensurePresenterInstance())
			mPresenter.onPostResume();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		super.onRestoreInstanceState(savedInstanceState);
		if (ensurePresenterInstance())
			mPresenter.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		super.onRestoreInstanceState(savedInstanceState, persistentState);
		if (ensurePresenterInstance())
			mPresenter.onRestoreInstanceState(savedInstanceState, persistentState);
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)
	{
		super.onSaveInstanceState(outState, outPersistentState);
		if (ensurePresenterInstance())
			mPresenter.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	protected void onUserLeaveHint()
	{
		super.onUserLeaveHint();
		if (ensurePresenterInstance())
			mPresenter.onUserLeaveHint();
	}

	@Override
	protected void onNewIntent(Intent intent)
	{
		super.onNewIntent(intent);
		if (ensurePresenterInstance())
			mPresenter.onNewIntent(intent);
	}

	@Override
	public void onLowMemory()
	{
		super.onLowMemory();
		if (ensurePresenterInstance())
			mPresenter.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level)
	{
		super.onTrimMemory(level);
		if (ensurePresenterInstance())
			mPresenter.onTrimMemory(level);
	}

	@Override
	public void onAttachFragment(Fragment fragment)
	{
		super.onAttachFragment(fragment);
		if (ensurePresenterInstance())
			mPresenter.onAttachFragment(fragment);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		if (ensurePresenterInstance())
			mPresenter.onBackPressed();
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		if (ensurePresenterInstance())
			mPresenter.onStop();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		if (ensurePresenterInstance())
			mPresenter.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onResumeFragments()
	{
		super.onResumeFragments();
		if (ensurePresenterInstance())
			mPresenter.onResumeFragments();
	}
}
