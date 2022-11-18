package com.human.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.BoardDAO;
import com.human.dao.ReDAO;
import com.human.vo.BoardVO;
import com.human.vo.ReVO;

/**
 * Servlet implementation class BoardView
 */
@WebServlet("/QnaBoardView")
public class QnaBoardView extends HttpServlet {
	BoardDAO bdao = new BoardDAO();
	ReDAO rdao = new ReDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaBoardView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");// 받은 파라미터 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		String num = request.getParameter("num");
		String cnt = request.getParameter("cnt");
		BoardVO bvo = bdao.selectOne(num, cnt);
		ArrayList<ReVO> rList = rdao.selectAll(num);
		String url = "/bbs/view.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("bvo", bvo);
		request.setAttribute("rList", rList);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
