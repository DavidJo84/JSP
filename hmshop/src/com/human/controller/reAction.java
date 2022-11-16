package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.ReDAO;
import com.human.vo.ReVO;

/**
 * Servlet implementation class reAction
 */
@WebServlet("/reAction")
public class reAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReDAO rdao = new ReDAO();
		request.setCharacterEncoding("UTF-8");// 받은 파라미터 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		String num = request.getParameter("num");
		String reId = request.getParameter("reId");
		String reContent = request.getParameter("reContent");
		System.out.println("글번호:"+ num);
		System.out.println("리뷰아이디:"+ reId);
		System.out.println("리뷰내용:"+ reContent);
		ReVO rvo = new ReVO();
		rvo.setNum(num);
		rvo.setReId(reId);
		rvo.setReContent(reContent);
		rdao.insert(rvo);
		
		//response.sendRedirect("QnaBoardView");
		String url = "QnaBoardView";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("num", num);
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
