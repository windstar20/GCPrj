<%@page import="gc.entity.productOrder.ProductOrder"%>
<%@page import="java.util.List"%>
<%@page import="gc.service.productOrder.ProductOrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<script src="../../js/admin/product-order/product-order-list.js"></script>
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
					<li><a href="point-charge-list.html">포인트 충전 내역</a></li>
					<li><a href="point-use-list.html">포인트 사용 내역</a></li>
					<li><a href="reg">주문 등록</a></li>
				</ul>
				<br />
			</ul>
		</aside>
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
						<form action="">
							<table class="search-table">
								<!-- 첫번째 줄 시작-->
								<tr>
									<th>검색 키워드</th>
									<td><select name="search-type">
											<option value="order_number">주문번호</option>
											<option value="product_name">상품명</option>
											<option value="sender_name">주문자</option>
											<option value="sender_phone">주문자 휴대폰번호</option>
											<option value="receiver_name">수령인</option>
											<option value="receiver_phone">수령인 휴대폰번호</option>
									</select> <input type="text" name="search-value" /></td>
								</tr>
								<!-- 첫번째 줄 끝 -->
								<!-- 두번째 줄 시작 -->
								<tr>
									<th>주문상태</th>
									<td><input type="checkbox" name="" id="" /><span>전체</span>
										<input type="checkbox" name="" id="" /><span>주문완료</span>
										<input type="checkbox" name="" id="" /><span>결제완료</span>
										<input type="checkbox" name="" id="" /><span>배송완료</span>
									</td>
								</tr>
								<!-- 두번째 줄 끝 -->
								<!-- 세번째 줄 시작 -->
								<tr>
									<th>취소상태</th>
									<td><input type="checkbox" name="" id="" /><span>취소요청</span>
										<input type="checkbox" name="" id="" /><span>환불요청</span>
										<input type="checkbox" name="" id="" /><span>반품요청</span>
										<input type="checkbox" name="" id="" /><span>교환요청</span>
										<br /> <input type="checkbox" name="" id="" /><span>취소완료</span>
										<input type="checkbox" name="" id="" /><span>환불완료</span>
										<input type="checkbox" name="" id="" /><span>반품완료</span>
										<input type="checkbox" name="" id="" /><span>교환완료</span>
									</td>
								</tr>
								<!-- 세번째 줄 끝 -->
								<!-- 네번째 줄 시작 -->
								<tr>
									<th>처리일자</th>
									<td><select>
											<option>주문일</option>
											<option>결제일</option>
									</select> <input type="date" name="" id="" /> ~ <input type="date"
										name="" id="" />
										<button class="select-button">어제</button>
										<button class="select-button">오늘</button>
										<button class="select-button">이번주</button>
										<button class="select-button">이번달</button>
										<button class="select-button">전체</button></td>
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
								<li><select name="" id="">
										<option value="">모두 출력</option>
										<option value="">5개 출력</option>
										<option value="">10개 출력</option>
										<option value="">20개 출력</option>
										<option value="">50개 출력</option>
								</select></li>
							</ul>
						</section>
						<!-- 테이블 시작 -->
						<div class="sort-bar">
							<h1 class="no-display">정렬</h1>
							<ul>
								<li>주문일 <span class="img-button up-button">up</span> <span
									class="img-button down-button">down</span>
								</li>
								<li>주문자 <span class="img-button up-button">up</span> <span
									class="img-button down-button">down</span>
								</li>
								<li>결제금액 <span class="img-button up-button">up</span> <span
									class="img-button down-button">down</span>
								</li>
							</ul>
						</div>
						<table class="order-list-table">
							<thead>
								<tr>
									<th><input type="checkbox" name="" id="" /></th>
									<th>주문 번호</th>
									<th>상품명</th>
									<th>주문 수량</th>
									<th>주문일</th>
									<th>결제일</th>
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
										<td><input type="checkbox" name="" id="" /></td>
										<td>${p.number }</td>
										<td> ${p.productName }</td>
										<td>${p.productCount}개</td>
										<td>
										<fmt:formatDate var="date" value="${p.regdate }" pattern="yyyy-MM-dd a hh:mm"/>
										${date}</td>
										<td></td>
										<td>${p.senderName } <br /> <span>(${p.senderPhone })</span>
										</td>
										<td>${p.receiverName } <br /> <span>(${p.receiverPhone })</span>
										</td>
										<td>
										<fmt:formatNumber var="price" value="${p.totalPrice}" type="number"/>
										<span class="price">${price }</span>원</td>
										<td>무통장<br />입금자명
										</td>
										<td class="order-state">입금대기</td>
										<td><input class="select-button" type="button"
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
