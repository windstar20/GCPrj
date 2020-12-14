<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin page</title>
    <link rel="stylesheet" href="../../CSS/reset.css" type="text/css" />
    <link rel="stylesheet" href="../../CSS/style.css">
    <link rel="stylesheet" href="../../CSS/admin/admin.css" type="text/css" />
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

    <div id="body" class="body">
      <aside class="aside">
        <h1 class="aside-title"><a href="user.html"><img src="../../image/admin/member-aside.png" alt="회원관리"></a></h1>
        <ul class="aside-menu">
          <li>회원관리</li>
          <ul>
            <li><a href="list">회원 리스트</a></li>
            <li><a href="mana">회원등급 관리</a></li>
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
          <h1>회원등급 관리</h1>
          <span> home > 회원관리 > 회원등급 관리 </span>
        </div>
          <h1>회원등급 리스트</h1>
          <table border="1">
            <thead>
              <tr>
                <td rowspan="2">레벨</td>
                <td rowspan="2">등급명</td>
                <td rowspan="2">등급설명</td>
                <td rowspan="2">회원수</td>
                <td colspan="3">이용제한</td>
                <td colspan="3">구매시 헤택</td>
                <td rowspan="2">수정/삭제</td>
              </tr>
              <tr>
                <td>접속</td>
                <td>상품</td>
                <td>구매</td>
                <td>할인</td>
                <td>추가 적립</td>
                <td>배송비</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>5</td>
                <td>프리미엄 회원</td>
                <td>매출 및 방문 실적이 상위급인 회원</td>
                <td>0</td>
                <td>허용</td>
                <td>열람</td>
                <td>가능</td>
                <td>20%</td>
                <td>-</td>
                <td>-</td>
                <td>
                  <input type="submit" value="수정">
                  <input type="submit" value="삭제">
                </td>                
              </tr>
              <tr>
                <td>4</td>
                <td>우수회원</td>
                <td>매출 및 방문 실적이 좋은회원</td>
                <td>0</td>
                <td>허용</td>
                <td>열람</td>
                <td>가능</td>
                <td>10%</td>
                <td>-</td>
                <td>-</td>
                <td>
                  <input type="submit" value="수정">
                  <input type="submit" value="삭제">
                </td>                
              </tr>
              <tr>
                <td>3</td>
                <td>일반회원</td>
                <td>가입승인된 기본회원</td>
                <td>1</td>
                <td>허용</td>
                <td>열람</td>
                <td>가능</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>
                  <input type="submit" value="수정">
                </td>                
              </tr>
              <tr>
                <td>2</td>
                <td>가입신청자</td>
                <td>가입승인 전 대기회원</td>
                <td>0</td>
                <td colspan="6">가입 승인 대기 회원은 접속 불가</td>
                <td>
                  <input type="submit" value="수정">
                </td>                
              </tr>
              <tr>
                <td>1</td>
                <td>탈퇴대기자</td>
                <td>탈퇴승인 전 기본회원</td>
                <td>0</td>
                <td>허용</td>
                <td>열람</td>
                <td colspan="4">탈퇴 대기 회원은 구매 불가</td>
                <td>
                  <input type="submit" value="수정">
                </td>                
              </tr>
            </tbody>
          </table>
          <div>
            <input type="submit" value="검색">
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