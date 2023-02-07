package com.tcs.service.app.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Table(value = "roles")
@Setter
@ToString
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 3799391382734185168L;

	@Id
	@Column(value = "id_role")
	private Integer id;

	@Column
	private String rolName;

}
