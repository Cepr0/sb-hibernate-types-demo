package io.github.cepr0.demo;

import org.hibernate.dialect.H2Dialect;

import java.sql.Types;

public class CustomSQLDialect extends H2Dialect {
	public CustomSQLDialect() {
		super();
		registerColumnType(Types.OTHER, "clob");
	}
}
