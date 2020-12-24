<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/reset.css">
    <link rel="stylesheet" href="../CSS/user.css">
    <link rel="stylesheet" href="../CSS/product/detail.css">
    <script src="../js/product/detail.js"></script>
    <title>시설검색</title>
</head>

<body>
    <header>
        <h1><img class="logo-img" src="../image/gc_logo.png" alt="근처" /></h1>
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
                <li>LOGIN</li>
                <li>JOIN</li>
                <li>SEARCH</li>
            </ul>
        </nav>
    </header>
<!--?=======================main===============================-->
    <main>
        <section class="crumb">
            <h1 class="display-none">경로</h1>
            <span>메인 > 쇼핑몰</span>
            <span>보충제 | 비타민 | 에너지바</span>
        </section>
        <section class="product-block">
            <h1 class="display-none">상품정보영역</h1>            
                <div class="product-box">
                    <div class="images">
                        <div class="thumb">
                            <img src="../image/admin/product/impactwhey.png" alt="대표이미지" />
                        </div>
                        <div class="little">
                            <img src="" alt="대표이미지" />
                        </div>                    
                    </div>
                    <div class="information">
                        <div class="information-box">
                            <h1 class="mt10">상품명</h1>
                            <div class="mt10">브랜드</div>
                            <div class="mt10">카테고리</div>
                            <label class="option">옵 션: </label>
                                <select class="select mt10" name="taste-select" size="1">
                                    <option value="딸기">딸기</option>
                                    <option value="바나나">바나나</option>
                                </select><br>
                            <label class="count mt10">수 량: </label> 
                            <input class="input-text" type="text" name="count" value="1" />
                            <button class="plus-btn" >+</button>
                            <button class="minus-btn">-</button><br>
                            <label class="price-label">판매가: </label>
                            <label class="price"> XXX원 </label> 
                        </div>
                        <div class="buy-box">
                            <input class="basket buy-box-common" type="submit" value="장바구니 담기"></input>
                            <input class="buy buy-box-common" type="submit" value="상품 구입"></input>
                        </div>
                    </div>                    
                </div>
        </section>
        <section class="content-block">

        </section>
    </main>
<!--?=======================footer===============================-->
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