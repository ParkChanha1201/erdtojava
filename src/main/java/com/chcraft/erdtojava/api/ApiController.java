package com.chcraft.erdtojava.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chcraft.erd.utils.JavaFileGenerator;

@RestController
public class ApiController {
	@Autowired
	JavaFileGenerator jfg;

	@PostMapping("/java")
	public String toJava(@RequestBody JavaParam param) {
		return jfg.generateFileString(param.getEntity(), param.getPackagePath(), param.isGenerateGetterAndSetter());
	}
}
