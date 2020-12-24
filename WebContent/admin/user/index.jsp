<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>admin Page</title>

    <link rel="stylesheet" href="/CSS/reset.css">
    <link rel="stylesheet" href="/CSS/style.css">
    <link rel="stylesheet" href="/CSS/admin/admin.css">
    <link rel="stylesheet" href="../../../CSS/admin/user/index.css">
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
        <a href="index"><h1 class="img-button user-button">회원관리</h1></a>
        <ul class="aside-menu">
            <li>회원 관리</li>
            <ul>
                <li><a href="list">회원 리스트</a></li>
                <li><a href="leave">탈퇴회원 리스트</a></li>
            </ul>
            <li>제휴시설 관리</li>
            <ul>
              <li><a href="">제휴업체 리스트</a></li>
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
        <main class="main">
            <div class="main-head">
                <h1>회원 관리</h1>
                <span>home > 회원관리</span>
            </div>
            <div class="main-body">
                <section>
                    <h1>회원 통계</h1>
                    <table class="main-table">
                        <tr>
                            <th>신규회원 통계</th>
                            <td>오늘 0명/어제 0명/이번주 0명/이번달 0명</td>
                        </tr>
                        <tr>
                            <th>회원 종류</th>
                            <td>
                                <table class="inner-table">
                                    <tr>
                                        <th>회원구분</th>
                                        <th>인원</th>
                                    </tr>
                                    <tr>
                                        <th>제휴 시설</th>
                                        <td>${gymLength }</td>
                                    </tr>
                                    <tr>
                                        <th>등록 트레이너</th>
                                        <td>${trainerLength }</td>
                                    </tr>
                                    <tr>
                                        <th>일반 회원</th>
                                        <td>${userLength }<i class="fas fa-angle-double-right"></i></td>
                                        
                                    </tr>
                                    <tr>
                                        <th>가입 신청자</th>
                                        <td>0</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </section>

                <section class="table-section event-table">
                    <h1>회원 이벤트</h1>
                    <table>
                        <tr>
                            <th>생일</th>
                            <td>오늘 0명 / 이번 주 0명 / 이번 달 0명</td>
                        </tr>
                    </table>
                </section>

                <section class="table-section">
                    <h1>회원관련 설정</h1>
                    <table>
                        <tr>
                            <th>회원가입시 혜택	</th>
                            <td>
                                적립금 지급&nbsp;&nbsp;	:&nbsp;&nbsp; 적립금기능 <a href="point.html" class="point-url">미사용</a>
                            </td>
                        </tr>
                        <tr>
                            <th>회원인증 방식</th>
                            <td>인증 안함 </td>
                        </tr>
                        <tr>
                            <th>탈퇴설정</th>
                            <td>즉시탈퇴</td>
                        </tr>
                    </table>
                </section> 
            </div>
        </main>
    </section>
</div>

</body>
</html>