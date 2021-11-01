package com.jcpdev.controller.action;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.RbMemberDao;
import com.jcpdev.dto.RbMember;


public class SearchPsAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward foward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		RbMemberDao dao = RbMemberDao.getInstance();

		String nick = request.getParameter("nick");

			
		List<RbMember> result = dao.getPsList(nick);
		request.setAttribute("result", result);
		
		
		foward.isRedirect = false;
		foward.url="rbsearch_view.jsp";
		return foward;	
		
		
	}
}
