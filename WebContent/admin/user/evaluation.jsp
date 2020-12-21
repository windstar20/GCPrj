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
            <h1>평가 검색</h1>
            <form class="serch-form" action="">
                <table>
                    <tr>
                        <th>평가 항목</th>
                        <td>
                            <select name="">
                                <option value="">전체</option>
                                <option value="">시설</option>
                                <option value="">트레이너</option>
                                <option value="">쇼핑몰</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td>
	                        <input type="date" class="start-date" name="start-date" value="2020-12-01"/> ~ 
	                    	<input type="date" class="end-date" name="end-date" />
                        </td>
                    </tr>
                    <tr>
                        <th>검색키워드</th>
                        <td>
                            <select name="field" >
                                <option value="title">제목</option>
                                <option value="content">내용</option>
                            </select>
                            <input type="text" name="query">
                        </td>
                    </tr>
                </table>
                <input class="button" type="submit" value="검색">
            </form>
        </section>
        <section>
            <h1>평가 리스트</h1>
            <table>
                <thead>
                    <td>평가 항목</td>
                    <td>제목</td>
                    <td>내용</td>
                    <td>작성일</td>
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