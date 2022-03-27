package com.vti.form.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.vti.validation.account.AccountEmailNotExists;
import com.vti.validation.account.AccountUsernameNotExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingAccountForm {
	
	@NotBlank(message = "{Account.createAccount.form.username.NotBlank}")
	@Length(min=8, max=20, message = "{Account.createAccount.form.username.LengthRange}")
	@AccountUsernameNotExists(message = "{Account.createAccount.form.username.NotExists}")
	private String username;

	@NotBlank(message = "{Account.createAccount.form.firstName.NotBlank}")
	@Length(max = 50, message = "{Account.createAccount.form.firstName.MaxLength}")
	private String firstName;

	@NotBlank(message = "{Account.createAccount.form.lastName.NotBlank}")
	@Length(max = 50, message = "{Account.createAccount.form.lastName.MaxLength}")
	private String lastName;
	
	@NotBlank(message = "{Account.createAccount.form.email.NotBlank}")
	@Length(max=50, message = "{Account.createAccount.form.email.LengthRange}")
	@Email(message = "{Account.createAccount.form.email.WrongFormat}")
	@AccountEmailNotExists(message = "{Account.createAccount.form.email.NotExists}")
	private String email;
}

