<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin Page</title>

    <link rel="stylesheet" href="../../CSS/reset.css">
    <link rel="stylesheet" href="../../CSS/style.css">
    <link rel="stylesheet" href="../../CSS/admin/admin.css">
    <link rel="stylesheet" href="../../CSS/admin/user/index.css">
</head>
<body>
<header id="header" class="header">
   
    <div class="logo-bar">
        <h1 class="no-display">근처</h1>
        <a href="../index.html"><div class="logo"></div></a>
        <ul>
          <li><button class="logout">로그아웃</button></li>
        </ul>
    </div>

    <nav id="nav" class="nav">
        <h1 class="no-display">메뉴</h1>
        <ul>
            <li><a href="/admin/index.html">기본설정</a></li>
            <li><a href="/admin/product/list">상품관리</a></li>
            <li><a href="/admin/product-order/list">주문관리</a></li>
            <li><a href="/admin/user/index">회원관리</a></li>
            <li><a href="/admin/notice/list">게시판관리</a></li>
            <li><a href="#">고객센터</a></li>
        </ul>
    </nav>

</header>

<div id="body" class="body">
    <aside class="aside">
        <a href="index"><h1 class="img-button user-button">회원관리</h1></a>
        <ul class="aside-menu">
            <li>회원 관리</li>
            <ul>
                <li><a href="list">회원 리스트</a></li>
                <li><a href="leave">탈퇴회원 리스트</a></li>
            </ul>
            <li>제휴시설 관리</li>
            <ul>
              <li><a href="">제휴업체 리스트</a></li>
              <li><a href="">제휴업체 </a></li>
          	</ul>
            <li>트레이너회원 관리</li>
            <ul>
                <li><a href="trainer/list">트레이너회원 리스트</a></li>
                <li><a href="trainer/dellist">트레이너회원 삭제</a></li>
            </ul>
        </ul>
    </aside>
    
    <section class="main-section"">
        <main class="main">
            <div class="main-head">
                <h1>탈퇴회원 리스트</h1>
                <span>home > 회원관리 > 탈퇴회원 리스트</span>
            </div>
            <div class="main-body">
                <section>
                    <h1>탈퇴회원 검색</h1>
                    <form method="post" action="leave">
                        <table >
                            <tr>
                                <th>구분</th>
                                <td>
                                    <select>
                                        <option>전체</option>
                                        <option>탈퇴 요청</option>
                                        <option>탈퇴 승인</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>신청구분</th>
                                <td>
                                    <input type="radio" name="signintype" value="all">
                                    <label for="all">전체</label>
                                    <input type="radio" name="signintype" value="user">
                                    <label for="user">일반 회원</label>
                                    <input type="radio" name="signintype" value="gym">
                                    <label for="gym">제휴 시설</label>
                                </td>
                            </tr>
                            <tr>
							    <th>검색 키워드</th>
							    <td>
							      <select name="field">
							        <option value="name">이름</option>
							        <option value="nicname">아이디</option>
							        <option value="phone">휴대폰</option>
							      </select>
							      <input class="sel-text" type="text" name="query">
							    </td>
						  	</tr>
                        </table>

                        <input class="form-button" type="submit" value="검색">
                    </form>
                </section>
                <section class="table">
                    <h1>검색결과</h1>
                    <table border="1">
                        <tr>
                            <th>번호</th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>비고</th>
                            <th>처리</th>
                        </tr>
                        <c:forEach var="m" items="${list}">
	                        <tr>
	                            <td>${m.id }</td>
	                            <td>${m.nicname }</td>
	                            <td>${m.name }</td>
	                            <td></td>
	                            <td>
	                            	<a href="del?id=${m.id }">승인</a>
	                            </td>
	                        </tr>
                        </c:forEach>
                    </table>				
                </section>  
            </div>
        </main>
    </section>
</div>

</body>
</html>

