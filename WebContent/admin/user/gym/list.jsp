<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="gc.entity.gym.Gym" %>
<%@page import="gc.dao.gym.jdbc.JdbcGymDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin page</title>
    <link rel="stylesheet" href="../../../CSS/reset.css" type="text/css" />
    <link rel="stylesheet" href="../../../CSS/style.css">
    <link rel="stylesheet" href="../../../CSS/admin/admin.css" type="text/css" />
    <link rel="stylesheet" href="../../../CSS/admin/user/gym/list.css" type="text/css" />
    <script src ="../../../js/admin/user/gym/list.js"></script>
  </head>
  <body>
    <header id="header" class="header">
      <div class="logo-bar">
        <h1 class="no-display">근처</h1>
        <a href=""><div class="logo"></div></a>
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
        <h1 class="aside-title"><a href="user.html"><img src="../../../image/admin/member-aside.png" alt="회원관리"></a></h1>
        <ul class="aside-menu">
            <li>회원 관리</li>
            <ul>
                <li><a href="list">회원 리스트</a></li>
                <li><a href="leave">탈퇴회원 리스트</a></li>
            </ul>
            <li>제휴시설 관리</li>
            <ul>
              <li><a href="gym/list">제휴업체 리스트</a></li>
              <li><a href="">제휴업체 </a></li>
          	</ul>
            <li>트레이너회원 관리</li>
            <ul>
                <li><a href="trainer/list">트레이너회원 리스트</a></li>
                <li><a href="trainer/dellist">트레이너회원 삭제</a></li>
            </ul>
        </ul>
      </aside>
      <section class="main-section">
        <main id="main" class="main">
          <div class="main-head">
            <h1>제휴업체 리스트</h1>
            <span> home > 제휴업체 관리 > 제휴업체 리스트 </span>
          </div>
          <div class ="main-body">
          <section>
            <h1>제휴업체 검색</h1>
           	<form action="list">
              <table border="1">
                <tr>
                  <th>검색 키워드</th>
                  <td>
                  <select name = "field">
                      <option value = "NAME">이름</option>            
                      <option value ="GYM_NAME">시설 명</option>
                    </select>
                    <input class="sel-text" type="text" name = "query">
                    <input type = "submit" value = "검색">
                  </td>
                </tr>            
              </table>
	        </form> 
          </section>          
            <div class = "del-button"> 
              <input type = "button" value = "삭제">
            </div>
          
              <table border = "1" class="gymList-box">
                <thead>
                  <tr>
                    <td><input type="checkbox" class ="check-all"></td>
                    <td>번호</td>
                    <td>이름</td>       
                    <td>시설 명</td>               
                    <td>주소</td>
                    <td>연락처</td>
                    <td>시설 번호</td>
                    <td>업체 종류</td>
                    <td>사업자 번호</td>
                    <td>인증방식</td>
                    <td>가입일</td>    
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="g" items="${list}">
                    <tr>
                      <td><input type="checkbox" class="check"></td>
                      <td>${g.id }</td>
                      <td>${g.name }</td>
                      <td>${g.gymName }</td>                   
                      <td>${g.adress }</td>
                      <td>${g.telephone }</td>
                      <td>${g.phone }</td>
                      <td>헬스</td>
                      <td>${g.licenseNumber }</td> 
                      <td>핸드폰</td>
                      <td>${g.regdate }</td>
                    </tr>
                  </c:forEach>
                </tbody>       
              </table>
            
            <div class="page-list">
                <c:if test="${page != 1 }">
                    <span><a href="list?${page-1}">이전</a></span>
                </c:if>    
                <ul>
                    <c:forEach var="i" begin ="1" end="${pageEnd }">
                        <li><a href="list?page=${i}&size=${size}">${i}</a></li>
                      </c:forEach>
                  </ul>
                  <c:if test="${page != pageEnd }">
                    <span><a href="list?page=${page+1}">다음</a></span>
                  </c:if>
            </div>
          </div>        
        </main>
      </section>
      </div>
    <section>
      <footer id="footer" class="footer">
        <h1 class = "no-display">푸터</h1>
        다짐 고객님의 성공과 함께합니다
      </footer>
    </section>
  </body>
</html>