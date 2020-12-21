<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/reset.css" type="text/css">
    <link rel="stylesheet" href="../../CSS/style.css" type="text/css">
    <link rel="stylesheet" href="../../CSS/admin/admin.css" type="text/css">
    <link rel="stylesheet" href="../../CSS/admin/notice/reg.css" type="text/css">
    <title>공지사항 등록</title>
</head>

<body>
    <header id="header" class="header">
        <div class="logo-bar">
            <h1 class="no-display">근처</h1>
            <a href="">
                <div class="logo"></div>
            </a>
            <ul>
                <li><button class="logout">로그아웃</button></li>
            </ul>
        </div>
        <nav id="nav" class="nav">
            <h1 class="no-display">메뉴</h1>
            <ul>
                <li><a href="#">기본설정</a></li>
                <li><a href="#">상품관리</a></li>
                <li><a href="#">주문관리</a></li>
                <li><a href="#">회원관리</a></li>
                <li><a href="list">게시판관리</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </nav>
    </header>

    <div id="body" class="body">
        <aside class="aside">
            <h1 class="aside-title img-button">공지사항관리</h1>
            <ul class="aside-menu">
                <li>공지사항 관리</li>
                <ul>
                    <li><a href="list">공지사항 리스트</a></li>
                    <li><a href="reg">공지사항 등록</a></li>
                </ul>
                <br />
            </ul>
        </aside>
        <section class="main-section">
            <main id="main" class="main">
                <div class="main-head">
                    <h1>공지사항 등록</h1>
                    <span class="span1"> home > 게시판관리 > 공지사항 > 공지사항 등록 </span>
                </div>

                <div class="main-body">
                    <form action="reg" method="post" enctype="multipart/form-data">
                        <section id="content" class="content">
                            <h1 class="no-display">공지사항 등록</h1>
                            <table class="table-wrap" border="1">
                                <tr>
                                    <th>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                                    <td class="td-small">&nbsp;&nbsp;&nbsp;<input autofocus required type="text" name="title"></td>
                                    <th>작&nbsp;성&nbsp;자</th>
                                    <td class="td-small">&nbsp;&nbsp;&nbsp;관리자</td>
                                </tr>
                                <tr>
                                <tr>
                                    <th>첨&nbsp;부&nbsp;파&nbsp;일</th>
                                    <td class="td-small">&nbsp;&nbsp;&nbsp;<input type="file" name="file"></td>
                                    <th>작&nbsp;성&nbsp;일&nbsp;자</th>
                                    <td class="td-small">&nbsp;&nbsp;&nbsp;2020-11-11</td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <textarea class="texta" name="content"></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div class="btn">
                                <input class="butt" type="submit" value="등&nbsp;&nbsp;록" />
                                <button class="butt" href="list">취&nbsp;&nbsp;소</a>
                            </div>
                        </section>
                    </form>
                </div>
            </main>
        </section>
    </div>
    <section>
        <footer id="footer" class="footer">
            <h1>푸터</h1>
        </footer>
    </section>
</body>

</html>