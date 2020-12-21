<%-- <%@page import="gc.service.notice.NoticeService"%> --%>
<%@page import="gc.entity.notice.Notice"%>
<%@page import="java.util.List"%>
<%@page import="gc.dao.notice.jdbc.JdbcNoticeDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>공지사항 목록</title>
    <link rel="stylesheet" href="../../CSS/reset.css" />
    <link rel="stylesheet" href="../../CSS/style.css" />
    <link rel="stylesheet" href="../../CSS/admin/admin.css" />
    <link rel="stylesheet" href="../../CSS/admin/notice/list.css" />
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
            <h1 class="aside-title img-button">공지사항관리</h1>
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
            <main id="main" class="main">
                <div class="main-head">
                    <h1>공지사항 리스트</h1>
                    <span> home > 게시판관리 > 공지사항 </span>
                </div>
                <div class="main-body">
                    <section class="main-body">
                            <h1 class="no-display">공지사항 목록</h1>
                            <table class="notice">
                                <thead>
                                    <tr>
                                        <td class="no">내용</td>
                                        <td class="no">작성자</td>
                                        <td class="no">등록일</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="n" items="${list}" >
                                    <tr>
                                        <td class="title-name"><a href="detail?id=${n.id}">${n.title}</a></td>
                                        <td class="no">${n.adminNicname}</td>
                                        <td class="date">${n.regDate}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="pagelist">
                            <c:if test="${page != 1}">
                            <a class="img-button before-button" href="list?page=${page-1}">이전</a>
                            </c:if>
                            <ul>
                                <c:forEach var="i" begin="1" end="${pageEnd}"> 
                                    <li><a href="list?page=${i}&size=${size}">${i}</a></li>
                                </c:forEach>
                            </ul>           
                            <c:if test="${page != pageEnd}">     
                                <a class="img-button next-button" href="list?page=${page+1}">다음</a>
                            </c:if>	
                                </div>
                                    <a href="reg"><button class="butt">등&nbsp;&nbsp;록</button></a>
                    </section>
                </div>
            </main>
        </section>
    </div>
    <section>
        <footer id="footer" class="footer">
            <h1>푸터</h1>
        </footer>
    </section>
</body>

</html>