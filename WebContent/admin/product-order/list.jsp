<%@page import="gc.entity.productOrder.ProductOrder"%>
<%@page import="java.util.List"%>
<%@page import="gc.service.productOrder.ProductOrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>주문관리-주문 목록</title>
<link rel="stylesheet" href="../../CSS/reset.css" />
<link rel="stylesheet" href="../../CSS/style.css" />
<link rel="stylesheet" href="../../CSS/admin/admin.css" />
<link rel="stylesheet"
	href="../../CSS/admin/product-order/list.css" />
<script src="../../js/admin/product-order/list.js"></script>
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
				<li><a href="#">회원관리</a></li>
				<li><a href="#">게시판관리</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</nav>
	</header>

	<div id="body" class="body">
		<aside class="aside">
			<h1 class="aside-title img-button">주문관리</h1>
			<ul class="aside-menu">
				<li>쇼핑몰 주문 관리</li>
				<ul>
					<li><a href="list" class="aside-current">주문
							목록</a></li>
				</ul>
				<br />
				<li>포인트 결제 관리</li>
				<ul>
					<li><a href="point-charge-list">포인트 충전 내역</a></li>
					<li><a href="point-use-list">포인트 사용 내역</a></li>
				</ul>
				<br />
			</ul>
		</aside>
		 <!-- ======================== main ======================== -->     
		<section class="main-section">
			<main id="main" class="main">
				<div class="main-head">
					<h1>주문 목록</h1>
					<span> home > 상품관리 > 주문 목록 </span>
				</div>
				<div class="main-body">
					<section>
						<h1 class="table-title">
							주문검색
						</h1>
						<form action="list">
							<table class="search-table">
								<!-- 첫번째 줄 시작-->
								<tr>
									<th>검색 키워드</th>
									<td><select name="field">
											<option value="" selected>==선택==</option>
											<option value="number">주문번호</option>
											<option value="product_name">상품명</option>
											<option value="sender_name">주문자</option>
											<option value="sender_phone">주문자 휴대폰번호</option>
											<option value="receiver_name">수령인</option>
											<option value="receiver_phone">수령인 휴대폰번호</option>
									</select> <input type="text" name="query" /></td>
								</tr>
								<!-- 첫번째 줄 끝 -->
								<!-- 두번째 줄 시작 -->
								<tr>
									<th>주문상태</th>
									<td><input type="checkbox" name="order-state" value="all" /><span>전체</span>
										<input type="checkbox" name="order-state" value="1" /><span>결제완료</span>
										<input type="checkbox" name="order-state" value="2" /><span>배송준비</span>
										<input type="checkbox" name="order-state" value="3" /><span>배송중</span>
										<input type="checkbox" name="order-state" value="4" /><span>배송완료</span>
									</td>
								</tr>
								<!-- 두번째 줄 끝 -->
								<!-- 세번째 줄 시작 -->
								<tr>
									<th>취소상태</th>
									<td><input type="checkbox" name="order-state" value="5" /><span>취소요청</span>
										<input type="checkbox" name="order-state" value="7" /><span>환불요청</span>
										<input type="checkbox" name="order-state" value="9" /><span>반품요청</span>
										<input type="checkbox" name="order-state" value="11" /><span>교환요청</span>
										<br /> 
										<input type="checkbox" name="order-state" value="6" /><span>취소완료</span>
										<input type="checkbox" name="order-state" value="8" /><span>환불완료</span>
										<input type="checkbox" name="order-state" value="10" /><span>반품완료</span>
										<input type="checkbox" name="order-state" value="12" /><span>교환완료</span>
									</td>
								</tr>
								<!-- 세번째 줄 끝 -->
								<!-- 네번째 줄 시작 -->
								<tr>
									<th>처리일자</th>
									<td><select name="date-field">
											<option value="order-regdate">주문일</option>
									</select> <input type="date" class="start-date" name="start-date" value="2020-12-01"/> ~ <input type="date"
										 class="end-date" name="end-date" />
    								<ul class="button-list">
      									<li><button class="select-button yesterday">어제</button></li>
								      	<li><button class="select-button today">오늘</button></li>
								        <li><button class="select-button this-week">이번주</button></li>
							        	<li><button class="select-button this-month">이번달</button></li>
						            	<li><button class="select-button all-date">전체</button></li>    
				            	 	</ul>
									</td>
								</tr>
								<!-- 네번째 줄 끝 -->
							</table>
							<input class="search-button" type="submit" value="검색" />
						</form>
					</section>
					<!-- 테이블 끝 -->
					<section>
						<section>
							<h1 class="table-title">주문 목록</h1>
							<ul class="table-sum">
								<li>검색결과 : <span class="total-count">0</span>건</li>
								<li>총결제금액 : <span class="total-price">0</span>원</li>
								<form action="list" >
								<input type="hidden" name="page" value="1">
								<input type="hidden" name="query" value="${query }">
								<input type="hidden" name="field" value="${field }">
								<input type="hidden" name="start-date" value="${startDate }">
								<input type="hidden" name="end-date" value="${endDate }">
								<input type="hidden" name="sort-field" value="${sortField }">
								<input type="hidden" name="sort-option" value="${sortOption }">
								<li><select onchange="this.form.submit()" name="size" >
										<option value="">==출력갯수==</option>
										<option value="5">5개 출력</option>
										<option value="10">10개 출력</option>
										<option value="20">20개 출력</option>
										<option value="50">50개 출력</option>
								</select></li>
								</form>
							</ul>
						</section>
						<!-- 테이블 시작 -->
						<div class="sort-bar">
							<h1 class="no-display">정렬</h1>
							<ul>
					          <li>
					            <span> 주문일</span>
					            <span>
					              <form action="list">
					              	<input type="hidden" name="page" value="${page }">
					              	<input type="hidden" name="size" value="${size }">
									<input type="hidden" name="query" value="${query }">
									<input type="hidden" name="field" value="${field }">
									<input type="hidden" name="start-date" value="${startDate }">
									<input type="hidden" name="end-date" value="${endDate }">
					                <input type="hidden" name="sort-field" value="regdate" />
					                <input type="hidden" name="sort-option" value="asc" />
					                <input class="img-button up-button" type="submit" value="up" />
					              </form>
					            </span>
					            <span >
					              <form action="list">
					            	<input type="hidden" name="page" value="${page }">
					            	<input type="hidden" name="size" value="${size }">
									<input type="hidden" name="query" value="${query }">
									<input type="hidden" name="field" value="${field }">
									<input type="hidden" name="start-date" value="${startDate }">
									<input type="hidden" name="end-date" value="${endDate }">
					                <input type="hidden" name="sort-field" value="regdate" />
					                <input type="hidden" name="sort-option" value="desc" />
					                <input class="img-button down-button" type="submit" value="down" />
					              </form>
					            </span>
					          </li>
													          <li>
					           	<span>주문자</span>
					            <span >
					              <form action="list">
					            	<input type="hidden" name="page" value="${page }">
					            	<input type="hidden" name="size" value="${size }">
									<input type="hidden" name="query" value="${query }">
									<input type="hidden" name="field" value="${field }">
									<input type="hidden" name="start-date" value="${startDate }">
									<input type="hidden" name="end-date" value="${endDate }">
					                <input type="hidden" name="sort-field" value="sender_name" />
					                <input type="hidden" name="sort-option" value="asc" />
					                <input class="img-button up-button" type="submit" value="up" />
					              </form>
					            </span>
					            <span >
					              <form action="list">
					            	<input type="hidden" name="page" value="${page }">
					            	<input type="hidden" name="size" value="${size }">
									<input type="hidden" name="query" value="${query }">
									<input type="hidden" name="field" value="${field }">
									<input type="hidden" name="start-date" value="${startDate }">
									<input type="hidden" name="end-date" value="${endDate }">
					                <input type="hidden" name="sort-field" value="sender_name" />
					                <input type="hidden" name="sort-option" value="desc" />
					                <input class="img-button down-button" type="submit" value="down" />
					              </form>
					            </span>
					          </li>
													          <li>
					           	<span>결제금액</span>
					            <span >
					              <form action="list">
					             	<input type="hidden" name="page" value="${page }">
					             	<input type="hidden" name="size" value="${size }">
									<input type="hidden" name="query" value="${query }">
									<input type="hidden" name="field" value="${field }">
									<input type="hidden" name="start-date" value="${startDate }">
									<input type="hidden" name="end-date" value="${endDate }">
					                <input type="hidden" name="sort-field" value="total_price" />
					                <input type="hidden" name="sort-option" value="asc" />
					                <input class="img-button up-button" type="submit" value="up" />
					              </form>
					            </span>
					            <span >
					              <form action="list">
					             	<input type="hidden" name="page" value="${page }">
					             	<input type="hidden" name="size" value="${size }">
									<input type="hidden" name="query" value="${query }">
									<input type="hidden" name="field" value="${field }">
									<input type="hidden" name="start-date" value="${startDate }">
									<input type="hidden" name="end-date" value="${endDate }">
					                <input type="hidden" name="sort-field" value="total_price" />
					                <input type="hidden" name="sort-option" value="desc" />
					                <input class="img-button down-button" type="submit" value="down" />
					              </form>
					            </span>
					          </li>
							</ul>
						</div>
						<table class="order-list-table">
							<thead>
								<tr>
									<th>주문 번호</th>
									<th>상품명</th>
									<th>주문 수량</th>
									<th>주문일</th>
									<th>주문자</th>
									<th>수령인</th>
									<th>주문 금액</th>
									<th>결제 방법<br />
									</th>
									<th>주문상태</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="p" items="${list }">
									<!-- 첫번째 행 시작 -->
									<tr>
										<td>${p.number }</td>
										<td> ${p.productName }</td>
										<td>${p.productCount}개</td>
										<td>
										<fmt:formatDate var="date" value="${p.regdate }" pattern="yyyy-MM-dd a hh:mm"/>
										${date}</td>
										<td>${p.senderName } <br /> <span>(${p.senderPhone })</span>
										</td>
										<td>${p.receiverName } <br /> <span>(${p.receiverPhone })</span>
										</td>
										<td>
										<fmt:formatNumber var="price" value="${p.totalPrice}" type="number"/>
										<span class="price">${price }</span>원</td>
										<td>${p.paymentWay }<br />
										</td>
										<td class="order-state">${p.state }</td>
										<td><input class="select-button jsbutton" type="button"
											value="입금확인" /> 
											<a href="detail?id=${p.id }"><input
											class="select-button" type="button" value="상세보기"  /></a>
											<a href="del?id=${p.id }"><input class="select-button" type="button" value="주문취소" /></a>
										</td>
									</tr>
									<!-- 첫번째 행 끝 -->
								</c:forEach>
							</tbody>
						</table>
							<div class="paging">
								<c:forEach var="i" begin="1" end="${pageNum }"><a href="list?page=${i}&size=${size}&field=${field}&query=${query}&start-date=${startDate}&end-date=${endDate}&sort-field=${sortField}&sort-option=${sortOption}" class="paging-button">${i }</a></c:forEach>
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
</ProductOrderList>
