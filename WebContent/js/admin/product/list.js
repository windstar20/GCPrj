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


