<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../CSS/reset.css" type="text/css" rel="stylesheet">
    <link href="../../CSS/user.css" type="text/css" rel="stylesheet">
    <link href="../../CSS/user/login.css" type="text/css" rel="stylesheet">  
</head>
<body>
    <header>
        <h1><img class="logo-img" src="../../image/gc_logo2.png" alt="근처" /></h1>
        <nav>
            <ul class="menu-bar">
                <li>소개</li>
                <li>시설</li>
                <li>트레이너</li>
                <li>쇼핑몰</li>
            </ul>
        </nav>
        <nav>
            <ul class="menu-bar2">
                <li>HOME</li>
                <li>LOGIN</li>
                <li>SEARCH</li>
            </ul>
        </nav>
    </header>

    <main class="main">
    <section class="container">
            
            <table>
                <form>
                    <tr>
                        <td colspan="3">
                            <input type="radio" name="user-style" >일반회원
                            <input type="radio" name="user-style" >제휴업체
                        </td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" autofocus required></td>
                        <td rowspan="2">
                            <input type="submit" style="height: 50px;" value="로그인">
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="text" required></td>   
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3"><input type="checkbox">아이디 저장<br>
                        <input type="checkbox">비밀번호 저장</td>
                    </tr>
                </form>
            </table>
            <table>
                <tr>
                    <td>더 많은 혜택을 누리세요</td>
                    <td><a href="choicetype.html"><input type="submit" value="회원가입"></a></td>
                </tr>
                <tr>
                    <td>아이디를 잃어버리셨나요?</td>
                    <td><a href="find.html"><input type="submit" value="아이디 찾기"></a></td>
                </tr>
                <tr>
                    <td>비밀번호를 잃어버리셨나요?</td>
                    <td><a href="find.html"><input type="submit" value="비밀번호 찾기"></a></td>
                </tr>
            </table>
        </section>
    </main>
</body>
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
</html>