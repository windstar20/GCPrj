//=============pager AJAX==========
window.addEventListener("load", function () {
  var sortBar = document.querySelector(".sort-bar");
  var upButtons = sortBar.querySelectorAll(".up-button");
  var downButtons = sortBar.querySelectorAll(".down-button");
  var listTable = document.querySelector(".order-list-table");
  var tbody = listTable.querySelector("tbody");
  var paging = document.querySelector(".paging");

  paging.onclick = function (e) {
    if (e.target.tagName != "A") return;
    e.preventDefault();
    var page = parseInt(e.target.innerText);
    var urlSearch = new URLSearchParams(location.search); // 쿼리스트링 받아오기
    var size = urlSearch.get("size");
    var field = urlSearch.get("field");
    var query = urlSearch.get("query");
    var startDate = urlSearch.get("startDate");
    var endDate = urlSearch.get("endDate");
    var sortField = urlSearch.get("sort-field");
    var sortOption = urlSearch.get("sort-option");
    console.log(page, size, field, query, startDate, endDate);
    load(page, size, field, query, startDate, endDate, sortField, sortOption);
  };
  function load(page, size, field, query, startDate, endDate, sortField, sortOption) {
    if (page == undefined || page == NaN) page = 1;
    if (size == null || size == NaN) size = 10;
    if (field == null) field = "";
    if (query == null) query = "";
    if (startDate == null) startDate = "";
    if (endDate == null) endDate = "";
    if (sortField == null) sortField = "id";
    if (sortOption == null) sortOption = "asc";
    var request = new XMLHttpRequest();
    request.onload = function () {
      tbody.innerHTML = "";
      var lists = JSON.parse(request.responseText);
      for (var i = 0; i < lists.length; i++) {
        var c = lists[i];
        c.amount = c.amount.toLocaleString();
        if (c.content == null) c.content = "";

        var tr =
          "<tr>\
          <td>" +
          c.id +
          "</td>\
          <td>" +
          c.memberNicname +
          "</td>\
          <td>" +
          c.name +
          '</td>\
          <td>\
            <span class="price">' +
          c.amount +
          "</span>원\
          </td>\
          <td>" +
          c.content +
          "</td>\
          <td>\
          " +
          c.regdate +
          '\
          </td>\
          <td>\
            <a href="point-charge-del?id=' +
          c.id +
          '"\
              ><input\
                class="select-button"\
                type="button"\
                value="삭제"\
            /></a>\
          </td>\
        </tr>';

        tbody.insertAdjacentHTML("beforeend", tr);
      }
    };
    request.open(
      "GET",
      "/api/product-order/point-charge-list?page=" +
        page +
        "&size=" +
        size +
        "&field=" +
        field +
        "&query=" +
        query +
        "&start-date=" +
        startDate +
        "&end-date=" +
        endDate +
        "&sort-field=" +
        sortField +
        "&sort-option=" +
        sortOption,
      true
    );
    request.send();
  }
});

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

//=========날짜 일주일전, 한달 전 입력======
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
