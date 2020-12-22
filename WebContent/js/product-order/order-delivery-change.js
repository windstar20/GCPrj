window.addEventListener("load", function () {
  var submitBtn = document.querySelector(".submit-button");
  var openName = document.querySelector(".open-name");
  var openAddress = document.querySelector(".open-address");
  var openPhone = document.querySelector(".open-phone");

  submitBtn.onclick = function (e) {
    e.preventDefault();
    var receiverName = opener.document.querySelector(".receiver-name");
    var address = opener.document.querySelector(".address");
    var receiverPhone = opener.document.querySelector(".receiver-phone");
    receiverName.value = openName.value;
    address.value = openAddress.value;
    receiverPhone.value = openPhone.value;
    window.close();
  };
});
