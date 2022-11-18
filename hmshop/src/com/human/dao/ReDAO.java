package com.human.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.human.vo.ReVO;

public class ReDAO {
private Connection conn = null;
	
	public ReDAO(){
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
	
	public void insert(ReVO reVo) {
		if(connect()) {
			String sql="insert into reBoard values (?,?,?,default)";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, reVo.getNum());
				psmt.setString(2, reVo.getReId());
				psmt.setString(3, reVo.getReContent());
				
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
	
	public ArrayList<ReVO> selectAll(String num) {
		ArrayList<ReVO> rList = new ArrayList<>();
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from reBoard where num=? order by reIndate desc";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					ReVO rvo = new ReVO();
					
					rvo.setReId(rs.getString("reId"));
					rvo.setReContent(rs.getString("reContent"));
					rvo.setReIndate(rs.getString("reIndate"));
					rList.add(rvo);
				}
				
				conn.close();
				
				System.out.println("조회성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("조회실패");
			}
		}
		return rList;
	}
	
//	public BoardVO selectOne(String num) {
//		ResultSet rs = null;
//		
//		if(connect()) {
//			try {
//				String sql="select * from qnaBoard where num =?";
//				PreparedStatement psmt = conn.prepareStatement(sql);
//				psmt.setString(1, num);
//				rs = psmt.executeQuery();
//				
//				if(rs.next()) {
//					BoardVO bvo = new BoardVO();
//					bvo.setId(rs.getString("id"));
//					bvo.setName(rs.getString("name"));
//					bvo.setNum(rs.getInt("num"));
//					bvo.setTitle(rs.getString("title"));
//					bvo.setContent(rs.getString("content"));
//					bvo.setChk(rs.getString("chk"));
//					bvo.setIndate(rs.getString("indate"));
//					bvo.setCnt(rs.getInt("cnt"));
//					return bvo;
//				}
//				
//				conn.close();
//				
//				System.out.println("조회성공");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("조회실패");
//			}
//		}
//		return null;
//	}
}
