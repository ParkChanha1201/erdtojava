package com.chcraft.erd;

import java.util.List;

public class Entity {
	private String name;
	private List<Field> fields;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Field getPrimaryKey() {
		return fields.stream().findFirst().get();
	}

	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public boolean addField(Field field) {
		return fields.add(field);
	}

	public boolean removeField(Field field) {
		return fields.remove(field);
	}
}
