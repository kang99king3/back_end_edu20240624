package com.hk.file.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
	
	private int seq;
	private String origin_name;
	private String stored_name;
	private int file_size;
	private Date f_regdate;
	
}
