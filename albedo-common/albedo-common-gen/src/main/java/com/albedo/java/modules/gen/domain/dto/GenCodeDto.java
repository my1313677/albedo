package com.albedo.java.modules.gen.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 生成方案Entity
 *
 * @author somewhere
 * @version 2013-10-15
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class GenCodeDto implements Serializable {

	private String id;
	/**
	 * 是否替换现有文件 true：替换文件 ；false：不替换；
	 */
	private Boolean replaceFile = false;

}
