window.addEventListener("load", function(){
    var info = document.querySelector(".information-box");
    var plusBtn = info.querySelector(".plus-btn");
    var minusBtn = info.querySelector(".minus-btn");
    var count = 1;
    plusBtn.onclick = function(){
        if(count == 10){
            alert("10개를 초과하여 구매할 수 없습니다.")
            return ;
        }
        count++;
        info.querySelector(".input-text").value = count;
    };

    minusBtn.onclick = function(){
        if(count < 1)
            return ;
        
        count--;
        info.querySelector(".input-text").value = count;
    };

});


