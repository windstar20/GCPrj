<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../CSS/reset.css">
    <link href="../../CSS/admin/user/detail.css" type="text/CSS" rel="stylesheet">
    <link rel="stylesheet" href="../../CSS/admin/user/detail-point.css">
</head>
<body>
    <header class="header">
        <h1>회원 상세정보</h1>
    </header>
    <main class="main">
        <div class="main-head">
            <h1>${u.name }님의 회원정보입니다.</h1>
            <nav>
                <ul>
                    <li><a href="detail?id=${u.id }">회원정보</a></li>
                    <li><a href="order?id=${u.id }">주문정보</a></li>
                    <li><a href="detail-point?id=${u.id }">포인트</a></li>
                    <li><a href="evaluaion?id=${u.id }">작성한 평가</a></li>
                </ul>
            </nav>
        </div>
        <section>
            <h1>포인트</h1>
            <table>
                <tr>
                    <th>포인트 총계</th>
                    <td>
                        현재 보유 포인트<br>
                        총 충전 포인트
                    </td>
                </tr>
            </table>
        </section>
        <section>
            <h1>포인트 기록</h1>
            <table>
                <thead>
                    <td>거래시각</td>
                    <td>금액</td>
                    <td>내용</td>
                    <td>사용처</td>
                </thead>
                <tbody>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tbody>
            </table>
        </section>
    </main>

</body>
</html>