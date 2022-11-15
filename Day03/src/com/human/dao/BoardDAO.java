package com.human.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.human.vo.BoardVO;

public class BoardDAO {
	private Connection conn = null;
	
	public BoardDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("로드실패");
		}
	}
	
	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@humanDB_high?TNS_ADMIN = C:/Users/human/Desktop/Wallet_humanDB", "admin",
					"Jb21499549954.");
			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("연결실패");
			e.printStackTrace();
			return false;
		}
	}
	
	public void insert(BoardVO boardVo) {
		if(connect()) {
			String sql="insert into board values (board_cnt.nextval,?,?,?,?,?,default,default)";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, boardVo.getName());
				psmt.setString(2, boardVo.getEmail());
				psmt.setString(3, boardVo.getTitle());
				psmt.setString(4, boardVo.getContent());
				psmt.setString(5, boardVo.getPass());
				psmt.executeUpdate();
				conn.close();
				
				System.out.println("입력성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("입력실패");
			}
		}
	}

}
