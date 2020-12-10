package com.albedo.java.common.security.filter.warpper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * @author somewhere
 * @description
 * @date 2020/5/31 17:09
 */
public class ParameterRequestWrapper extends HttpServletRequestWrapper {

	/**
	 * 定义参数集合
	 */
	private Map<String, String> params;

	/**
	 * 需要一个request和 篡改之后的参数进行实例化
	 */
	public ParameterRequestWrapper(HttpServletRequest request, Map<String, String> params) {
		super(request);
		this.params = params;
	}

	/**
	 * 查找自定的Map进行返回
	 *
	 * @param name
	 * @return
	 */
	@Override
	public String getParameter(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
			//一个name可能对应多个value， 返回第一个
		} else if (v instanceof String[]) {
			String[] strArr = (String[]) v;
			if (strArr.length > 0) {
				return strArr[0];
			} else {
				return null;
			}
		} else if (v instanceof String) {
			return (String) v;
		} else {
			return v.toString();
		}
	}

	@Override
	public Map getParameterMap() {
		return params;
	}

	@Override
	public Enumeration getParameterNames() {
		return new Vector(params.keySet()).elements();
	}

	@Override
	public String[] getParameterValues(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			return (String[]) v;
		} else if (v instanceof String) {
			return new String[]{(String) v};
		} else {
			return new String[]{v.toString()};
		}
	}
}
