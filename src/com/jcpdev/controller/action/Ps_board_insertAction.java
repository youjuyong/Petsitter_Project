package com.jcpdev.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.jcpdev.dao.Ps_boardDao;

import com.jcpdev.dto.Ps_board;

public class Ps_board_insertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Ps_boardDao dao = Ps_boardDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		String path = "E:\\Program\\upload";
		int size=10*1024*1024;
		MultipartRequest mr = new MultipartRequest(request, path, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String ps_sdate = mr.getParameter("ps_sdate");
		String ps_fdate = mr.getParameter("ps_fdate");
		String[] p_size = mr.getParameterValues("size");
		String[] terms = mr.getParameterValues("terms");
		String m_addr = mr.getParameter("m_addr");
		String g_fname = mr.getFilesystemName("pic");
		String comment = mr.getParameter("comment");

		Date ps_sdate1 = Date.valueOf(ps_sdate);
		Date ps_fdate1 = Date.valueOf(ps_fdate);
		
		Ps_board dto = new Ps_board();
		dto.setIdx(idx);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPs_sdate(ps_sdate1);
		dto.setPs_fdate(ps_fdate1);
		dto.setP_size(Arrays.toString(p_size));
		dto.setTerms(Arrays.toString(terms));
		dto.setM_addr(m_addr);
		dto.setG_fname(g_fname);
		dto.setComment(comment);
		
		dao.psb_insert(dto);	// 펫시터게시글(ps_board) insert
		
		String message = "내용저장이 완료되었습니다.";
		String message2 = "펫정보를 입력해주세요.";
		String url = "./community/pet_insert.jsp";
		
		request.setAttribute("message", message);
		request.setAttribute("message2", message2);
		request.setAttribute("url", url);
		
		
		forward.isRedirect = false;
		//이게 문제죠. jsp로는 화면에 데이터 뿌려주러 가는건데 false 가되야하는거고
		//만약에 다른 url로 갈거면 아래가 index.jsp가 아니죠.
		//서블릿에서 정한 url 이 되야죠. 이거 엑셀로 계속 띄워놓는 화면인데
		forward.url = "./error/alert.jsp";
		return forward;
	}

}
