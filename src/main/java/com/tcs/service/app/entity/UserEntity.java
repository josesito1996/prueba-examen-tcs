
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
@Table(value = "users")
@Setter
@ToString
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1193563143883747598L;

	@Id
	@Column(value = "id_user")
	private Integer id;

	@Column
	private String userName;

	@Column
	private String password;

	@Column
	private Integer idRole;

}
