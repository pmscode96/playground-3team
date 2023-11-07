let ids = document.querySelectorAll('.goToPostDetail');
let buttons = document.querySelectorAll('.goToDetail')

// 상세보기 페이지 이동
for (let i = 0; i < buttons.length; i++) {
    let button = buttons.item(i);
    let id = ids.item(i);
    button.addEventListener("click", e =>{
        id.submit();
    })
}

// 페이지 번호 클릭시 해당 페이지로 이동
$("a.change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("#keyword").val();
    location.href = `/post/free-post?page=${page}&keyword=${keyword}`;
});

// 게시물 리스트
function loadPage(datas){
    let postData = ``;
    datas.forEach(data => {
        postData += `<div class="card card-two card-thr card-four card-five">`
        postData += `<form class="goToPostDetail" action="/post/free-post" method="post">`
        postData += `<input type="hidden" name="id" value="${data.id}" >`
        postData += `</form>`
        postData += `<a class="card-in card-in-two card-in-thr goToDetail" >`
        postData += `<div class="ohn ohn-two thumbnail">`
        postData += `<!--after -->`
        postData += `</div>`
        postData += `<div class="card-con card-con-two card-con-three">`
        postData += `<strong color="black" class="h-three carti carti-two carti-thr carti-four">${data.postTitle}</strong>`
        postData += `<span color="gray60" class="h-three carsub carsub-two carsub-thr carsub-four">${data.userSchool} - ${data.userName}</span>`
        postData += `<span style="color: rgb(128,128,128); font-size: 13px; text-align: right" class="h-three carsub carsub-two carsub-thr carsub-four">좋아요 ${data.likeCount !== null ? data.likeCount : 0}개</span>`;
        postData += `</div>`
        postData += `</a>`
        postData += `</div>`
    });
    document.getElementById("result").innerHTML = postData;
}

// 페이지 버튼
function loadPageButton(data){
    let paging = ``;

    // 이전 페이지 버튼
    if (data.prev) {
        paging += `<a href="?page=${data.startPage - 1}" class="btn_paging btn_prev change-page"><span class="ico_cs ico_arr">이전 페이지로 이동</span></a>`;
    }
    // 페이지 번호 링크
    for (let i = data.startPage; i <= data.endPage; i++) {
        if (i === data.page) {
            paging += `<em class="link_page">${i}</em>`;
        } else {
            paging += `<a href="?page=${i}" class="link_page">${i}</a>`;
        }
    }

    // 다음 페이지 버튼
    if (data.next) {
        paging += `<a href="?page=${data.endPage + 1}" class="btn_paging btn_next change-page"><span class="ico_cs ico_arr">다음 페이지로 이동</span></a>`;
    }

    document.getElementById("page_con").innerHTML = paging;

}


//     검색
document.getElementById("search").addEventListener("click", async () => {
    const keyword = document.getElementById("keyword").value;
    const response = await fetch(`/results/free-search?keyword=${keyword}`);
    const json = await response.json();
    console.log("총갯수")
    console.log(json.postsTotalCount)
    if(response.ok) {
        console.log(json)
        const freePosts = json.freePosts;
        loadPage(freePosts)

        const pagination = json.pagination;
        loadPageButton(pagination);
    }
});