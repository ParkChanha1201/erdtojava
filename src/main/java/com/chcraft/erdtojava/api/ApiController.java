package com.chcraft.erdtojava.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Relationship;
import com.chcraft.erd.utils.JavaFileGenerator;
import com.chcraft.erd.utils.SQLFileGenerator;
import com.chcraft.erdtojava.api.param.JavaParam;

@RestController
public class ApiController {
	@Autowired
	JavaFileGenerator jfg;
	@Autowired
	SQLFileGenerator sfg;

	@PostMapping("/java")
	public String toJava(@RequestBody JavaParam param) {
		return jfg.generateFileString(param.getEntity(), param.getPackagePath(), param.isGenerateGetterAndSetter());
	}

	@PostMapping("/sql/entity")
	public String entityToSQL(@RequestBody Entity entity) {
		return sfg.generateEntity(entity);
	}

	@PostMapping("/sql/relationship")
	public String relationshipToSQL(@RequestBody Relationship relationship) {
		return sfg.generateRelationship(relationship);
	}
}
