package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`Account`")
@Data
@NoArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "first_name", length = 50, nullable = false, updatable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false, updatable = false)
	private String lastName;

	@Column(name = "password", length = 12, nullable = false)
	private String password;

	@Column(name = "email", length = 50, nullable = false, updatable = false)
	private String email;

	@Formula(" concat(first_name, ' ', last_name) ")
	private String fullName;

	@Column(name = "`role`")
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@Column(name = "created_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;

	@Column(name = "login_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginDate;

	@Column(name = "ative_flg")
	private short ativeFlg = 0;

	public enum Role {
		ADMIN, MANAGER, EMPLOYEE
	}
}
