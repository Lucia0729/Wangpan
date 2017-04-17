var i=0,t;
$(function() {
	showImageByTime();
	$(".btn_li a").bind("click",function(){
		var id=$(this).attr("id");
		$(this).addClass("current").parent().siblings().children().removeClass("current");
		i=parseInt(id)+1;
		$(".content-container-banner").children().eq(i).removeClass("all-index-banner-hidden").addClass("all-index-banner").siblings().removeClass("all-index-banner").addClass("all-index-banner-hidden");	
		var loc="./statics/images/16new/bg"+i+".jpg";
		$("#login-container").animate({"opacity": 1},2000);
		$("#login-container").css("background-image", "url("+loc+")");
		$("#login-container").animate({"opacity": 0.9},500);
	});
	t=setInterval("showImageByTime()", 3000);

	 $(".btn_li a").hover(function(){
	    	clearInterval(t);
	    }, function(){
	    	t = setInterval("showImageByTime()", 3000);
	    });
});

function showImageByTime(){
	if(i==4) i=0;
	$(".btn_ul").children().eq(i).children().addClass("current").parent().siblings().children().removeClass("current");
	$(".content-container-banner").children().eq(i).removeClass("all-index-banner-hidden").addClass("all-index-banner").siblings().removeClass("all-index-banner").addClass("all-index-banner-hidden");	
	++i;
	var loc="./statics/images/16new/bg"+i+".jpg";
	$("#login-container").animate({"opacity": 1},2000);
	$("#login-container").css("background-image", "url("+loc+")");
	$("#login-container").animate({"opacity": 0.9},500);
}