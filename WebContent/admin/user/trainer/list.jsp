<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin Page</title>

    <link rel="stylesheet" href="../../../CSS/reset.css">
    <link rel="stylesheet" href="../../../CSS/style.css">
    <link rel="stylesheet" href="../../../CSS/admin/admin.css">
    <link rel="stylesheet" href="../../../CSS/admin/user/index.css">
    <script src="../../../js/admin/user/trainer/list.js"></script>
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
        <a href="../index"><h1 class="img-button user-button">회원관리</h1></a>
        <ul class="aside-menu">
            <li>회원 관리</li>
            <ul>
                <li><a href="../list">회원 리스트</a></li>
                <li><a href="../leave">탈퇴회원 리스트</a></li>
            </ul>
            <li>제휴시설 관리</li>
            <ul>
              <li><a href="">제휴업체 리스트</a></li>
              <li><a href="">제휴업체 </a></li>
          	</ul>
            <li>트레이너회원 관리</li>
            <ul>
                <li><a href="list">트레이너회원 리스트</a></li>
                <li><a href="dellist">트레이너회원 삭제</a></li>
            </ul>
        </ul>
    </aside>

    <section class="main-section">
        <main class="main">
            <div class="main-head">
                <h1>트레이너회원 리스트</h1>
                <span>home > 트레이너회원 관리 > 트레이너회원 리스트</span>
            </div>
            <div class="main-body">
              <section>
                  <h1>트레이너회원 검색</h1>
                  <form action="list" method="post">
                      <table>
                          <tr>
                              <th>이름</th>
                              <td><input type="text" name="name"></td>
                          </tr>
                          <tr>
                              <th>소속</th>
                              <td><input type="text" name="gymName"></td>
                          </tr>
                          <tr>
                              <th>휴대폰</th>
                              <td class="phone"><input type="text" name="phone" >(- 포함)</td>
                          </tr>
                          
                      </table>

                      <input class="form-button" type="submit" value="검색">
                  </form>
              </section>
              <section class="table">
                  <h1>검색결과</h1>
                  <table class="list-table" border="1">
                      <tr>
                          <th>번호</th>
                          <th>이름</th>
                          <th>소속</th>
                          <th>휴대폰</th>
                          <th>성별</th>
                          <th>자세히</th>
                          <th>비고</th>
                      </tr>
                      <c:forEach var="t" items="${list }">
	                      <tr>
	                          <td class="trainer-id">${t.id }</td>
	                          <td>${t.name }</td>
	                          <td>${t.gymName }</td>
	                          <td>${t.phone }</td>
	                          <td>${t.gender }</td>
	                          <td><input class="detail" type="button" value="자세히" > </td>
	                          <td></td>
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