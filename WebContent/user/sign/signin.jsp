<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../CSS/reset.css" type="text/css" rel="stylesheet">
    <link href="../../CSS/style.css" type="text/css" rel="stylesheet">
    <link href="../../CSS/user/user-signin.css" type="text/css" rel="stylesheet"> 
    <script src="../jsp/address.js"></script>
</head>
<body>
    <header id="header" class="header">
        <div class="header-container">
            <h1><a href="">근손실처방전</a></h1>
        
            <section class="gc-form">
                <form>
                    <h1 class="no-display">강좌검색폼</h1>
                    <label>위치 검색</label>
                    <input type="text" class="input">
                    <input class="img-button find-button" type="submit" value="검색">
                </form>
            </section>
            <nav class="member-menu">
                <h1 class="no-display">회원메뉴</h1>
                <ul class="member-menu-list">
                    <li><a href="../index.html">HOME</a></li>
                    <li><a href="login.html">로그인</a></li>
                    <li><a href="signin.html">회원가입</a></li>
                 </ul>   
            </nav>
            <nav class="shortcut-menu">
                <h1 class="no-display">바로가기 메뉴</h1>
                <ul class="shortcut-menu-list">
                    <li><a class="img-button mypage-button" href="">마이페이지</a></li>
                    <li><a class="img-button customer-button" href="list.html">고객센터</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <section id="main" class="main">
        <main class="main-container">
            <form class="main-contant">
                <h1>필수정보</h1>
                    <table>
                        <tr>
                            <th>아이디</th>
                            <td>
                                <input name="name" autocomplete="off" autofocus pattern="^\D{1,5}\d{1,5}">
                                <input type="submit" value="아이디중복확인"><br>
                                <font color="red" size="1">*영어/숫자 혼합 6자리이상 입력</font>
                            </td>
                        </tr>
                        <tr>
                            <th>닉네임</th>
                            <td>
                                <input type="text" >
                                <input type="submit" value="중복확인">
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                            <td><input type="password" >
                                <font color="red" size="1">*영어/숫자 혼합 6자리이상 입력</font>
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호확인</th>
                            <td>
                                <input type="password" >
    
                            </td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td>
                                <input type="text" >
                            </td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td>
                                <input type="text" >@
                                <input type="text" >
                                <select>
                                    <option>직접입력</option>
                                    <option>naver.com</option>
                                    <option>hanmail.net</option>
                                    <option>gmaile.com</option>
                                    <input type="submit" value="메일중복확인">
                                </select><br>
                                <font color="red" size="2"> 이벤트 및 소식지 등 유용한 정보를 수신하겠습니다.</font>
                            </td>
                        </tr>
                        <tr>
                            <th>성별</th>
                            <td>
                                <form>
                                    <input type="radio" id="male" name="gender" value="male" >
                                    <label for="male">남자</label>
                                    <input type="radio" id="female" name="gender" value="female" >
                                    <label for="female">여자</label>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th>생년월일</th>
                            <td>
                                <input type="number" min="1940" max="2010" style="width: 70px;" >년
                                <input type="number" min="1" max="12" style="width: 50px;" >월
                                <input type="number" min="1" max="31" style="width: 50px;" >일
                                <input type="checkbox">음력
                            </td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td>
                                <input type="text" style="width: 50px;" autocomplete="off"  pattern="^\d{2,3}$"> -
                                <input type="text" style="width: 50px;" autocomplete="off"  pattern="^\d{3,4}$"> -
                                <input type="text" style="width: 50px;" autocomplete="off"  pattern="^\d{4}$"><br>
                                <font color="red" size="2"> 거래 및 활동정보를 문자메시지(SMS)로 수신합니다.</font>
                            </td>
                        </tr>
                        <tr id="address">
                            <th>주소</th>
                            <td>
                                <input class="address2" type="text" style="width: 70px;">
                                <input type="button" value="우편번호검색"> <br>
                                <input type="text" style="width: 400px;">
                                <br>상세주소
                                <input type="text" style="width: 330px;" >
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
                    <a href="choicetype.html"><input class="img-button be-button" type="submit" value="이전"></a>
                    <input class="img-button signin-button" type="submit" value="가입완료">
                </div>
            </form>
        </main>
    
                <!-- <div class="right-aside">
                    <h1>약관동의</h1>

                    <p>전체동의<input type="checkbox"></p>
                    <p>*기업회원 약관에 동의 <u><i>상세보기</i></u><input type="checkbox"></p>
                    <p>*개인정보 수집 및 이용에 동의 <u><i>상세보기</i></u><input type="checkbox"></p>
                </div> -->
    </section>
<footer class="footer">
        <h1>footer 부분</h1>
</footer>
</body>

</html>
    