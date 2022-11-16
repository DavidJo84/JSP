package com.human.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.BoardDAO;
import com.human.vo.BoardVO;

/**
 * Servlet implementation class wrAction
 */
@WebServlet("/wrAction")
public class wrAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public wrAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO boardDao = new BoardDAO();
		request.setCharacterEncoding("UTF-8");//받은 파라미터 인코딩
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(name + "/" + pass + "/" + email + "/" + title + "/" + content);
		
		BoardVO boardVo = new BoardVO();
		boardVo.setName(name);
		boardVo.setPass(pass);
		boardVo.setEmail(email);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		
		if(name!=null) {
			boardDao.insert(boardVo);
		}else {
			System.out.println("입력할 글이 없습니다.");
		}

		// DB insert작업

		response.sendRedirect("BoardList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
