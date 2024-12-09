//글추가 폼 이동
	function insertBoardForm(){
		var insertForm=$(
				'<h1>새글 작성하기</h1>'
				+'<form id="insertForm">'
				+'	<table class="table">'
				+'		<tr>'
				+'			<th>작성자(ID)</th>'
				+'			<td><input type="text" name="id" required="required" /></td>'
				+'		</tr>'
				+'		<tr>'
				+'			<th>글제목</th>'
				+'			<td><input type="text" name="title" required="required" /></td>'
				+'		</tr>'
				+'		<tr>'
				+'			<th>글내용</th>'
				+'			<td><textarea rows="10" cols="60" name="content" required="required"></textarea></td>'
				+'		</tr>'
				+'		<tr>'
				+'			<td colspan="2">'
				+'				<input type="button" value="등록" onclick="insertBoard()" />'
				+'				<input type="button" value="글목록"'
				+'						onclick="getBoardList()" />'
				+'			</td>'
				+'		</tr>'
				+'	</table>'
				+'</form>	'	
		);
		
		//body에 글추가폼 보여주기
		$("#boardlist").html(insertForm);
		
	}