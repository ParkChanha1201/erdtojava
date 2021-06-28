package com.chcraft.erdtojava.api;

import com.chcraft.erd.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JavaParam {
	private Entity entity;
	private String packagePath;
	private boolean generateGetterAndSetter;
}
