//对于给一组数字添加千分符
function addCommas(nStr) {
	if(nStr!=''&&!isNaN(nStr)){    
        re=/(\d{1,3})(?=(\d{3})+(?:$|\.))/g;    
        return nStr.replace(re,"$1,");    
    }  else{
    	return nStr;
    }
}

function convertToMoney(number){
	return "￥"+number;
}