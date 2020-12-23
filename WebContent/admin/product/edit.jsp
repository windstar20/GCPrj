<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="gc.entity.product.Product" %>
<%@ page import="gc.service.product.ProductService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin page</title>
    <link rel="stylesheet" href="../../CSS/reset.css">
    <link rel="stylesheet" href="../../CSS/admin/admin.css" />
    <link rel="stylesheet" href="../../CSS/admin/product/reg.css" />
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
          <li><a href="/admin/user/index.html">회원관리</a></li>
          <li><a href="/admin/notice/list">게시판관리</a></li>
          <li><a href="#">고객센터</a></li>
        </ul>
      </nav>
    </header>

    <div id="body" class="body">
      <aside class="aside">
        <h1 class="aside-title"></h1>
        <ul class="aside-menu">
          <li>쇼핑몰 상품 관리</li>
          <ul>
            <li><a href="list">상품 리스트</a></li>
            <li><a href="">상품 등록</a></li>
            <li><a href="">상품 재고관리</a></li>
          </ul>
          <br />
          <li>트레이닝 센터 관리</li>
          <ul>
            <li><a href="">센터 리스트</a></li>
            <li><a href="">센터 등록</a></li>
            <li><a href="">센터 정보 수정</a></li>
            <!-- <li><a href="">상품 재고관리</a></li> -->
          </ul>
          <br />
          <li>강사 관리</li>
          <ul>
            <li><a href="">강사 리스트</a></li>
            <li><a href="">강사 등록</a></li>
            <li><a href="">강사 정보 수정</a></li>
          </ul>
          <br />
          </ul>
      </aside>
      <!--?=============== body 테이블 ===============-->
      <section id="main-section">
	      <main id="main" class="main">
	        <div class="main-head">
	            <h1>상품 수정</h1>
	            <span> home > 상품관리 > 상품리스트 </span>
	        </div>
	        <div class="main-body">      
	        	<form action="edit" method="post" >
		            <section id="main" class="main">
		            <h1>상품 기본 정보</h1>
		            <table class="product-basic-info product-table">
		            	<tr>
		                    <th>상품코드</th>
		                    <td><input type="text" name="code" value="${p.code}" style="border-color:#d2d2d2; background-color:#e5e5e5;"
								onfocus="javascript:blur();"></td>
		                </tr>
		                <tr>
		                    <th>상품명</th>
		                    <td>
		                        <input type="text" name="name" value="${p.name}"/>
		                    </td>
		                </tr>   	                
		                <tr>
		                    <th>브랜드</th>
		                     <td>
		                     	<select name="brand" >
			                     	<c:forEach var="b" items="${bList}">
			                     		<option value="${b.id}">${b.name}</option>
			                     	</c:forEach>
		                     	</select>	                     
		                     </td>
		                </tr>
		                <tr>
		                    <th>상품분류</th>
		                    <td>
		                    	<select name="category">
		                    		<c:forEach var="c" items="${cList}">
		                    			<option value="${c.id}">${c.name}</option>
		                    		</c:forEach>
		                    	</select>
		                    </td>
		                </tr>
		                <tr>
		                    <th>맛</th>
		                    <td>
	                    	<select name="taste">
		                    		<option value="1">오렌지</option>
		                    		<option value="2">바닐라</option>
		                    		<option value="3">다크초코</option>
		                    		
		                    		
	<%-- 	                    	<c:forEach var="t" items="${tList}">
		                    	</c:forEach> 	                     --%>	
	<%--<input type="text" value="${t.id}">${t.name}</option> --%>
		                    </select> 
		                    </td>
		                </tr>
		                <tr>
		                	<th>재고</th>
		                	<td><input type="text" name="inventory"  value="${p.inventory}"></td>
		                </tr>
		                <tr>
		                	<th>진열</th>
		                	<td>
		                		<input type="radio" name="display" value="0" >대기 &nbsp
		                		<input type="radio" name="display" value="1" >진열
		                	</td>
		                </tr>
		            </table>   
		            
		            <h1>가격 / 판매정보</h1>
		            <table class="product-price-info product-table">
		                <tr>
		                    <th>판매가</th>
		                    <td>
		                        <input type="text" name="price" value="${p.price}"/> 원                           
		                    </td>
		                </tr>	              
		            </table>
		        
		            <h1>배송정보</h1>
		            <table class="product-delivery-info product-table">
		                <tr>
		                    <th>배송정책</th>
		                    <td>
		                        <input type="radio" name="delivery-price" value="1" />
		                        <label>일반배송</label>
		                        <input type="radio" name="delivery-price" value="2" /> 
		                        <label>무료배송</label>
		                    </td>
		                </tr>
		            </table>
		        
		        
		            <h1>상품 이미지</h1>
		            <table class="product-image-info product-table">
		                <tr>
		                    <th>기본 이미지</th>
		                    <td>                      
		                        <input type="file" name="image" />
		                        <label>권장사이즈(500x500)</label>                                                
		                    </td>
		                </tr>
		                <tr>
		                    <th>추가 이미지</th>
		                    <td>                      
		                        <input type="file" name="add-image" /><label></label>                                                
		                    </td>
		                </tr>
		            </table>
		        
		            <h1>상세 설명</h1>
		            <table class="product-explain-info product-table">
		                <tr>
		                    <th>상세설명</th>
		                    <td>
		                       <textarea rows=10 name="content" value="${p.content}"></textarea>
		                    </td>
		                </tr>
		            </table>
		            <div class="application">	                
	                    <input type="hidden" name="id" value="${p.id}" />		                
	                    <a href="list">취소</a>         
	                    <input type="submit" value="상품수정" />           
		            </div>
		           </section>
		       </form>
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
