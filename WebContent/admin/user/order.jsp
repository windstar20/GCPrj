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
            <h1>주문 검색</h1>
            <form class="serch-form" action="">
                <table>
                    <tr>
                        <th>주문상태</th>
                        <td>
                            <input type="checkbox">전체
                            <input type="checkbox">입금완료 1
                            <input type="checkbox">배송준비 2
                            <input type="checkbox">배송중  3  
                            <input type="checkbox">배송완료 4
                        </td>
                    </tr>
                    <tr>
                        <th>취소상태</th>
                        <td>
                            <input type="checkbox">취소    5 
                            <input type="checkbox">환불    6
                            <input type="checkbox">입금완료 7
                            <input type="checkbox">반품    8
                        </td>
                    </tr>
                    <tr>
                        <th>날짜검색</th>
                        <td>
                        	<input type="date" class="start-date" name="start-date" value="2020-12-01"/> ~ 
                    		<input type="date" class="end-date" name="end-date" />	
                        </td>
                    </tr>
                </table>
                <input class="button" type="submit" value="검색">
            </form>
        </section>
        <section>
            <h1>주문 리스트</h1>
            <table>
                <thead>
                    <td>주문 일자</td>
                    <td>주문번호</td>
                    <td>내용</td>
                    <td>주문인</td>
                    <td>수령인</td>
                    <td>주문단계</td>
                </thead>
                <tbody>
                    <td></td>
                    <td></td>
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