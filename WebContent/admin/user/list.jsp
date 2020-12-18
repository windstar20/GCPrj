<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin  page</title>
    <link rel="stylesheet" href="../../CSS/reset.css" type="text/css" />
    <link rel="stylesheet" href="../../CSS/style.css">
    <link rel="stylesheet" href="../../CSS/admin/admin.css" type="text/css" />
    <link rel="stylesheet" href="../../CSS/admin/user/index.css" type="text/css" />
    <script src="../../js/admin/admin/list.js"></script>
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
          <li><a href="#">기본설정</a></li>
          <li><a href="#">상품관리</a></li>
          <li><a href="#">주문관리</a></li>
          <li><a href="user.html">회원관리</a></li>
          <li><a href="#">게시판관리</a></li>
          <li><a href="#">고객센터</a></li>
        </ul>
      </nav>
    </header>

    <div>
      
    </div>
    <div id="body" class="body">
      <aside class="aside">
        <h1 class="img-button aside-title"><a href="user.html">회원관리</a></h1>
        <ul class="aside-menu">
          <li>회원관리</li>
          <ul>
            <li><a href="list">회원 리스트</a></li>
            <li><a href="leaveuserlist.html">탈퇴회원 리스트</a></li>
            <li><a href="point.html">적립금 설정</a></li>
          </ul>
          <br />
          <li>제휴업체 관리</li>
          <ul>
            <li><a href="">제휴업체 리스트</a></li>
            <li><a href="">제휴업체 </a></li>
          </ul>
      </aside>
      <section class="main-section">
        <main id="main" class="main">
          <div class="main-head">
            <h1>회원리스트</h1>
          <span> home > 회원관리 > 회원등급 관리 </span>
          </div>
          <div class="main-body">
            <section>
              <h1>기본검색</h1>
              <table>
                <tr>
                  <th>회원등급</th>
                  <td colspan="3">
                    <input type="checkbox"> 모든 회원
                    <input type="checkbox"> 탈퇴 대기자
                    <input type="checkbox"> 가입신청자
                    <span><input type="checkbox"> 일반 회원</span>
                    <span><input type="checkbox"> 우수 회원</span>
                    <span><input type="checkbox"> 프리미엄 회원</span>
                  </td>
                </tr>
                <tr>
                  <th>수신동의</th>
                  <td>
                    <input type="checkbox"> SNS 수신동의
                    <input type="checkbox"> E-mail 수신동의
                  </td>
                  <th>접속 중 회원</th>
                  <td>
                      <input type="checkbox"> 접속중 회원 검색
                  </td>
                </tr>
                <tr>
                  <th>검색 키워드</th>
                  <td colspan="3">
                    <select>
                      <option>이름</option>
                      <option>아이디</option>
                      <option>이메일</option>
                      <option>휴대폰</option>
                      <option>전화번호</option>
                      <option>주소</option>
                      <option>추천인ID</option>
                    </select>
                    <input class="sel-text" type="text">
                  </td>
                </tr>
                <tr>
                  <th>휴면 회원</th>
                  <td colspan="3">
                    <input type="text"> 일이상 미 접속자
                  </td>
                </tr>
              </table>
                <div class="find">
                      <input class="img-button find-button" type="submit" value="검색">
                </div>
              <table border="1">
                <thead>

                  <tr>
                    <td>번호</td>
                    <td>이름</td>
                    <td>아이디</td>
                    <td>회원등급</td>
                    <td>가입일</td>
                    <td>주소</td>
                    <td>메일</td>
                    <td>핸드폰</td>
                    <td>주문총액</td>
                    <td>CRM</td>
                  </tr>
                </thead>
                <tbody>
						<c:forEach var="list" items="${userlist}">
							<tr>
								<td>${list.id}</td>
								<td>${list.name}</td>
								<td>${list.nicname}</td>
								<td>일반회원</td>
								<td>${list.regdate}</td>
								<td>${list.address}</td>
								<td>${list.email}</td>
								<td>${list.phone}</td>
								<td><u><a href="">0원</a></u></td>
								<td><span class="detail">보기</span></td>
							</tr>
						</c:forEach>
					</tbody>
              </table>
              <div class="page-list">
                <span><a href="">이전</a></span>
                <ul>
                  <c:forEach var="i" begin="0" end="4">
							<li>${i+1}</li>
						</c:forEach>
                </ul>
                <span><a href="">다음</a></span>
              </div>
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