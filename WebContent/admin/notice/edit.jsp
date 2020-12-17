<%@page import="gc.entity.notice.Notice"%>
<%@page import="gc.service.notice.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/reset.css" type="text/css">
    <link rel="stylesheet" href="../../CSS/admin/notice/edit.css" type="text/css">
    <title>공지사항 수정</title>
</head>

<body>
    <header id="header" class="header">
        <div class="logo-bar">
            <h1 class="no-display">근처</h1>
            <a href="">
                <div class="logo"></div>
            </a>
            <ul>
                <li><button class="logout">로그아웃</button></li>
            </ul>
        </div>
        <nav id="nav" class="nav">
            <h1 class="no-display">메뉴</h1>
            <ul>
                <li><a href="#">기본설정</a></li>
                <li><a href="#">상품관리</a></li>
                <li><a href="#">주문관리</a></li>
                <li><a href="#">회원관리</a></li>
                <li><a href="list">게시판관리</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </nav>
    </header>

    <div id="body" class="body">
        <aside class="aside">
            <h1 class="aside-title">ASIDE</h1>
            <ul class="aside-menu">
                <li>공지사항 관리</li>
                <ul>
                    <li><a href="list">공지사항 리스트</a></li>
                    <li><a href="reg">공지사항 등록</a></li>
                </ul>
                <br />
            </ul>
        </aside>

        <section class="main-section">
            <div class="main-title">
                <h1>공지사항 상세보기</h1>
                <span class="span1"> home > 게시판관리 > 공지사항 상세보기 </span>
            </div>
            <form action="edit" method="post">
	            <section id="content" class="content">
	                <h1 class="no-display">공지사항 등록 폼</h1>
	                <table class="table-wrap" border="1">
	                    <tr>
	                        <th>작&nbsp;성&nbsp;자</th>
	                        <td>&nbsp;&nbsp;관리자</td>
	                        <th>등&nbsp;록&nbsp;일</th>
	                        <td>
	                       		<fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd a hh:mm:ss"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>제&nbsp;&nbsp;&nbsp;&nbsp;목</th>
	                        <td colspan="3">
	                        	<input type="text" value='${n.title}'>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>내&nbsp;&nbsp;&nbsp;&nbsp;용</th>
	                        <td colspan="4"><textarea class="texta" name="content" cols="100" rows="30">${n.content}</textarea></td>
	                    </tr>
	                    <tr>
	                        <th>첨&nbsp;부&nbsp;파&nbsp;일</th>
	                        <td colspan="3" class="td-small">&nbsp;&nbsp;&nbsp;<input type="file" name="file"></td>
							<c:forTokens var="fileName" items="${n.files}" delims="," varStatus="st">
	                      	<fmt:formatDate var="year" value="${n.regDate}" pattern="yyyy"/>
	                      		<a download href="/static/notice/${year}/${n.id}/${fileName}">${fileName}</a> 
	                      		<c:if test="${st.last == false}">
	                      			/
	                      		</c:if>
	                      	</c:forTokens>
							</td>
	                    </tr>
	                </table>
	                <div class="other-btn btn">
	                    <input class="butt" type="button" value="저장">
	                    <a href="detail?id=${n.id}"><input class="butt" type="button"  value="취소"></a>
	                </div>
	            </section>
            </form>
        </section>
    </div>
    <section>
        <footer id="footer" class="footer">
            <h1>푸터</h1>
        </footer>
    </section>
</body>

</html>