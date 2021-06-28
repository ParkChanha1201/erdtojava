package com.chcraft.erdtojava.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chcraft.erd.Entity;
import com.chcraft.erd.utils.JavaFileGenerator;

@RestController
public class ApiController {
	@Autowired
	JavaFileGenerator jfg;

	@PostMapping("/java")
	public String toJava(@RequestBody Entity entity,@RequestBody String packagePath,@RequestBody boolean generateGetterAndSetter) {
		return jfg.generateFileString(entity, packagePath, generateGetterAndSetter);
	}
}
