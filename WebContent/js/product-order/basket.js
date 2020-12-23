window.addEventListener("load", function () {
  var checkboxAll = document.querySelector(".checkbox-all");
  var checkboxOne = document.querySelectorAll(".checkbox-one");

  checkboxAll.onclick = function () {
    if (checkboxAll.checked) for (var i = 0; i < checkboxOne.length; i++) checkboxOne[i].checked = true;
    else for (var i = 0; i < checkboxOne.length; i++) checkboxOne[i].checked = false;
  };
});
