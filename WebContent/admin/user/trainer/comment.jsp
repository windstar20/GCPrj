<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../../CSS/reset.css">
    <link href="../../../CSS/admin/user/detail.css" type="text/CSS" rel="stylesheet">
    <link rel="stylesheet" href="../../../CSS/admin/user/trainer/commet.css">
    <script src="../../../js/userdetail.js"></script>
</head>

<body class="body">
    <header class="header">
        <h1>회원 상세정보</h1>
    </header>
    <main class="main">
            <div class="main-head">
                <h1>${t.name }님의 회원정보입니다.</h1>
                <div class="nav">
                    <a href="detail?id=${t.id }">회원정보</a>
                    <a href="commet?id=${t.id }">댓글</a>
                </div>               
            </div>
        <form class="serch-form" method="post">
            <table>
                <tr>
                    <th>검색키워드</th>
                    <td>
                        <select name="field" >
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                        </select>
                        <input type="text" name="query" >
                    </td>
                </tr>
                
                <tr>
                    <th>등록일</th>
                    <td>
                    	<input type="date" class="start-date" name="start-date" value="2020-12-01"/> ~ 
                    	<input type="date" class="end-date" name="end-date" />
                    </td>
                </tr>
            </table>
            <input class="form-button button" type="submit" value="검색">
        </form>
       
        <table>
            <thead>
                <td>제목</td>
                <td>내용</td>
                <td>작성시간</td>
                <td>관련정보</td>
            </thead>
            <tbody>
            <c:forEach var="c" items="${list }">
            	<tr>
	                <td>${c.title }</td>
	                <td>${c.content }</td>
	                <td>${c.regdate }</td>
	                <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        
        <input class="button" type="button" value="닫기">
        
    </main>


</body>

</html>