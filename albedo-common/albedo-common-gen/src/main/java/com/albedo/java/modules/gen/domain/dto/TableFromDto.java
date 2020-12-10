package com.albedo.java.modules.gen.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 业务表Entity
 *
 * @author somewhere
 * @version 2013-10-15
 */
@Data
@ToString
@NoArgsConstructor
public class TableFromDto implements Serializable {

	private static final long serialVersionUID = 1L;
	/*** 编码 */
	private String id;
	// 名称
	/*** 编码 */
	private String name;

}
