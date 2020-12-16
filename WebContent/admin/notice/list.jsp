<%@page import="gc.service.notice.NoticeService"%>
<%@page import="gc.entity.notice.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin page</title>
    <link rel="stylesheet" href="../../CSS/reset.css" />
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
                <li><a href="../index.html">게시판관리</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </nav>
    </header>

    <div id="body" class="body">
        <aside class="aside">
            <h1 class="aside-title">일반 게시물 관리</h1>
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
                <h1>공지사항 리스트</h1>
                <span class="span1"> home > 게시판관리 > 공지사항 </span>
            </div>

            <main id="main" class="main">
                <section id="content" class="content">
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
                            	<td class="title indent text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
                                <td class="no">${n.adminNicname}</td>
                                <td class="date">${n.regDate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="pagelist">
                       <div><a href="">이전</a></div>
                       <ul>
                        <c:forEach var="i" begin="0" end="4" varStatus="st">
                            <li><a href="">${i+1}</a></li>
                        </c:forEach>
                       </ul>
                       <div><a href="">다음</a></div>
                   	</div>
                        <a href="reg"><button class="butt">등록</button></a>
                    <!-- <div class="search-bar">
                        <h1 class="no-display">검색 키워드</h1>
                        <select>
                            <option value="bbs-title">제목</option>
                            <option value="bbs-content">내용</option>
                            <option value="user-id">아이디</option>
                            <option value="bbs-name">이름</option>
                            <option value="user-nick">닉네임</option>
                            <option value="bbs-ip">IP주소</option>
                            <option value="good-name">상품명</option>
                            <option value="good-code">상품코드</option>
                        </select>
                        <input type="text" value="">
                        <input type="button" value="검색">
                    </div> -->
                </section>
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