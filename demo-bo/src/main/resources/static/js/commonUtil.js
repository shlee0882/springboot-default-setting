/**
 * 공통 처리용 기능을 제공한다.
 * @namespace common
 */
var commonUtil = {};

commonUtil.numberWithCommas = function(x) {
	if(x == "" || x == 0 || isNaN(x)){
		return "";
	}else{
		return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
}
