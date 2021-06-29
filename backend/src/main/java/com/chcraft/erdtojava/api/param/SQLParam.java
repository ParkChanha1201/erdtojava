package com.chcraft.erdtojava.api.param;

import java.util.List;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Relationship;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SQLParam {
	List<Entity> entities;
	List<Relationship> relationships;
}
