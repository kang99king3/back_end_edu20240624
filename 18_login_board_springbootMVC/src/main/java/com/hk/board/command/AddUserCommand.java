package com.hk.board.command;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class AddUserCommand {

	@NotBlank(message = "아이디를 입력하세요")
	private String id;
	
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	
	@NotBlank(message = "비밀번호를 입력하세요")
	@Length(min = 8 , max = 16, message = "8자리이상, 16자이하로 입력하세요")
	private String password;
	
	@NotBlank(message = "이메일 입력하세요")
	private String email;
	
	@NotBlank(message = "주소를 입력하세요")
	private String address;

	public AddUserCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddUserCommand(@NotBlank(message = "아이디를 입력하세요") String id, @NotBlank(message = "이름을 입력하세요") String name,
			@NotBlank(message = "비밀번호를 입력하세요") @Length(min = 8, max = 16, message = "8자리이상, 16자이하로 입력하세요") String password,
			@NotBlank(message = "이메일 입력하세요") String email, @NotBlank(message = "주소를 입력하세요") String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddUserCommand [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}









