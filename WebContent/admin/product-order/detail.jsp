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
    <form action="detail" method="get">
      <fieldset>
        <h1>주문서</h1>
        <label for="product-name">
           <span>상품명 : ${p.productName }</span> 
        </label>
        <br />
        <label for="price">
        <fmt:formatNumber  var="commaPrice" type="number" maxFractionDigits="3" value="${p.price}"/>
          <span>가격 : ${commaPrice }원</span> 
        </label>
        <br />
        <label for="count">
         <span> 개수 : ${p.productCount }</span>
        </label>
        <br />
        <label for="sender-name">
          <span>주문자 : ${p.senderName }</span>
         </label>
        <br />
        <label for="sender-phone">
        <span>주문자 휴대폰 번호 : ${p.senderPhone }</span>
         </label>
        <br />
        <label for="receiver-name">
          <span>수령인: ${p.receiverName }</span>
          </label>
        <br />
        <label for="receiver-phone">
         <span>수령인 휴대폰 번호 : ${p.receiverPhone }</span>
          </label>
        <br />
        <label for="address">
         <span>배송주소 : ${p.address }</span>
          </label>
        <br />
        <a href="list"><input class="submit-button" type="button" value="확인"/></a>
        <a href="edit?id=${p.id }"><input class="submit-button" type="button" value="수정"/></a>
        <a href="list"><input class="submit-button" type="button" value="취소"/></a>
        
      </fieldset>
    </form>
  </body>
</html>
