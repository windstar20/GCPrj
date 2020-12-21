<%@page import="gc.entity.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="gc.dao.product.jdbc.JdbcProductDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin page</title>
    <link rel="stylesheet" href="../../CSS/reset.css">
    <link rel="stylesheet" href="../../CSS/admin/admin.css" />
    <link rel="stylesheet" href="../../CSS/admin/product/list.css" />
    <script src="../../js/admin/product/list.js"></script>        
  </head>
  <body>
    <header id="header" class="header">
      <div class="logo-bar">
        <h1 class="no-display">근처</h1>
        <a href=""><div class="logo"></div></a>
        <ul>
          <li><button class="login">로그인</button></li>
          <li><button class="logout">로그아웃</button></li>
        </ul>
      </div>
      <nav id="nav" class="nav">
        <h1 class="no-display">메뉴</h1>
        <ul>
          <li><a href="#">기본설정</a></li>
          <li><a href="list">상품관리</a></li>
          <li><a href="#">주문관리</a></li>
          <li><a href="#">회원관리</a></li>
          <li><a href="#">게시판관리</a></li>
          <li><a href="#">고객센터</a></li>
        </ul>
      </nav>
    </header>

    <div id="body" class="body">
      <aside class="aside">
        <h1 class="aside-title "></h1>
        <ul class="aside-menu">
          <li>쇼핑몰 상품 관리</li>
          <ul>
            <li><a href="list">상품 리스트</a></li>
            <li><a href="reg">상품 등록</a></li>
          </ul>
          <br />
          <!-- <li>트레이닝 센터 관리</li>
          <ul>
            <li><a href="">센터 리스트</a></li>
            <li><a href="">센터 등록</a></li>
            <li><a href="">센터 정보 수정</a></li>
            <li><a href="">상품 재고관리</a></li>
          </ul>
          <br />
          <li>강사 관리</li>
          <ul>
            <li><a href="">강사 리스트</a></li>
            <li><a href="">강사 등록</a></li>
            <li><a href="">강사 정보 수정</a></li>
          </ul>
          <br /> -->
          </ul>
      </aside>
 <!-- ======================== main ======================== -->     
      <section class="main-section">
        <main id="main" class="main">
			<div class="main-head">        
	          <h1>상품 목록</h1>
	          <span> home > 상품관리 > 상품리스트 </span>
	        </div>
	        <div class="main-body">
		        <section id="main" class="main">
		          <section class="finder-container">
		            <!-- <div class="finder-box"> -->
		              <h1 class="no-display">상품검색도구</h1>
		               <form action="list" >       
			               <div class="search-row">
			                  <div class="search-head">검색어</div>
			                  <div class="search-cell">
			                    <select name="keyword" id="" size="1">
			                      <option value="">[선택]</option>
			                      <option value="name">상품명</option>  
			                      <option value="category">카테고리</option>
			                      <option value="inventory">재고</option>                                
			                    </select>
			                        <input type="text" name="query" placeholder="검색">&nbsp ※재고는 비교 수량보다 작은 값 검색
			                  </div>
			                </div>
			                <div class="sale-row">
			                  <div class="sale-head">판매가</div>
			                  <div class="sale-cell">
			                       <input type="text" name ="prevPrice" >원 ~ <input type="text" name="nextPrice" >원
			                  </div>               
			                </div>
					        <div class="btn-search">
					           <input type="submit" value="검색">
					        </div>
			           </form>
		          </section>
		          
		          
		          
		          <section class="sort-container">
		            <div class="sort-box">
		              <h1 class="no-display">정렬박스</h1>
		              <a href="#">낮은 가격순</a>
		              <a href="#">높은 가격순</a>
		              <a href="#">등록일순</a>
		              <a href="#">상품명순</a>
		            </div>
		          </section>
		          <section class="productList-container">
		            <div class="productList-box">
		              <h1 class="no-display">상품목록 박스</h1>
		              <ul class="title-row">
		                <li class="title-check">
		                  <input class="check-all" type="checkbox"  name="check-all">         
		                </li>
		                <li class="title-number">번호</li>
		                <li class="title-name">상품기본정보(코드/카테고리/상품명/브랜드)</li>                
		                <li class="title-regdate">등록일</li>
		                <li class="title-price">가격</li>
		                <li class="title-inventory">재고</li>
		                <li class="title-delivery">배송</li>
		                <li class="title-display">진열</li>
		                <!-- <li class="title-copy">진열</li> -->
		                <li class="title-edit">수정</li>
		                <li class="title-remove">삭제</li>
		              </ul>
		              
					  <form method="post" action="list"> 
			           	  <c:forEach var="p" items="${list}">
				              <ul class="product-row">
				                  <li class="product-check-list">
				                    <input class="check" type="checkbox" name="selected" value="${p.id}">
				                  </li>
				                  <li class="product-number-list">${p.id}</li>                  
				                  <li class="product-name-list">
				                    <div class="product-name-img">
				                    	<img src="../../image/admin/product/${p.fileName}" alt="상품이미지" />
				                    </div>
				                    <div class="product-info">
				                      <div class="product-code">${p.code}</div>
				                      <div class="product-category">${p.category}</div>
				                      <div class="product-name">${p.name}</div>
				                      <div class="product-brand">${p.brand}</div> <!--브랜드-->
				                    </div>
				                  </li>                
				                <li class="product-regdate-list">${p.regdate}</li>
				                <li class="product-price-list">
				                    <label>${p.price}</label>
				                </li>
				   				
				   				<li class="product-inventory-list">
				                  <label>${p.inventory}</label> 개
				                </li>
				                <li class="product-delivery-list">
				                  <label>${p.delivery}</label>
				                </li>
				   				<li class="product-display-list">
				                    <label>${p.display}</label>
				                </li>
				                <li class="product-edit-list">
				                    <a href="edit?id=${p.id}"><input type="button" value="수정"></a>
				                </li>
				                <li class="product-remove-list">
				                    <a href="del?id=${p.id}"><input type="button" value="삭제" /></a>
				                </li>
				              </ul>
			              </c:forEach>
			          </div> <!--productList-box end-->
			          </section>   <!-- product container end-->
			          <section class="pager-container">
			            <div class="pager-box">
			              <h1 class="no-display">페이지 요청목록</h1>
			              <div class="check-box-edit">
			<!--                 <input type="button" value="체크상품수정"> -->
							<a href="list"><input type="submit" value="체크상품삭제" name="delete-submit"/></a>                
			                <a href="list"><input type="submit" value="체크상품진열" name="display-submit"/></a>
			              </div>
		              </form>
		              
		              <!-- <div class="before-page"> -->
		                <!-- </div> -->
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
		                <!-- <div class="next-page"> -->
		                <!-- </div> -->
		              <div class="product-reg">
		                <a href="reg">상품등록</a>
		              </div>   
		            </div>
		          </section> 
		        </section><!--end main-->
			</div>       
        </main>
      </section>
    </div>   <!--body div-->        


    <section>
      <footer id="footer" class="footer">
        <h1>푸터</h1>
      </footer>
    </section>
  </body>
</html>
