<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../CSS/reset.css" type="text/css" rel="stylesheet">
    <link href="../../CSS/style.css" type="text/css" rel="stylesheet">
    <link href="../../CSS/user/user-signin.css" type="text/css" rel="stylesheet"> 
    <script src="../../js/admin/user/overlap.js"></script>
    <title>시설검색</title>
</head>

<body>
    <header>
        <h1><img class="logo-img" src="../../image/gc_logo.png" alt="근처" /></h1>
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

    <main id="main" class="main">
        <section class="main-container">
            <form class="main-contant">
                <h1>필수정보</h1>
                    <table>
                        <!-- <tr>
                            <th>아이디</th>
                            <td>
                                <form action="overlap">
                                    <input type="text" name="nicname" autocomplete="off" autofocus required pattern="^\w{8,15}$" >
                                    <input class="overlap" type="submit" name="nicname" value="중복확인" ><br>
                                 </form>
                                <font color="red" size="1">*영어/숫자 혼합 8~15자리 입력하세요</font>
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                            <td><input type="password" required >
                                <font color="red" size="1">*영어/숫자 혼합 6자리이상 입력</font>
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호확인</th>
                            <td>
                                <input type="password" required >
    
                            </td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td>
                                <input type="text" required >
                            </td>
                        </tr> -->
                        <tr>
                            <th>이메일</th>
                            <td class="email">
                                <input type="text" required >@
                                <input type="text" name="EmailDomain" required >
                                <select onchange="this.form.EmailDomain.value=this[this.selectedIndex].value;">
                                    <option value="" selected="selected">선택</option>
                                    <option value="naver.com">네이버</option>
                                    <option value="hanmail.net">한메일</option>
                                    <option value="gmaile.com">구글</option>
                                    <option value="nate.com">네이트</option>
                                    <option value="empal.com">엠파스</option>
                                    <option value="hotmail.com">핫메일</option>
                                    <option value="yahoo.co.kr">야후</option>
                                    <option value="hanmir.com">한미르</option>
                                    <option value="">직접입력</option>
                                </select><br>
                                <input type="checkbox">
                                <font color="red" size="2"> 이벤트 및 소식지 등 유용한 정보를 수신하겠습니다.</font>
                            </td>
                        </tr>
                        <tr>
                            <th>성별</th>
                            <td>
                                <form>
                                    <input type="radio" id="male" name="gender" value="male" required >
                                    <label for="male">남자</label>
                                    <input type="radio" id="female" name="gender" value="female" required >
                                    <label for="female">여자</label>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th>생년월일</th>
                            <td>
                                <input type="number" min="1940" max="2010" style="width: 70px;" required >년
                                <input type="number" min="1" max="12" style="width: 50px;" required >월
                                <input type="number" min="1" max="31" style="width: 50px;" required >일
                                <input type="checkbox">음력
                            </td>
                        </tr>
                        <tr>
                            <th>휴대폰 번호</th>
                            <td>
                                <input type="text" style="width: 50px;" autocomplete="off"  pattern="^01(?:0|1|[6-9])$" required> -
                                <input type="text" style="width: 50px;" autocomplete="off"  pattern="^\d{4}$" required> -
                                <input type="text" style="width: 50px;" autocomplete="off"  pattern="^\d{4}$" required><br>
                                <input type="checkbox">
                                <font color="red" size="2"> 거래 및 활동정보를 문자메시지(SMS)로 수신합니다.</font>
                            </td>
                        </tr>
                        <tr id="address">
                            <th>주소</th>
                            <td>
                                <input class="address2" type="text" style="width: 70px;" required>
                                <input type="button" value="우편번호검색"> <br>
                                <input type="text" style="width: 400px;" required>
                                <br>상세주소
                                <input type="text" style="width: 330px;" required >
                            </td>
                        </tr>
                    </table>

                    <h1>추가정보</h1>
                    <table >
                        <tr>
                            <th>추천인ID</th>
                            <td>
                                <input type="text" style="width: 100px;">
                                <input type="submit" value="추천인 확인">
                            </td>
                        </tr>
                    </table>
    
                <div class="signin-button-menu">
                    <a href="choicetype.html"><input class="be-button" type="submit" value="이전"></a>
                    <input class="signin-button" type="submit" value="가입완료">
                </div>
            </form>
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