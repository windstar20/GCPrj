<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../CSS/reset.css" type="text/CSS" rel="stylesheet">
    <link href="../../CSS/style.css" type="text/CSS" rel="stylesheet">
    <link href="../../CSS/admin/user/detail.css" type="text/CSS" rel="stylesheet">
    
    <script src="../../js/admin/admin/detail.js"></script>
</head>

<body>
    <header class="header">
        <h1>회원 상세정보</h1>
        <div>닫기</div>
    </header>
    <main class="main">
        <form action="">
                    <div class="title">
                    > 회원정보
                    </div>
            <table>
                <tr>
                    <th>이름(아이디)</th>
                    <td>
                        홍길동 (test)
                    </td>
                </tr>
                <tr>
                    <th>나이/성별/생일</th>
                    <td>
                        정보없음 / 정보없음 / 정보없음
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>
                        jilong78@whois.co.kr 
                        <input type="checkbox"> 수신동의
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>
                        (08378) 서울특별시 구로구 디지털로34길 43 (구로동 코오롱싸이언스밸리1차) 111
                    </td>
                </tr>
                <tr>
                    <th>휴대전화</th>
                    <td>
                        휴대전화 : 
                        <input type="checkbox"> 수신동의
                    </td>
                </tr>
                <tr>
                    <th>개인정보</th>
                    <td>
                        개인정보 제3자 제공 : 동의안함 / 개인정보 취급위탁 : 동의안함
                    </td>
                </tr>
                <tr>
                    <th>회원등급</th>
                    <td>
                        일반회원
                    </td>
                </tr>
            </table>
            <div class="title">
                > 회원 이용정보 
            </div>    
            <table>
                <tr>
                    <th>가입일</th>
                    <td>2018.02.01 10:25 (마지막 로그인: 정보없음 / 로그인 횟수:0 회)</td>
                </tr>
                <tr>
                    <th>주문총액</th>
                    <td>0원 (주문횟수 : 0 건 / 취소.반품.환불.교환 : 0 회 )</td>
                </tr>
                <tr>
                    <th>게시물</th>
                    <td>1:1 상담 (0 건) 상품문의 (0 건) 사용후기 (0 건)</td>
                </tr>
                <tr>
                    <th>장바구니/관심상품</th>
                    <td>장바구니/관심상품 장바구니: 상품 (0 개) 관심상품: 상품 (0 개)</td>
                </tr>
                <tr>
                    <th>가입추천 로그</th>
                    <td>내가 추천한 사람: 0명 / 나를 추천한 사람: 0 명</td>
                </tr>
            </table>
        </form>
        <div class="title">
            > 사업자 정보
        </div> 
         
        <section class="entrepreneur">
            <table>
                <tr>
                    <th>사업자번호</th>
                    <td>
                        <input type="text">
                    </td>
                </tr>
                <tr>
                    <th>상호 법인명</th>
                    <td>
                        <input type="text">
                    </td>
                </tr>
                <tr>
                    <th>성명</th>
                    <td>
                        <input type="text">
                    </td>
                </tr>
                <tr>
                    <th>사업장 소재지</th>
                    <td>
                        <input type="text">
                    </td>
                </tr>
                <tr>
                    <th>업종</th>
                    <td>
                        <input type="text">
                    </td>
                </tr>
            </table>
        </section>
        <div>
            <input class="close-button" type="submit" value="닫기">
        </div>
    </main>


</body>

</html>