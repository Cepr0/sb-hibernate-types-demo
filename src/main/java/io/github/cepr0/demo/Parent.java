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

	@Column(nullable = false)
	private String name;

	@Type(type = "json")
	@Column(columnDefinition = "text")
	private Details details;

	@Type(type = "json")
	private List<Child> children;

	@Type(type = "json")
	private JsonNode properties;

	protected Parent() {
	}

	public Parent(
			Integer id,
			String name,
			Details details,
			List<Child> children,
			JsonNode properties
	) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.children = children;
		this.properties = properties;
	}
}
