package io.github.cepr0.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "parents")
@TypeDefs({
		@TypeDef(name = "string-array", typeClass = StringArrayType.class),
		@TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Parent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(columnDefinition = "text", nullable = false)
	private String name;

	@Type(type = "string-array")
	@Column(columnDefinition = "text[]")
	private String[] emails;

	@Type(type = "string-array")
	@Column(columnDefinition = "text[]")
	private String[] phones;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Details details;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private List<Child> children;

	@Type(type = "json")
	@Column(columnDefinition = "text") // a probably bug is here: 'json' type doesn't work
	private JsonNode properties;

	protected Parent() {
	}

	public Parent(
			Integer id,
			String name,
			String[] emails,
			String[] phones,
			Details details,
			List<Child> children,
			JsonNode properties
	) {
		this.id = id;
		this.name = name;
		this.emails = emails;
		this.phones = phones;
		this.details = details;
		this.children = children;
		this.properties = properties;
	}
}
