import { getBoardList } from '../api/boardApi.js';
import { renderBoardDetail } from './boardDetailView.js';
import { renderBoardForm } from './boardFormView.js';
import { deleteBoards } from '../api/boardApi.js';

export async function renderBoardList(container) {
    const data = await getBoardList();
    const list = data.list;

    container.innerHTML = `
        <h2>글목록</h2>
        <form id="muldel">
        <table border="1" class="table">
            <col width="50px">
            <col width="50px">
            <col width="100px">
            <col width="300px">
            <col width="200px">
            <thead>
                <tr>
                    <th><input type="checkbox" id="selectAll"></th>
                    <th>seq</th><th>작성자</th><th>제목</th><th>작성일</th>
                </tr>
            </thead>
            <tbody>
                ${list.map((dto, i) => `
                    <tr>
                        <td><input type="checkbox" name="chk" value="${dto.seq}"></td>
                        <td>${i + 1}</td>
                        <td>${dto.id}</td>
                        <td><a href="#" class="detail-link" data-seq="${dto.seq}">${dto.title}</a></td>
                        <td>${dto.regdate}</td>
                    </tr>
                `).join('')}
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">
                        <button type="button" id="insertBtn">글추가</button>
                        <button type="button" id="deleteBtn">삭제</button>
                    </td>
                </tr>
            </tfoot>
        </table>
        </form>
    `;

    // 상세보기 이벤트
    container.querySelectorAll('.detail-link').forEach(a => {
        a.addEventListener('click', e => {
            e.preventDefault();
            renderBoardDetail(container, a.dataset.seq);
        });
    });

    // 글추가 버튼
    container.querySelector('#insertBtn').addEventListener('click', () => {
        renderBoardForm(container);
    });

    // 삭제 버튼
    container.querySelector('#deleteBtn').addEventListener('click', async () => {
        const checked = Array.from(container.querySelectorAll('input[name="chk"]:checked'))
                             .map(c => Number(c.value));
        if (checked.length && confirm("삭제하시겠습니까?")) {
            await deleteBoards(checked);
            renderBoardList(container);
        }
    });

    // 전체선택
    container.querySelector('#selectAll').addEventListener('change', e => {
        container.querySelectorAll('input[name="chk"]').forEach(c => c.checked = e.target.checked);
    });
}
