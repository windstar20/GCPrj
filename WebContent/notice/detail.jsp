<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/reset.css">
    <link rel="stylesheet" href="../CSS/user.css">
    <link rel="stylesheet" href="../CSS/notice/detail.css">
    <title>Detail</title>
</head>
<body>
    <header>
        <h1><img class="logo-img" src="../image/gc_logo.png" alt="근처" /><a href="/index.html"></a></h1>
        <nav>
            <ul class="menu-bar">
                <li><a href="../info/info">소개</a></li>
                <li><a href="">시설</a></li>
                <li><a href="">트레이너</a></li>
                <li><a href="">쇼핑몰</a></li>
            </ul>
        </nav>
        <nav>
            <ul class="menu-bar2">
                <li><a href="">LOGIN</a></li>
                <li><a href="">JOIN</a></li>
                <li><a href="/notice/faq">SEARCH</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="main-head">
            <span>
                언제나 고객님께 귀를<br>
                기울이고 있습니다.
            </span>
        </section>
        <section class="main-body">
            <div class="submenu">
                <a href="faq">
                    <div class="question-btn">
                        자주 묻는 질문
                    </div>
                </a>
                <a href="list">
                    <div class="notice-btn">
                        공&nbsp;지&nbsp;사&nbsp;항
                    </div>
                </a>
            </div>
            <div class="notice-content">
                <table class="notice-detail">
                    <tr>
                        <th class="th-short">작&nbsp;성&nbsp;자</th>
                        <td class="td-short">&nbsp;&nbsp;관리자</td>
                        <th class="th-short">등&nbsp;록&nbsp;일</th>
                        <td class="td-short"><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
                    </tr>
                    <tr>
                        <th class="th-short">제&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                        <td colspan="3">&nbsp;&nbsp;${n.title}</td>
                    </tr>
                    <tr>
                        <th class="th-short">내&nbsp;&nbsp;&nbsp;&nbsp;용</th>
                        <td colspan="4">&nbsp;&nbsp;${n.content}</td>
                    </tr>
                    <tr>
                        <th class="th-short">첨&nbsp;부&nbsp;파&nbsp;일</th>
                        <td colspan="3">
                                <c:forTokens var="fileName" items="${n.files}" delims="," varStatus="st">
                                <fmt:formatDate var="year" value="${n.regDate}" pattern="yyyy"/>
                                    <a download href="/static/notice/${year}/${n.id}/${fileName}">${fileName}</a> 
                                    <c:if test="${st.last == false}">
                                        /
                                    </c:if>
                                </c:forTokens>
                                </td>
                    </tr>
                </table>

            <div class="contect-us">
                <span>CONTECT US</span>
                <span>근손실처방전은 고객님의 목소리를 최우선으로 생각합니다.</span>
                <div class="contect-list">
                    <div class="item">
                        <a href="#"><img src="../image/kakao.png" alt="카카오톡문의"></a>
                        <span>카카오톡<br>문의</span>
                    </div>
                    <div class="item">
                        <a href="#"><img src="../image/email.png" alt="이메일문의"></a>
                        <span>이메일<br>문의</span>
                    </div>
                    <div class="item">
                        <a href="#"><img src="../image/call.png" alt="전화상담"></a>
                        <span>전화<br>상담</span>
                    </div>
                </div>
                <span>카카오톡/전화상담 운영시간</span>
                <span>평일 오전 10:00 ~ 오후 6:00</span>
            </div>
        </section>
    </main>

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