<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>product order form</title>
  </head>
  <body>
    <form action="edit" method="post">
      <fieldset>
        <h1>주문서</h1>
        <label for="product-name">
          상품명 : ${p.productName }
          <input type="hidden" name="product-name" value="${p.productName }" readonly
        /></label>
        <br />
        <label for="price">
          <fmt:formatNumber  var="commaPrice" type="number" maxFractionDigits="3" value="${p.price}"/>
          가격 : ${commaPrice }원
          <input type="hidden" name="price" value="${p.price}" readonly
        /></label>
        <br />
        <label for="count">
          개수 :
          <input type="number" min="1"; name="count" value="${p.productCount }"
        /></label>
        <br />
        <label for="sender-name">
          주문자 :
          <input type="text" name="sender-name" value="${p.senderName }" required
        /></label>
        <br />
        <label for="sender-phone">
          주문자 휴대폰 번호 :
          <input
            type="text"
            name="sender-phone"
            value="${p.senderPhone }"
            required
            placeholder="010-1234-5678"
        /></label>
        <br />
        <label for="receiver-name">
          수취인:
          <input type="text" name="receiver-name" value="${p.receiverName }" required
        /></label>
        <br />
        <label for="receiver-phone">
          수취인 휴대폰 번호 :
          <input
            type="text"
            name="receiver-phone"
            value="${p.receiverPhone }"
            required
            placeholder="010-1234-5678"
        /></label>
        <br />
        <label for="address">
          배송주소 :
          <input type="text" name="address" value="${p.address }" required
        /></label>
        <br />
        <input type="hidden" name="id" value="${p.id }">
        <input class="submit-button" type="submit" value="확인"
        />
        <a href="detail?${p.id }"><input class="submit-button" type="button" value="취소"
        /></a>
      </fieldset>
    </form>
  </body>
</html>
