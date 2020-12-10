package com.albedo.java.modules.gen.domain;

import com.albedo.java.common.core.util.StringUtil;
import com.albedo.java.common.persistence.domain.IdEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * 业务表Entity
 *
 * @author somewhere
 * @version 2013-10-15
 */
@TableName("gen_table")
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Table extends IdEntity<Table> {

	public static final String F_NAME = "name";
	public static final String F_NAMESANDTITLE = "nameAndTitle";
	private static final long serialVersionUID = 1L;
	@TableField("name")
	@Size(min = 1, max = 200)
	private String name;
	@TableField("comments")
	private String comments;
	@TableField("class_name")
	private String className;
	@TableField("parent_table")
	private String parentTable;
	@TableField("parent_table_fk")
	private String parentTableFk;

	@TableField(exist = false)
	@JSONField(serialize = false)
	private List<TableColumn> columnList;

	@JSONField(serialize = false)
	@TableField(exist = false)
	private Table parent;

	@TableField(exist = false)
	private List<Table> childList;

	@TableField(exist = false)
	private String nameAndTitle;
	@TableField(exist = false)
	private String nameLike;
	@TableField(exist = false)
	@JSONField(serialize = false)
	private List<String> pkList;
	@TableField(exist = false)
	@JSONField(serialize = false)
	private List<TableColumn> pkColumnList;
	@TableField(exist = false)
	private String category;
	@TableField(exist = false)
	@JSONField(serialize = false)
	private List<TableColumn> columnFormList;

	public Table(String id) {
		super();
		this.id = id;
	}

	public Table(String name, String comments) {
		this.name = name;
		this.comments = comments;
	}


	public String getName() {
		return StringUtil.lowerCase(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getParentTable() {
		return StringUtil.lowerCase(parentTable);
	}

	public void setParentTable(String parentTable) {
		this.parentTable = parentTable;
	}

	public String getParentTableJavaFieldFk() {
		return StringUtil.toCamelCase(parentTableFk);
	}

	public String getParentTableFk() {
		return StringUtil.lowerCase(parentTableFk);
	}

	public void setParentTableFk(String parentTableFk) {
		this.parentTableFk = parentTableFk;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 获取列名和说明
	 *
	 * @return
	 */
	public String getNameAndTitle() {
		if (StringUtil.isEmpty(nameAndTitle)) {
			nameAndTitle = getName() + (comments == null ? "" : "  :  " + comments);
		}
		return nameAndTitle;
	}

	public void setNameAndComments(String nameAndTitle) {
		this.nameAndTitle = nameAndTitle;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
