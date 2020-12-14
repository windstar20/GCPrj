window.addEventListener("load", function () {
  var submitButton = document.querySelector(".submit-button");
  var form = document.querySelector("form");
  submitButton.onclick = function () {
    var confirmValue = confirm("구매하시겠습니까?");
    if (!confirmValue) return;
  };
});
