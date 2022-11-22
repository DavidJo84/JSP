package com.hm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hm.DAO.StudDAO;
import com.hm.VO.StudVO;

/**
 * Servlet implementation class AddStud
 */
@WebServlet("/AddStud")
public class AddStud extends HttpServlet {
	StudDAO sdao = new StudDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		StudVO svo = new StudVO();
		svo.setNo(Integer.parseInt(request.getParameter("no")));
		svo.setName(request.getParameter("name"));
		svo.setTel(request.getParameter("tel"));
		svo.setAddress(request.getParameter("address"));
		svo.setJoinDate(request.getParameter("joindate"));
		svo.setGrade(request.getParameter("grade"));
		sdao.insert(svo);
		
		response.sendRedirect("Index");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
