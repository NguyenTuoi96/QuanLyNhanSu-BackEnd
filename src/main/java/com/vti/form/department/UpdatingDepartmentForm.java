package com.vti.form.department;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.vti.form.department.CreatingDepartmentForm.Account;
import com.vti.validation.account.AccountIDExists;
import com.vti.validation.department.DepartmentIDExists;
import com.vti.validation.department.DepartmentNameNotExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatingDepartmentForm {

	@NotBlank(message = "{Department.createDepartment.form.id.NotBlank}")
	@DepartmentIDExists(message = "{Department.createDepartment.form.departmentId.NotExists}")
	private int id;

	@NotBlank(message = "{Department.createDepartment.form.type.NotBlank}")
	@Pattern(regexp = "DEV|TEST|PM|ScrumMaster", message = "{Department.createDepartment.form.type.pattern}")
	private String type;

//	private List<@Valid Account> accounts;
//
//	@Data
//	@NoArgsConstructor
//	public static class Account {
//		
//		@NotNull(message = "{Account.createAccount.form.id.NotBlank}")
//		@AccountIDExists
//		private Integer id;
//		
//	}

}
