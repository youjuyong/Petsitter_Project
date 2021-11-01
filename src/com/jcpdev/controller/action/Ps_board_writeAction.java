package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.Ps_boardDao;
import com.jcpdev.dto.Member;

public class Ps_board_writeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		Ps_boardDao dao = Ps_boardDao.getInstance();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Member m_getLIst = dao.m_getList(idx);	// 회원정보 불러오기(펫시터)
		request.setAttribute("petsitter", m_getLIst);
		
		
		forward.isRedirect = false;
		forward.url = "./community/ps_board_write.jsp";
		
		
		
		return forward;
	}

}
