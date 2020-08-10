package com.projectk.services.implementations.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class HomePageUtils {
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
		Map<Object, Boolean> map = new HashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
