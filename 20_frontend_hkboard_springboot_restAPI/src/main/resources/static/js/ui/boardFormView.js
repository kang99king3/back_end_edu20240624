import { insertBoard, updateBoard } from '../api/boardApi.js';
import { renderBoardList } from './boardListView.js';
import { renderBoardDetail } from './boardDetailView.js';

export function renderBoardForm(container, dto=null) {
    const isUpdate = !!dto;//dto가 있으면 true, 없으면 false로 만들어주기 위한 문법
    container.innerHTML = `
        <h1>${isUpdate ? '수정하기' : '새글 작성하기'}</h1>
        <form id="boardForm">
            ${isUpdate ? `<input type="hidden" name="seq" value="${dto.seq}">` : ''}
            <table class="table">
                <tr><th>작성자(ID)</th><td>${isUpdate ? dto.id : '<input type="text" name="id" required>'}</td></tr>
                <tr><th>글제목</th><td><input type="text" name="title" value="${dto ? dto.title : ''}" required></td></tr>
                <tr><th>글내용</th><td><textarea name="content" rows="10" cols="60" required>${dto ? dto.content : ''}</textarea></td></tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">${isUpdate ? '수정완료' : '등록'}</button>
                        <button type="button" id="listBtn">글목록</button>
                    </td>
                </tr>
            </table>
        </form>
    `;

	//form요소에서 submit이벤트가 발생하면 이벤트 처리하기
    const form = container.querySelector('#boardForm');
    form.addEventListener('submit', async e => {
        e.preventDefault();//form요소의  submit 기본기능을 막는다.
		// form 안의 입력값들을 객체 형태로 가져오기
	    // FormData -> [ [key1, value1], [key2, value2], ... ] 형태
	    // Object.fromEntries로 {key1: value1, key2: value2} 객체로 변환
        const formData = Object.fromEntries(new FormData(form));
        if (isUpdate) {
            await updateBoard(formData);
            renderBoardDetail(container, formData.seq);
        } else {
            await insertBoard(formData);
            renderBoardList(container);
        }
    });

    container.querySelector('#listBtn').addEventListener('click', () => renderBoardList(container));
}
