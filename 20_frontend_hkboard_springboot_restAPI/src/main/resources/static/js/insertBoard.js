/**
 * 
 */
//글추가하기
	function insertBoard(){
		$.ajax({
			url:'http://localhost:8085/api/board/insert',
			method:'post',
			async:false,
			data:$("#insertForm").serialize(), //form안에 입력요소들을 json형식으로 구해준다.
			     // {id:"hk",tilte:"제목"..}
		    dataType:'json',
		    success:function(data){
		    	if(data.count==0){
		    		alert("글추가실패");
		    	}else{
		    		alert("글추가함");
		    		getBoardList();
		    	}
		    }
		});
	}