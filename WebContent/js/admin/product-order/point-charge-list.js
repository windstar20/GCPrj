//===========회원 현재 금액 ============
window.addEventListener("load", function () {});
function searchQueryString(key) {
  return new URLSearchParams(location.search).get(key);
}
//============금액/ 건수 정리 =================
window.addEventListener("load", function () {
  var prices = document.querySelectorAll(".price");
  var totalPrice = document.querySelector(".total-price");
  var totalCount = document.querySelector(".total-count");
  var priceSum = 0;
  for (var i = 0; i < prices.length; i++) {
    var price = parseInt(prices[i].innerText.replace(",", ""));
    priceSum += price;
  }
  priceSum = priceSum.toLocaleString(); // number에 comma를 붙여주는 코드(10000=> 10,000)
  totalPrice.innerText = priceSum;
  totalCount.innerText = prices.length;
});

window.addEventListener("load", function () {
  var buttonList = document.querySelector(".button-list");
  var btnYesterday = document.querySelector(".yesterday");
  var startDate = document.querySelector(".start-date");
  var endDate = document.querySelector(".end-date");
  var btnToday = document.querySelector(".today");
  var btnWeek = document.querySelector(".this-week");
  var btnMonth = document.querySelector(".this-month");
  var btnAllDate = document.querySelector(".all-date");

  btnYesterday.onclick = function (e) {
    e.preventDefault();
    var nowDate = new Date();
    var nowYear = nowDate.getFullYear();
    var nowMonth = nowDate.getMonth() + 1;
    var nowDay = nowDate.getDate();

    var yesterDate = nowDate.getTime() - 1 * 24 * 60 * 60 * 1000;
    nowDate.setTime(yesterDate);

    var yesterYear = nowDate.getFullYear();
    var yesterMonth = nowDate.getMonth() + 1;
    var yesterDay = nowDate.getDate();

    startDate.value = getTimeStamp(yesterYear, yesterMonth, yesterDay);
    endDate.value = getTimeStamp(nowYear, nowMonth, nowDay);
  };
  btnToday.onclick = function (e) {
    e.preventDefault();
    var nowDate = new Date();
    var nowYear = nowDate.getFullYear();
    var nowMonth = nowDate.getMonth() + 1;
    var nowDay = nowDate.getDate();

    startDate.value = getTimeStamp(nowYear, nowMonth, nowDay);
    endDate.value = getTimeStamp(nowYear, nowMonth, nowDay);
  };
  btnWeek.onclick = function (e) {
    e.preventDefault();
    var nowDate = new Date();
    var nowYear = nowDate.getFullYear();
    var nowMonth = nowDate.getMonth() + 1;
    var nowDay = nowDate.getDate();

    var weekDate = nowDate.getTime() - 7 * 24 * 60 * 60 * 1000;
    nowDate.setTime(weekDate);

    var weekYear = nowDate.getFullYear();
    var weekMonth = nowDate.getMonth() + 1;
    var weekDay = nowDate.getDate();

    startDate.value = getTimeStamp(weekYear, weekMonth, weekDay);
    endDate.value = getTimeStamp(nowYear, nowMonth, nowDay);
  };
  btnMonth.onclick = function (e) {
    e.preventDefault();
    var nowDate = new Date();
    var nowYear = nowDate.getFullYear();
    var nowMonth = nowDate.getMonth() + 1;
    var nowDay = nowDate.getDate();

    var monthDate = nowDate.getTime() - 30 * 24 * 60 * 60 * 1000;
    nowDate.setTime(monthDate);

    var monthYear = nowDate.getFullYear();
    var monthMonth = nowDate.getMonth() + 1;
    var monthDay = nowDate.getDate();

    startDate.value = getTimeStamp(monthYear, monthMonth, monthDay);
    endDate.value = getTimeStamp(nowYear, nowMonth, nowDay);
  };
  btnAllDate.onclick = function (e) {
    e.preventDefault();
    var nowDate = new Date();
    var nowYear = nowDate.getFullYear();
    var nowMonth = nowDate.getMonth() + 1;
    var nowDay = nowDate.getDate();

    startDate.value = "2020-12-01";
    endDate.value = getTimeStamp(nowYear, nowMonth, nowDay);
  };
});

//====날짜 포맷========
function getTimeStamp(y, m, d) {
  if (m < 10) m = "0" + m;
  if (d < 10) d = "0" + d;
  var s = y + "-" + m + "-" + d;
  return s;
}

//=====================
