window.addEventListener("load", function(){
    var table = document.querySelector(".list-table");

    var win;

    table.addEventListener("click",function(e){
		if (e.target.classList.contains("detail")){
			
			var userId = e.target.parentElement.parentElement.querySelector(".user-id");
			var id = userId.textContent;
			
			win = open("/admin/user/detail?id="+id,"_blank","width = 800px, height = 700px");
		};     	

//		var trainerId = document.querySelector(".trainer-id");
//	    var id = trainerId.textContent;
//      console.log(id);
//      win = open("/admin/user/trainer/detail?id="+id,"_blank","width = 500px, height = 500px");
        
    });
});

