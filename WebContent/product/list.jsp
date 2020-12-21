<%@page import="gc.entity.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="gc.dao.product.jdbc.JdbcProductDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/reset.css">
    <link rel="stylesheet" href="../CSS/product/list.css">
    <title>시설검색</title>
</head>

<body>
    <header>
        <h1><img class="logo-img" src="../image/gc_logo.png" alt="근처" /></h1>
        <nav>
            <ul class="menu-bar">
                <li>소개</li>
                <li>시설</li>
                <li>트레이너</li>
                <li>쇼핑몰</li>
            </ul>
        </nav>
        <nav>
            <ul class="menu-bar2">
                <li>LOGIN</li>
                <li>JOIN</li>
                <li>SEARCH</li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="location">
            <div>
                <span>홈>내 주변 운동시설</span><br>
                <span>서울특별시 중구 명동</span>
            </div>
            <span>재설정|위치지정</span>
        </section>
        <section class="list">
      		<form action="list">
	            <h1 class="aside">가까운 제휴시설</h1>
	            <div class="item-list">
		        	<c:forEach var="p" items="${list}">
		                <div class="item">
		                    <img src="../image/gymimg.png" alt="시설이미지">
		                    <span>상품명: ${p.name}</span>
		                    <span>후기: hit</span>
		                    <span>가격: ${p.price}</span>
		                </div>
		            </c:forEach>              
	           	</div>
      		</form>
        </section>
    </main>
    
     <nav class="pager-menu">
     	<c:if test="${page != 1}">
        	<a class="before-button img-button" href="list?page=${page-1}">이전</a>
        </c:if>
        <ul>
	        <c:forEach var="i" begin="1" end="${pageEnd}"> 
	        	<li><a href="list?page=${i}&size=${size}">${i}</a></li>
	        </c:forEach>
        </ul>           
        <c:if test="${page != pageEnd}">     
       		<a class="next-button img-button" href="list?page=${page+1}">다음</a>
        </c:if>	
      </nav>    

    <footer class="footer">
        <div class="footer-copyright">
            <table>
                <tr>
                    <th>회사명</th>
                    <th>대표자</th>
                    <th>사업자등록번호</th>
                    <th>소재지</th>
                </tr>
                <tr>
                    <td>(주)근손실처방전</td>
                    <td>박현민</td>
                    <td>112-33-55555</td>
                    <td>서울 종로구 종로 탑골공원 옆 15층</td>
                </tr>
            </table>

            <span>고객센터 070-5555-2222 </span>
        </div>
    </footer>
</body>

</html>