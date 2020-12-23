$(document).ready(function(){
    
    //페이드
    $(".slide_wrap").find(".slideimg:gt(0)").fadeOut();

        setInterval(function(){
            $(".slide_wrap").find(".slideimg:first").stop().fadeOut()
            .next().fadeIn().end().appendTo(".slide_wrap")}, 3500)

});



