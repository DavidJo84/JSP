package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/QnaAction")
public class QnaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QnaAction() {
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
		request.setCharacterEncoding("UTF-8");// 받은 파라미터 인코딩
		response.setContentType("text/html; charset=UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String chk = request.getParameter("chk");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String jsp = request.getParameter("jsp");
		System.out.println(id+chk+title+content+jsp);

		BoardVO boardVo = new BoardVO();
		boardVo.setNum(num);
		boardVo.setId(id);
		boardVo.setName(name);
		boardVo.setPass(pass);
		boardVo.setChk(chk);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		// DB insert작업
		if(jsp.equals("qnaForm")) {
			boardDao.insert(boardVo);
			response.sendRedirect("QnaBoardList");
		}else if(jsp.equals("modyForm")){
			boardDao.mody(boardVo);
			String url = "QnaBoardView";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			request.setAttribute("num", num);
			dispatcher.forward(request, response);
		}

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
