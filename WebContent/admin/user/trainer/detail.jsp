<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/CSS/reset.css" type="text/CSS" rel="stylesheet">
    <link href="../../../CSS/admin/user/detail.css" type="text/CSS" rel="stylesheet">
    <script src="../../../js/userdetail.js"></script>
</head>

<body class="body">
    <header class="header">
        <h1>회원 상세정보</h1>
    </header>
    <main class="main">
		<div class="main-head">
			<h1>${t.name }님의 회원정보입니다.</h1>
			<nav>
				<ul>
					<li><a href="detail?id=${t.id }"><span>회원정보</span></a></li>
					<li><a href="comment?id=${t.id }"><span>댓글</span></a></li>
				</ul>
			</nav>
        </div>        
        <form action="">
            <table>
                <tr>
                    <td> 이미지 </td>
                    <td>회원기본 정보</td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td>
                       	${t.name }                      
                    </td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        ${t.gender }
                    </td>
                </tr>
                <tr>
                    <th>소속</th>
                    <td>
                        ${t.gymName }
                    </td>
                </tr>
                <tr>
                    <th>소속 주소</th>
                    <td>
                        ${t.gymAdress }
                    </td>
                </tr>
                <tr>
                    <th>휴대전화</th>
                    <td>
                         ${t.phone }
                    </td>
                </tr>                
                <tr>
                    <th>자격증</th>
                    <td>
                		<table class="inner-table">
	                	<c:forEach var="lList" items="${lList}">
                			<tr>
                				<th>이름</th>
			                    <td>
			                        ${lList.name } 
			                    </td>
		                    </tr>
		                    <tr>
		                    	<th>내용</th>
			                    <td>
			                        ${lList.content }
			                    </td>
		                    </tr>
		                    <tr>
		                    	<th>기관</th>
			                    <td>
			                        ${lList.organ }
			                    </td>
		                    </tr>
	                    </c:forEach>
	                    </table>
                    </td>
                </tr>
                <tr>
                    <th>입상경력</th>
                    <td>
	                    <table class="inner-table">
		                <c:forEach var="cList" items="${cList }">
                			<tr>
                				<th>이름</th>
			                    <td>
			                        ${cList.name } 
			                    </td>
		                    </tr>
		                    <tr>
		                    	<th>내용</th>
			                    <td>
			                        ${cList.content }
			                    </td>
		                    </tr>
		                    <tr>
		                    	<th>날짜</th>
			                    <td>
			                        ${cList.date }
			                    </td>
		                    </tr>
	                    </c:forEach>
	                    </table>
                    </td>
                </tr>
                <tr>
                    <th>회원등급</th>
                    <td>
                        트레이너
                    </td>
                </tr>

                <tr>
                    <td>회원 이용정보</td>
                </tr>
                <tr>
                    <th>등록일</th>
                    <td>${t.regdate }</td>
                </tr>
                <tr>
                    <th>이용 고객수</th>
                    <td>
						${t.resCnt }
                    </td>
                </tr>
                <tr>
                    <th>댓글 등록 횟수</th>
                    <td>
						${t.cmtCnt }
                    </td>
                </tr>
            </table>
        </form>
           
           
           
        <h1>소속 정보</h1>
        <table>
            <tr>
                <th>사업자번호</th>
                <td>
                    ${t.license }
                </td>
            </tr>
            <tr>
                <th>상호 법인명</th>
                <td>
                    ${t.gymName }
                </td>
            </tr>
            <tr>
                <th>대표자 성함</th>
                <td>
                    ${t.gName }
                </td>
            </tr>
            <tr>
                <th>사업장 소재지</th>
                <td>
                    ${t.gymAdress }
                </td>
            </tr>
            <tr>
                <th>업종</th>
                <td>
                    헬스클럽
                </td>
            </tr>
            <!-- ============================== -->
           
        </table>

            
        <div>
            <input type="button" value="닫기">
        </div>
    </main>


</body>

</html>