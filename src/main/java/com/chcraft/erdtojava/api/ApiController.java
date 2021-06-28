package com.chcraft.erdtojava.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Field;
import com.chcraft.erd.FieldOption;
import com.chcraft.erd.Relationship;
import com.chcraft.erd.Relationship.Relation;
import com.chcraft.erd.utils.SQLFileGenerator;
import com.chcraft.erd.utils.SimpleSQLFileGenerator;

@RestController
public class ApiController {
	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/test")
	public String test() {
		return "Webhook build test";
	}

	@GetMapping("/source")
	public String sourceTest() {
		Field field1 = new Field();
		field1.setOptions(new ArrayList<FieldOption>());
		field1.setName("foo");
		field1.addOption(FieldOption.PK);
		field1.setType("INT");

		Field field2 = new Field();
		field2.setOptions(new ArrayList<FieldOption>());
		field2.setName("goo");
		field2.setType("INT");

		Field field3 = new Field();
		field3.setOptions(new ArrayList<FieldOption>());
		field3.setName("hoo");
		field3.addOption(FieldOption.PK);
		field3.setType("INT");

		Entity entity = new Entity();
		entity.setName("test");
		entity.setFields(new ArrayList<Field>());
		entity.addField(field1);
		entity.addField(field2);

		Entity entity2 = new Entity();
		entity2.setName("target");
		entity2.setFields(new ArrayList<Field>());
		entity2.addField(field3);
		entity2.addField(field2);

		Relationship r = new Relationship();
		r.setRelation(Relation.MANY_TO_MANY);
		r.setEntity(entity);
		r.setOther(entity2);

		ArrayList<Entity> entities = new ArrayList<>();
		entities.add(entity);
		entities.add(entity2);

		ArrayList<Relationship> relationships = new ArrayList<Relationship>();
		relationships.add(r);

		SQLFileGenerator sfg = new SimpleSQLFileGenerator();
		return sfg.generateFileString(entities, relationships);
	}
}
