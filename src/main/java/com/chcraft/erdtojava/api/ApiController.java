package com.chcraft.erdtojava.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Relationship;
import com.chcraft.erd.utils.JavaFileGenerator;
import com.chcraft.erd.utils.SQLFileGenerator;
import com.chcraft.erdtojava.api.param.JavaParam;
import com.chcraft.erdtojava.api.param.SQLParam;

@RestController
public class ApiController {
	@Autowired
	JavaFileGenerator jfg;
	@Autowired
	SQLFileGenerator sfg;

	@CrossOrigin("*")
	@PostMapping("/java")
	public String toJava(@RequestBody JavaParam param) {
		return jfg.generateFileString(param.getEntity(), param.getPackagePath(), param.isGenerateGetterAndSetter());
	}

	@CrossOrigin("*")
	@PostMapping("/sql")
	public String toSQL(@RequestBody SQLParam param) {
		return sfg.generateFileString(param.getEntities(), param.getRelationships());
	}

	@CrossOrigin("*")
	@PostMapping("/sql/entity")
	public String entityToSQL(@RequestBody Entity entity) {
		return sfg.generateEntity(entity);
	}

	@CrossOrigin("*")
	@PostMapping("/sql/relationship")
	public String relationshipToSQL(@RequestBody Relationship relationship) {
		return sfg.generateRelationship(relationship);
	}
}
