package com.zyao89.zyaocore.base.presenter;


import com.zyao89.zyaocore.base.ZyaoBasePresenter;

/**
 * Created by rharter on 4/26/15.
 */
public class ZyaoPresenterBuilder
{
	public static <PresenterType extends ZyaoBasePresenter> PresenterType fromViewClass(Class<?> viewClass)
	{
		RegisterPresenter annotation = viewClass.getAnnotation(RegisterPresenter.class);
		//noinspection unchecked
		if (annotation == null)
		{
			return null;
			//throw new RuntimeException("You must declaration @RegisterPresenter for your Activity");
		}

		Class<PresenterType> presenterClass = (Class<PresenterType>) annotation.value();

		PresenterType presenter;
		try
		{
			presenter = presenterClass.newInstance();
		} catch (InstantiationException e)
		{
			throw new RuntimeException(e);
		} catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		return presenter;
	}

}
