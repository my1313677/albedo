package com.albedo.java.common.core.util;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author somewhere
 * @description
 * @date 2020/5/31 17:07
 */
public class ComplexPropertyPreFilter implements PropertyPreFilter {
	private final Class<?> clazz;
	private final Set<String> includes = new HashSet<String>();
	private final Set<String> excludes = new HashSet<String>();

	public ComplexPropertyPreFilter(String... properties) {
		this(null, properties);
	}

	public ComplexPropertyPreFilter(Class<?> clazz, String... properties) {
		super();
		this.clazz = clazz;
		for (String item : properties) {
			if (item != null) {
				this.excludes.add(item);
			}
		}
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public Set<String> getIncludes() {
		return includes;
	}

	public Set<String> getExcludes() {
		return excludes;
	}

	@Override
	public boolean apply(JSONSerializer serializer, Object source, String name) {
		if (source == null) {
			return true;
		}

		if (clazz != null && !clazz.isInstance(source)) {
			return true;
		}

		if (this.excludes.contains(name)) {
			return false;
		}

		return includes.size() == 0 || includes.contains(name);
	}

}
