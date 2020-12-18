<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>주문관리-포인트 충전 내역</title>
    <link rel="stylesheet" href="../../CSS/reset.css" />
    <link rel="stylesheet" href="../../CSS/style.css" />
    <link rel="stylesheet" href="../../CSS/admin/admin.css" />
    <link
      rel="stylesheet"
      href="../../CSS/admin/product-order/point-charge-list.css"
    />
    <script src="../../js/admin/product-order/point-charge-list.js"></script>
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
            <li><a href="list">주문 목록</a></li>
          </ul>
          <br />
          <li>포인트 결제 관리</li>
          <ul>
            <li>
              <a href="point-charge-list" class="aside-current"
                >포인트 충전 내역</a
              >
            </li>
            <li><a href="point-use-list">포인트 사용 내역</a></li>
          </ul>
          <br />
        </ul>
      </aside>
      <section class="main-section">
        <main id="main" class="main">
          <div class="main-head">
            <h1>주문 목록</h1>
            <span> home > 상품관리 > 포인트 충전 내역 </span>
          </div>
          <div class="main-body">
            <section>
              <h1 class="table-title">충전 내역 검색</h1>
              <form action="point-charge-list">
                <table class="search-table">
                  <!-- 첫번째 줄 시작-->
                  <tr>
                    <th>검색 키워드</th>
                    <td>
                      <select name="field">
                        <option value="" selected>==선택==</option>
                        <option value="member_id">아이디</option>
                        <option value="name">이름</option>
                      </select>
                      <input type="text" name="query" />
                    </td>
                  </tr>
                  <!-- 첫번째 줄 끝 -->
                  <!-- 두번째 줄 시작 -->
                  <tr>
                    <th>충전일자</th>
                    <td>
                      <input
                        type="date"
                        class="start-date"
                        name="start-date"
                        value="2020-12-01"
                      />
                      ~ <input type="date" class="end-date" name="end-date" />
                      <ul class="button-list">
                        <li>
                          <button class="select-button yesterday">어제</button>
                        </li>
                        <li>
                          <button class="select-button today">오늘</button>
                        </li>
                        <li>
                          <button class="select-button this-week">
                            이번주
                          </button>
                        </li>
                        <li>
                          <button class="select-button this-month">
                            이번달
                          </button>
                        </li>
                        <li>
                          <button class="select-button all-date">전체</button>
                        </li>
                      </ul>
                    </td>
                  </tr>
                  <!-- 두번째 줄 끝 -->
                </table>
                <input class="search-button" type="submit" value="검색" />
              </form>
            </section>
            <!-- 테이블 끝 -->
            <section>
              <section>
                <h1 class="table-title">포인트 충전 목록</h1>
                <ul class="table-sum">
                  <li>검색결과 : <span class="total-count">0</span>건</li>
                  <li>충전 금액 : <span class="total-price">0</span>원</li>
                  <fmt:formatNumber var="point" value="${currentPoint}" type="number"/>
                  <li>현재 회원 포인트 : <span class="current-point">${point}</span>p</li>
                  <form action="point-charge-list">
                    <input type="hidden" name="page" value="1" />
                    <input type="hidden" name="query" value="${query}" />
                    <input type="hidden" name="field" value="${field }" />
                    <input
                      type="hidden"
                      name="startDate"
                      value="${startDate }"
                    />
                    <input type="hidden" name="endDate" value="${endDate }" />
                    <li>
                      <select onchange="this.form.submit()" name="size">
                        <option value="">==출력갯수==</option>
                        <option value="5">5개 출력</option>
                        <option value="10">10개 출력</option>
                        <option value="20">20개 출력</option>
                        <option value="50">50개 출력</option>
                      </select>
                    </li>
                  </form>
                </ul>
              </section>
              <!-- 테이블 시작 -->
              <div class="sort-bar">
                <h1 class="no-display">정렬</h1>
                <ul>
                  <li>
                    충전일 <span class="img-button up-button">up</span>
                    <span class="img-button down-button">down</span>
                  </li>
                  <li>
                    충전 금액 <span class="img-button up-button">up</span>
                    <span class="img-button down-button">down</span>
                  </li>
                </ul>
              </div>
              <table class="order-list-table">
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>회원 아이디</th>
                    <th>회원 이름</th>
                    <th>충전 금액</th>
                    <th>내용</th>
                    <th>충전일</th>
                    <th>기타</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="c" items="${list }">
                    <!-- 첫번째 행 시작 -->
                    <tr>
                      <td>${c.id }</td>
                      <td>${c.memberId }</td>
                      <td>${c.name}</td>
                      <td>
                      <fmt:formatNumber var="price" value="${c.amount}" type="number"/>
                      	<span class="price">${price }</span>원
                      </td>
                      <td>${c.content }</td>
                      <td>
                        <fmt:formatDate
                          var="date"
                          value="${c.regdate }"
                          pattern="yyyy-MM-dd a hh:mm"
                        />
                        ${date}
                      </td>

                      <td>
                        <a href="point-charge-del?id=${c.id }"
                          ><input
                            class="select-button"
                            type="button"
                            value="삭제"
                        /></a>
                      </td>
                    </tr>
                    <!-- 첫번째 행 끝 -->
                  </c:forEach>
                </tbody>
              </table>
              <div class="paging">
                <c:forEach var="i" begin="1" end="${pageNum }"
                  ><a
                    href="point-charge-list?page=${i}&size=${size}&filed=${field}&query=${query}&startDate=${startDate}&endDate=${endDate}"
                    >${i }</a
                  >
                  </c:forEach>
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
