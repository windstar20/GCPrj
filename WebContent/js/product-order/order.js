window.addEventListener("load", function () {
  var deliveryLocationBtn = document.querySelector(".delivery-location-button");

  deliveryLocationBtn.onclick = function () {
    open("order-delivery-change.html", "_blank", "width=350px, height=350px", true);
  };
});
