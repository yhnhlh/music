


/**
 * 收藏喜欢歌曲
 * @param songId
 * @returns
 */
function collectFunc(songId){
	var collectElement=$("#"+songId);
	//用于获取使用了tab 页里面歌曲真实id相同的元素
	var collectElement2=$("#second"+songId);
	var data = {        
	        "songId": songId,
	 };
    url = "collectSong.do";
	$.ajax({
        type:"get",
        url:url,
        data:data,
        success:function(data){
            	if(data=="true"){
            		//已经收藏了
					collectElement2.addClass("text-danger");
					collectElement.addClass("text-danger");
            	}else{
            		//已经取消收藏了
					collectElement.removeClass("text-danger");
					collectElement2.removeClass("text-danger");
            	}
        }
    });
}



/**
 * 发表评论
 * @param songId
 * @returns
 */
function reviewFunc(songId){
	console.log("1111");
	//获取评论信息
	review=$("#text").val();
	var data = {        
	        "review": review,
	        "songId": songId,
	 };
    url = "review.do";
    $.getJSON(url,data,function (result) {
		$("#text").val("");
    	console.log(result);
		var str ="<li class='comment_list_one'><div><div class='comment_list_right'><h4><a href='#'>用户ID"+result.userId+"</a></h4>"
		+"<div>"+result.reviewTime+"</div>"
		+"<p> <span>"+result.review+"</span> </p>"
		+"</div></div></li>"
		$('#review_content').prepend(str);
	});
	
}





