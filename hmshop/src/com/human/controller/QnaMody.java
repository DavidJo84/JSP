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
 * Servlet implementation class QnaMody
 */
@WebServlet("/QnaMody")
public class QnaMody extends HttpServlet {
	BoardDAO bdao = new BoardDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaMody() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		String cnt = request.getParameter("cnt");
		BoardVO bvo = bdao.selectOne(num,cnt);
		String url = "/bbs/modyForm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("bvo", bvo);
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
