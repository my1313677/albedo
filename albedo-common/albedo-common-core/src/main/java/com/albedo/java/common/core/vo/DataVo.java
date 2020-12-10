package com.albedo.java.common.core.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 通常的数据基类 copyright 2014 albedo all right reserved author somewhere created on 2014年12月31日 下午1:57:09
 *
 * @author somewhere
 */
@Data
public class DataVo<PK extends Serializable> extends GeneralDto {
	private PK id;
	private String createdBy;
	private LocalDateTime createdDate;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	@JsonIgnore
	private Integer version;
	@JsonIgnore
	private String delFlag;
	private String description;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		return Objects.equals(id, ((DataVo) o).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
