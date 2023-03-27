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