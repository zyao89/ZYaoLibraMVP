package com.zyao89.zyaocore.base.presenter;

import com.zyao89.zyaocore.base.ZyaoBasePresenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterPresenter
{
    Class<? extends ZyaoBasePresenter> value();
}
