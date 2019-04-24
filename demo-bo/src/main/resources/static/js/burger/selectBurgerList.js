// 데이터 조회
	function selectBurgerList(){
		
		$.ajax({
	        url : "/demo-bo/selectBurger/getList",
	        type: "GET",
	        dataType : "json",
	        contentType:'application/json; charset=utf-8',
		    cache: true,
	        success : function(resData){
	        	console.log(resData);
	        }
	    });
	}
	
	