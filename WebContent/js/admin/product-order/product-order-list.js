window.addEventListener("load", function () {
  var prices = document.querySelectorAll(".price");
  var totalPrice = document.querySelector(".total-price");
  var totalCount = document.querySelector(".total-count");
  var priceSum = 0;
  for (var i = 0; i < prices.length; i++) {
    var price = parseInt(prices[i].innerText.replace(",", ""));
    //prices[i].innerText ==> 태그안에 있는 text값을 읽어오는 코드
    //replace(",""") ==> , 을 공백으로 바꿔주는 코드
    priceSum += price;
  }
  priceSum = priceSum.toLocaleString(); // number에 comma를 붙여주는 코드(10000=> 10,000)
  totalPrice.innerText = priceSum;
  totalCount.innerText = prices.length;
});

window.addEventListener("load", function () {
  var orderListTable = document.querySelector(".order-list-table");
  var confirmMoneyBtn = orderListTable.querySelectorAll(".select-button")[0];
  var orderState = document.querySelector(".order-state");

  confirmMoneyBtn.onclick = function () {
    orderState.innerText = "입금완료";
  };
});
