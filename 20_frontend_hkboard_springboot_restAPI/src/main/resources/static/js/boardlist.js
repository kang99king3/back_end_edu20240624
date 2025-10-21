//글목록 조회
	function getBoardList(){
		$.ajax({
			url:'http://localhost:8085/api/board/boardlist',
			method:'get',
			async:false,
			dataType:'json',
			success:function(data){// data는 서버로부터 전달받은 값
				var list=data['list'];//글목록 저장된 객체 받기
// 				alert('길이값:'+list.length);
				
				// $("<table></table>") : 태그생성하는 방법
				var table=$(
						'<h2>글목록</h2>'
						+'<form id="muldel">'
						+'<table border="1" class="table">'
						+'	<col width="50px" />'
						+'	<col width="50px" />'
						+'	<col width="100px" />'
						+'	<col width="300px" />'
						+'	<col width="200px" />'
						+'	<thead>'
						+'	<tr>'
						+'		<th><input  type="checkbox" name="all" onclick="allSel(this.checked)"> </th>'
						+'		<th>seq</th><th>작성자</th><th>제목</th><th>작성일</th>'
						+'	</tr>'
						+'	</thead>'
						+'	<tbody></tbody>'
						+'	<tfoot>'
						+'	<tr>'
						+'		<td colspan="5">'
						+'			<button type="button" onclick="insertBoardForm()">글추가</button>	'
						+'			<input type="button" value="삭제" onclick="mulDel()"/>	'
						+'		</td>'
						+'	</tr>'
						+'	</tfoot>'
						+'</table>'
						+'</form>');	
				
				//list를 구했고, list를 타켓으로 반복문 실행해서 데이터를 table에 추가
				//table 객체가 준비되어 있음
				$.each(list,function(i,dto){ // i는 인덱스 증가, dto는 list의 값저장
					//tr객체 생성
					var tr=$("<tr></tr>")
					       .append($('<td><input type="checkbox" name="chk" value="'+dto.seq+'"/></td>'))
					       .append($('<td></td>').text(i+1)) //차례대로 번호 부여
					       .append($('<td></td>').text(dto.id)) //아이디
					       .append($('<td></td>')
					    		.html($('<a style="cursor:pointer;" onclick="detail('+dto.seq+')"></a>')
					    				.text(dto.title)))    
						   .append($("<td></td>").text(dto.regdate)); //작성일	
					
				    //생성된 tr객체를 tbody에 추가한다.
				    table.find('tbody').append(tr);
				});
				
				
				$("#boardlist").html(table); // <div id="boardlist"><table></table></div>
			
			},
			error:function(){
				alert("통신실패");
			}
		});
	}
