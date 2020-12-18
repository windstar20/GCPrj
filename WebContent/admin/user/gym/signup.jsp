<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link href = "../../../CSS/reset.css" type = "text/css" rel = "stylesheet">
    <link href = "../../../CSS/admin/user/gym/signup.css" type = "text/css" rel = "stylesheet">
</head>
<body>
    <header id = "header" class = "header">
        <div class ="logo-bar">
            <h1 class = "no-display">로고</h1>
            <a href=""><div class ="logo"></div></a>
        </div>
    </header>
    <div class = "body" >
        <aside>

        </aside>
        <section>
            <main id = "main" class = "main">
                <h1>필수정보</h1>
                <table border="1" class ="main-table">
                
                    <tr>
                        <th>아이디</th>
                        <td>
                            <input type = "text" maxlength = "10">
                            <input type = "submit" value = "아이디 중복확인">
                            <font color = "red" size = "2">10글자 이하로 작성해주세요</font>
                        </td>
                    </tr>
                
                    <tr>
                        <th>비밀번호</th>
                        <td>
                            <input type = "password" maxlength = "8">
                            <font color = "red" size = "2">8글자 이하로 적어주세요</font>
                        </td>
                    </tr>

                    <tr>
                        <th>비밀번호 확인</th>
                        <td>
                            <input type = "password" maxlength = "8" >
                            <font color = "red" size = "2">비밀번호를 다시 입력해주세요</font>
                        </td>
                    </tr>

                    <tr>
                        <th>이름</th>
                        <td><input type = "text"></td>
                    </tr>

                    <tr>
                        <th>전화번호</th>
                        <td>
                            <select>
                                <option>02</option>
                                <option>031</option>
                            </select>
                            - <input type = "text" maxlength = "5" style = "width: 50px;">
                            - <input type = "text" maxlength = "5" style = "width: 50px;"><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <th>휴대전화</th>
                        <td>
                            <select>
                                <option>010</option>
                                <option>011</option>
                            </select>
                            - <input type = "text" maxlength = "4" style = "width: 50px;" pattern = "\d{3,4}">
                            - <input type = "text" maxlength = "4" style = "width: 50px;" pattern=  "\d{3}">
                                <input type = "submit" value = "휴대폰 번호 인증" ><br>
                                <input type = "checkbox"><font color = "red" size = "2">거래 및 활동정보를 문자메시지(SMS)로 수신합니다</font>
                            
                        </td>
                    </tr>

                    <tr>
                    <th> 이메일</th>
                    <td>
                        <input type = "text">
                        @
                            <select>
                                <option>직접입력</option>
                                <option>naver.com</option>
                                <option>daum.net</option>
                                <option>gmail.com</option>
                            </select>
                            <input type = "submit" value = "메일 중복확인"><br>
                            <input type = "checkbox"><font color = "red" size = "2">이벤트 및 소식지 등 유용한 정보를 수신하겠습니다</font>
                        </td>
                    </tr>

                    <tr>
                        <th>업체 주소</th>
                        <td>
                            <input type = "text" style = "width: 30px;">
                            -<input type = "text" style = "width: 30px;">
                            <input type = "submit" value = "우편번호검색"><br>
                            <input type = "text" style = "width: 200px;">
                        </td>
                    </tr>
                
                    <tr>
                        <th>사업자 등록번호</th>
                        <td>
                        <input type = "text" style = "width: 40px;" maxlength = "3">
                        - <input type = "text" style = "width: 40px;" maxlength = "2">
                        - <input type = "text" style = "width: 40px;" maxlength = "5">
                        <input type = "submit" value = "등록">
                        </td>    
                    </tr>
                </table>

                <h2>추가정보</h2>
                <table class ="second-table">
                    <tr>
                        <th>추천인ID</th>
                        <td>
                            <input type ="text">
                            <input type = "submit" value = "추천인확인">
                        </td>
                    </tr>
                </table>
                
                    <h2>약관동의</h2>
            
                    전체동의<input type = "checkbox"><br>
                    *기업회원 약관에 동의 <u><a href = "http://www.saramin.co.kr/zf_user/help/terms-of-service/company">상세보기</a></u><input type = "checkbox"><br>
                    *개인정보 수집 및 이용에 동의<u><a href = "http://www.saramin.co.kr/zf_user/popup/clause-privacy?highlight = collectionAccess"> 상세보기</a></u><input type ="checkbox"><br>
                    마케팅 정보 수신 동의 - 이메일 (선택) <input type = "checkbox"><br>
                    마케팅 정보 수신 동의 - SMS/MMS (선택) <input type = "checkbox"><br>
                    개인정보 제 3자 제공 및 위탁사항 이용약관<u><a href = "http://www.saramin.co.kr/zf_user/popup/clause-privacy?highlight=thirdParty"> 상세보기</a></u><br>
                    정보보유기간<input type = "checkbox">1년
                    <input type = "checkbox">3년
                    <input type = "checkbox">5년
                    <input type = "checkbox">탈퇴시<br>

                    <a href = userpage.html><input type = "submit" value = "회원가입"></a>
            </main>
        </div>
        </section>
            <footer class = "footer">
                <h1 class ="no-display">푸터</h1>
                근처 고객님의 성공과 함께합니다
            </footer>
</body>
</html>