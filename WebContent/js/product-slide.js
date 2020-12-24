window.addEventListener("load", function () {
  var productSlide = document.querySelector("#product-slide");
  var ul = productSlide.querySelector("ul");
  var prevBtn = productSlide.querySelector(".prev-button");
  var nextBtn = productSlide.querySelector(".next-button");

  var current = ul.querySelector("li:nth-child(3)");
  var index = 0;

  prevBtn.onclick = function () {
    if (current.previousElementSibling == null) {
      return;
    }
    index++;
    var x = index * 250 + "px";
    ul.style.transform = "translateX(" + x + ")";

    current.classList.remove("current");
    current = current.previousElementSibling;
    current.classList.add("current");
  };

  nextBtn.onclick = function () {
    if (current.nextElementSibling == null) {
      return;
    }
    index--;
    var x = index * 250 + "px";
    ul.style.transform = "translateX(" + x + ")";

    current.classList.remove("current");
    current = current.nextElementSibling;
    current.classList.add("current");
  };
});
