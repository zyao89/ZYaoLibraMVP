package com.zyao89.zyaocore.base.presenter;

import com.zyao89.zyaocore.base.ZyaoBasePresenter;
import com.zyao89.zyaocore.base.ZyaoDefaultPresenterManager;

/**
 * Created by Zyao89 on 2016/5/14.
 */
public abstract class ZyaoPresenterManager
{
	private static ZyaoPresenterManager instance = new ZyaoDefaultPresenterManager();

	public static ZyaoPresenterManager getInstance()
	{
		return instance;
	}

	public abstract <T extends ZyaoBasePresenter> T create(Object view);

	public abstract <T extends ZyaoBasePresenter> T get(String id);

	public abstract void destroy(String id);
}
