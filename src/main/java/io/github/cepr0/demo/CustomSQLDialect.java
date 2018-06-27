package io.github.cepr0.demo;

import org.hibernate.dialect.HSQLDialect;

import java.sql.Types;

public class CustomSQLDialect extends HSQLDialect {
	public CustomSQLDialect() {
		super();
		registerColumnType(Types.OTHER, "clob");
	}
}
