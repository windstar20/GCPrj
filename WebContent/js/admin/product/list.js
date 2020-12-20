//CHECKBOX 전체선택/해제
window.addEventListener("load", function(){
	var listBox = document.querySelector(".productList-box");
	var checkAll = listBox.querySelector(".check-all");
	var checks = listBox.querySelectorAll(".check");
	
	checkAll.onclick = function(){
		if(checkAll.checked == true) {
			for(var i=0;i<checks.length;i++)
				checks[i].checked=true;
		} 
		if(checkAll.checked == false){
			for(var i=0;i<checks.length;i++)
				checks[i].checked=false;	
		}
	} 	
});


//PAGER 클릭시 선택 번호 효과
window.addEventListener("load", function(){
	var pagerMenu = document.querySelector(".pager-menu");
	var ul = pagerMenu.querySelector("ul"); 
	var beforeBtn = pagerMenu.querySelector(".before-button");
	var nextBtn = pagerMenu.querySelector(".next-button");
	
	var current = ul.firstElementChild;
	current.style.color = "#29d022";
	current.style.fontSize = "25px";
		
	
	ul.onclick = function() {
		
		
	}; 
	
});