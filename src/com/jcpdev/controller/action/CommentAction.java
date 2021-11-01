package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.CommentDao;
import com.jcpdev.dto.Comment;
public class CommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int c_mref;
		CommentDao c_dao = CommentDao.getInstance();
		request.setCharacterEncoding("UTF-8");   //getParameter 앞에 나와야합니다.
		int pageNo = Integer.parseInt(request.getParameter("page"));
		if(request.getParameter("del") != null){		//삭제
			int qc_idx = Integer.parseInt(request.getParameter("qc_idx"));
			int q_idx = Integer.parseInt(request.getParameter("q_idx"));
			c_dao.delete(qc_idx);
			c_mref=q_idx;
		} else {   //댓글 추가
			c_mref= Integer.parseInt(request.getParameter("q_idx"));
			int a_idx = Integer.parseInt(request.getParameter("a_idx"));
			String a_nick = request.getParameter("a_nick");
			String content = request.getParameter("qc_content");
			
			Comment c_dto = new Comment(0,c_mref,a_idx,content,a_nick, null);
			c_dao.insert(c_dto);
		}
		c_dao.updateCountAll(c_mref);ActionForward foward = new ActionForward();
		foward.isRedirect = true;
		foward.url="detail.do?page="+pageNo+"&q_idx="+ c_mref;
		return foward;
	}

}