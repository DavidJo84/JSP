package com.hm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hm.VO.ClassVO;
import com.hm.VO.StudVO;

public class StudDAO {
	
	private Connection conn = null;

	public StudDAO() {
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
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@humanDB_high?TNS_ADMIN = C:/Users/human/Desktop/Wallet_humanDB", "admin",
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
	
	public void insert(StudVO svo) {
		String sql = "insert into member_hm values(?,?,?,?,?,?)";
		if(connect()) {
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, svo.getNo());
				psmt.setString(2, svo.getName());
				psmt.setString(3, svo.getTel());
				psmt.setString(4, svo.getAddress());
				psmt.setString(5, svo.getJoinDate());
				psmt.setString(6, svo.getGrade());
				psmt.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public ArrayList<StudVO> selectAll() {
		ResultSet rs;
		ArrayList<StudVO> sList = new ArrayList<>();
		String sql = "select * from member_hm";
		if(connect()) {
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					StudVO svo = new StudVO();
					svo.setNo(rs.getInt("no"));
					svo.setName(rs.getString("name"));
					svo.setTel(rs.getString("tel"));
					svo.setAddress(rs.getString("address"));
					svo.setJoinDate(rs.getString("joindate"));
					svo.setGrade(rs.getString("grade"));
					sList.add(svo);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sList;
		
	}
	
	public int getNo() {
		ResultSet rs;
		String sql = "select outo_no.nextval as no from dual";
		if(connect()) {
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					int no = rs.getInt("no");
					return no;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return -1;
	}

	public ArrayList<ClassVO> selectClass() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<ClassVO> cList = new ArrayList<>();
		String sql = "select a.name, b.class_name ,b.class_pro,c.indate from member_hm a, class_hm b, class_select c\r\n" + 
				"where a.no=c.no and b.class_no = c.class_no";
		if(connect()) {
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					ClassVO cvo = new ClassVO();
					cvo.setName(rs.getString("name"));
					cvo.setClass_name(rs.getString("class_name"));
					cvo.setClass_pro(rs.getString("class_pro"));
					cvo.setIndate(rs.getString("indate"));
					
					cList.add(cvo);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cList;
	}

}
