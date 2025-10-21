import { renderBoardList } from './ui/boardListView.js';

document.addEventListener('DOMContentLoaded', () => {
	console.log("동작");
    const container = document.getElementById('boardlist');
    renderBoardList(container);
});
