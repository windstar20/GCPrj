// gym
window.addEventListener("load", function () {
	var listBox = document.querySelector(".gymList-box");
	var checkAll = listBox.querySelector(".check-all");
	var checks = listBox.querySelectorAll(".check")
	
	checkAll.onclick = function(){
		//console.log("test");
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