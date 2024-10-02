package com.hk.board.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.board.dtos.HkDto;

public interface IHkDao {

	public List<HkDto> getAllList();
	public boolean insertBoard(HkDto dto);
	public HkDto getBoard(int seq);
	public boolean updateBoard(HkDto dto);
	public boolean delBoard(int seq);
	public boolean mulDel(String[] chks);
}




