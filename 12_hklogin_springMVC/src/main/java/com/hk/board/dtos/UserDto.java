package com.hk.board.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserDto {

	private int seq;
	@NonNull
	private String id;
	private String name;
	private String password;
	@NonNull
	private String address;
	@NonNull
	private String email;
	private String enabled;
	private String role;
	private Date regDate;
}
