package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.lotto.LottoNum;

/**
 * Servlet implementation class LottoView
 */
@WebServlet("/LottoView")
public class LottoView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LottoNum lottoNum = new LottoNum();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LottoView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "lotto/lotto.jsp";
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		if(!num1.equals("") && !num2.equals("")) {
			request.setAttribute("lottoAll", lottoNum.lottoAll(num1,num2));
		}else {
			request.setAttribute("lottoAll", lottoNum.lottoAll());  
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
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
