const BASE_URL = 'http://localhost:8085/api/board';

export async function getBoardList() {
    const res = await fetch(`${BASE_URL}/boardlist`);
    return res.json();
}

export async function getBoardDetail(seq) {
    const res = await fetch(`${BASE_URL}/detail/${seq}`);
    return res.json();
}

export async function insertBoard(data) {
    const res = await fetch(`${BASE_URL}/insert`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    });
    return res.json();
}

export async function updateBoard(data) {
    const res = await fetch(`${BASE_URL}/update`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    });
    return res.json();
}

export async function deleteBoard(seq) {
    const res = await fetch(`${BASE_URL}/muldel`, {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({chk: [seq]})
    });
    return res.json();
}

export async function deleteBoards(seqList) {
    const res = await fetch(`${BASE_URL}/muldel`, {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(seqList)
    });
    return res.json();
}
