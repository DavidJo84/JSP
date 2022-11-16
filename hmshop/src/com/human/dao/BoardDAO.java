package com.human.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String sql="insert into qnaBoard values (qnaboard_cnt.nextval,?,?,?,?,?,?,default,default)";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, boardVo.getId());
				psmt.setString(2, boardVo.getName());
				psmt.setString(3, boardVo.getPass());
				psmt.setString(4, boardVo.getTitle());
				psmt.setString(5, boardVo.getContent());
				psmt.setString(6, boardVo.getChk());
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
	
	public ArrayList<BoardVO> selectAll() {
		ArrayList<BoardVO> bList = new ArrayList<>();
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from qnaboard order by num";
			
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					BoardVO bvo = new BoardVO();
					bvo.setNum(rs.getInt("num"));
					bvo.setId(rs.getString("id"));
					bvo.setName(rs.getString("name"));
					bvo.setPass(rs.getString("pass"));
					bvo.setTitle(rs.getString("title"));
					bvo.setIndate(rs.getString("indate"));
					bvo.setChk(rs.getString("chk"));
					bvo.setCnt(rs.getInt("cnt"));
					bList.add(bvo);
				}
				
				conn.close();
				
				System.out.println("조회성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("조회실패");
			}
		}
		return bList;
	}
	
	public BoardVO selectOne(String num) {
		ResultSet rs = null;
		
		if(connect()) {
			try {
				String sql="select * from qnaBoard where num =?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					BoardVO bvo = new BoardVO();
					bvo.setId(rs.getString("id"));
					bvo.setName(rs.getString("name"));
					bvo.setNum(rs.getInt("num"));
					bvo.setTitle(rs.getString("title"));
					bvo.setContent(rs.getString("content"));
					bvo.setChk(rs.getString("chk"));
					bvo.setIndate(rs.getString("indate"));
					bvo.setCnt(rs.getInt("cnt"));
					return bvo;
				}
				
				conn.close();
				
				System.out.println("조회성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("조회실패");
			}
		}
		return null;
	}

}
