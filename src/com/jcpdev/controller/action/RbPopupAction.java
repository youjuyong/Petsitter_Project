package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.RbMemberDao;
import com.jcpdev.dto.RbMember;
import com.jcpdev.dto.PageDto;
import com.jcpdev.dto.PageDto3;

public class RbPopupAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward foward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		RbMemberDao dao = RbMemberDao.getInstance();
		int pageNo;
		if(request.getParameter("page")==null) pageNo=1;
		else pageNo = Integer.parseInt(request.getParameter("page"));   //page=1,2,3,4,.....

		int pageSize =15;		//ui로 변경하도록 구현할 수 있습니다.
//		int startNo=(pageNo-1)*pageSize;
		PageDto3 pageDto = new PageDto3(pageNo,dao.getCount(),pageSize);  //페이지처리에 필요한객체(값) 생성
		
		Map<String,Integer> map = new HashMap<>();
		map.put("pageSize",pageSize);
		map.put("startNo",pageDto.getStartNo());
		
	
		
		
		List<RbMember> pslist = dao.getList(map);

		//request.setAttribute("p_auth", p_auth);
		request.setAttribute("pageDto", pageDto);
		request.setAttribute("pslist", pslist);
		
		
		foward.isRedirect = false;
		foward.url="rbpopup.jsp";
		return foward;	
		
		
	}
}
