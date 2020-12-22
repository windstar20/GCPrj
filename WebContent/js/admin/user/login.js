window.addEventListener("load",function(){
var menuBar2 = document.querySelector(".menu-bar2");
var home = document.querySelector(".Home");
var login = document.querySelector(".Login");
var search = document.querySelector(".Search");

login.onclick = function(){
    console.log("test");
    open("../../../user/sign/login.html","_login","width=300px,height=500px");
}

});