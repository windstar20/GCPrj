<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>product order form</title>
    <script src="form.js"></script>
  </head>
  <body>
    <form action="reg" method="post">
      <fieldset>
        <h1>주문서</h1>
        <label for="product-name">
          상품명 : 에너지바<input type="hidden" name="product-name" value="에너지바"
        /></label>
        <br />
        <label for="price">
          가격 :
          <fmt:formatNumber  var="commaPrice" type="number" maxFractionDigits="3" value="7000"/>
          ${commaPrice }원<input type="hidden" name="price" value="7000"
        /></label>
        <br />
        <label for="count">
          개수 :
          <input type="number" min="1"; name="count" value="1"
        /></label>
        <br />
        <label for="sender-name">
          주문자 :
          <input type="text" name="sender-name" required
        /></label>
        <br />
        <label for="sender-phone">
          주문자 휴대폰 번호 :
          <input
            type="text"
            name="sender-phone"
            required
            placeholder="010-1234-5678"
        /></label>
        <br />
        <label for="receiver-name">
          수령인:
          <input type="text" name="receiver-name" required
        /></label>
        <br />
        <label for="receiver-phone">
          수령인 휴대폰 번호 :
          <input
            type="text"
            name="receiver-phone"
            required
            placeholder="010-1234-5678"
        /></label>
        <br />
        <label for="address">
          배송주소 :
          <input type="text" name="address" required
        /></label>
        <br />
        <input class="submit-button" type="submit" value="구매"
        />
      </fieldset>
    </form>
  </body>
</html>
