package com.sandu.erp.config.map;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误管理map
 */
@Slf4j
public class ErrorMessageMap {
	
	/**
	 * 声明一个用于存放客户端连接的集合
	 */
	private static Map<String, Object> errorMessageMap;
	
	static {
		errorMessageMap = new HashMap<String, Object>(200);
	}

	/**
	 * 声明一个内部类，通过内部类来初始化本类，保证本类只会有一个实例
	 */
	private static class CustomerStringManagerHolder {
		private static final ErrorMessageMap INSTANCE = new ErrorMessageMap();
	}
	
	/**
	 * 私有化本类构造方法，避免通过外部创建类实例
	 */
	private ErrorMessageMap() {
	}
	
	/**
	 * 提供类实例初始化方法
	 */
	public static final ErrorMessageMap getInstance() {
		return CustomerStringManagerHolder.INSTANCE;
	}
	
	
	/********************************************************************
	 * 保存客户端连接
	 * @param key 连接标识
	 * @param value 客户端连接
	 */
	public static final void putString(String key, Object value) {
		errorMessageMap.put(key, value);
	}
	
	
	/**
	 * 通过value
	 * @param key 连接标识
	 * @return io.netty.String.String
	 */
	public static final Object getString(String key) {
		return errorMessageMap.get(key);
	}
	
	/**
	 * 释放客户端连接
	 * @param String
	 */
	public static final void releaseString(String String) {
		errorMessageMap.remove(String);
	}

	/**
	 * 获取全部map
	 * @return Map<String, String>
	 */
	public static final Map<String, Object> getAllString() {
		return errorMessageMap;
	}
	
}