


function dis(){
	var dd=document.getElementById("dingdana");
	if(dd.style.height=="0px"){
		dd.style.height="120px";
	}else{
		var style2="height:0px;overflow:hidden";
		dd.setAttribute("style",style2);
	}
}
function dis1(){
	var dd=document.getElementById("shangpina");
	if(dd.style.height=="0px"){
		dd.style.height="90px";
	}else{
		var style2="height:0px;overflow:hidden";
		dd.setAttribute("style",style2);
	}
}

/*切换页面*/
function handover(obj){
	var iframeHtml = document.getElementById("iframeHtml");
	iframeHtml.src = obj.title;
//	var text = obj.innerHTML;
//	alert(obj.title);
}