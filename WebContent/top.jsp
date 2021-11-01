<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <style>
	@import url('https://fonts.googleapis.com/css2?family=Gugi&display=swap');
	</style>
	
	<link rel= "stylesheet" href="css/top_bottom.css?v=3">
	<script>
	//HeaderToggle
	var prevScrollPos = window.pageYOffset;
	console.log("first Y offset: "+prevScrollPos)	//first value : 0
	window.onscroll = headerbarToggle
	function headerbarToggle(){
		var header = document.getElementById("headerbar");
		
		var currentScrollPos = window.pageYOffset;	// current Y offset
		if (prevScrollPos < currentScrollPos) {
			header.style.opacity = '0.8';
		}else{
			header.style.opacity = '0';
		}
	}
		
	</script>
	<header>
	<div id="headerbar" onscroll="headerbarToggle()"></div>
	
    <a class="home" href="index.do">개잘돌봄</a>
	<section>
	<c:if test="${sessionScope.readIdx==null }">
	<%  StringBuilder readIdx=new StringBuilder("/");
		session.setAttribute("readIdx", readIdx);	
	%>
	</c:if>
  	<c:if test="${sessionScope.user == null }">
   		 <a class="login" href="login.do">로그인</a>
    </c:if>
    <c:if test="${sessionScope.user == null }">
   		 <a class="register" href="register.do">회원가입</a>
    </c:if>
	<c:if test="${sessionScope.user != null }">
		<!-- 로그인된 상태 -->
		<a class="mlist" href="list.do?">회원정보</a>
		<a class="logout" href="logout.do">로그아웃</a>
		<a class="infor">${user.nick}님  </a>
		<a class="point"  href="point.do?idx=${user.idx}">포인트 : ${user.point} </a> 
	</c:if>
	</section>
	
    <nav class="navMenu">
    	<div style="display: flex;">
	        <a class="menu" href="/psSelect.do">펫시터 찾기</a>
	        <a class="menu" href="/rblist.do">후기 게시판</a>
	        <a class="menu" href="/qnaList.do">이용 문의</a>
	        <c:if test="${user != null}">
	        	<c:if test="${user.p_auth == '미지원'}">
	        		<a class="menu" href="https://forms.gle/pXuxMHSjdb5edSr5A">펫시터 지원</a>
	        	</c:if>
	        </c:if>
	        <c:if test="${user.p_auth == '지원'}">
		   		<form action="ps_board_write.do">
		   			<a class="menu" style="width: 150px;" href="/ps_board_write.do?idx=${user.idx}">펫시터 게시글 작성</a>
		   		</form>
	        </c:if>
	       	<div class="dot"></div>
    	</div>
    </nav>
    
	</header>
