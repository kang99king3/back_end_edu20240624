import { getBoardDetail, deleteBoard } from '../api/boardApi.js';
import { renderBoardList } from './boardListView.js';
import { renderBoardForm } from './boardFormView.js';

export async function renderBoardDetail(container, seq) {
    const data = await getBoardDetail(seq);
    const dto = data.dto;

    container.innerHTML = `
        <h1>상세보기</h1>
        <table class="table">
            <tr><th>작성자(ID)</th><td>${dto.id}</td></tr>
            <tr><th>글제목</th><td>${dto.title}</td></tr>
            <tr><th>글내용</th><td><textarea rows="10" cols="60" readonly>${dto.content}</textarea></td></tr>
            <tr>
                <td colspan="2">
                    <button id="updateBtn">수정</button>
                    <button id="deleteBtn">삭제</button>
                    <button id="listBtn">글목록</button>
                </td>
            </tr>
        </table>
    `;

    container.querySelector('#updateBtn').addEventListener('click', () => renderBoardForm(container, dto));
    container.querySelector('#deleteBtn').addEventListener('click', async () => {
        if (confirm("삭제하시겠습니까?")) {
            await deleteBoard(seq);
            renderBoardList(container);
        }
    });
    container.querySelector('#listBtn').addEventListener('click', () => renderBoardList(container));
}
