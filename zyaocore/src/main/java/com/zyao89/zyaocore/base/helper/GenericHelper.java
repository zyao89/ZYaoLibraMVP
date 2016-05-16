package com.zyao89.zyaocore.base.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by qibin on 2015/11/15.
 */
public class GenericHelper
{

	public static <T> Class<T> getViewClass(Class<?> klass)
	{
		Type type = klass.getGenericSuperclass();
		if (type == null || !(type instanceof ParameterizedType))
			return null;
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] types = parameterizedType.getActualTypeArguments();
		if (types == null || types.length == 0)
			return null;
		return (Class<T>) types[0];
	}

	public static <T> Class<T> getViewInterface(Class<?> klass)
	{
		Type[] types = klass.getGenericInterfaces();
		if (types == null)
		{
			return null;
		}
		for (Type type : types)
		{
			if (type == null || !(type instanceof ParameterizedType))
				continue;
			ParameterizedType parameterizedType = (ParameterizedType) type;
			types = parameterizedType.getActualTypeArguments();
			if (types == null || types.length == 0)
				continue;
			return (Class<T>) types[0];
		}
		return null;
	}
}
