// gym
window.addEventListener("load", function () {
	var listBox = document.querySelector(".gym-list");
	var checkAll = listBox.querySelector(".check-all");
	var checks = listBox.querySelectorAll(".check")
	// 위에껄 클릭하면 밑에 있는게 클릭 되야한다
	// 어떻게 하면 위에껄 클릭해야 밑에께 클릭될까
	// 어떻게 하면 좋을까 하나씩 해보자

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