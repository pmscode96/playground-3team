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


//     검색
document.getElementById("search").addEventListener("click", async () => {
    const keyword = document.getElementById("keyword").value;
    location.href = `/post/free-post?page=1&keyword=${keyword}`;
    const response = await fetch(`/results/free-search?keyword=${keyword}`);
    const json = await response.json();
    console.log("총갯수")
    console.log(json.postsTotalCount)
    if(response.ok) {
        const freePosts = json.freePosts;

        const postsTotalCount = json.postsTotalCount;
        let freePostData = ``;
        freePosts.forEach(freePost => {
            freePostData += `<div class="card card-two card-thr card-four card-five">`
            freePostData += `<form class="goToPostDetail" action="/post/free-post" method="post">`
            freePostData += `<input type="hidden" name="id" value="${freePost.id}" >`
            freePostData += `</form>`
            freePostData += `<a class="card-in card-in-two card-in-thr goToDetail" >`
            freePostData += `<div src="https://mud-kage.kakaocdn.net/dn/iy1cB/btssvfJ45Ga/fW0LC7ROJK1ZyTKeas68d0/c360.jpg" class="ohn ohn-two thumbnail">`
            freePostData += `<!--after -->`
            freePostData += `</div>`
            freePostData += `<div class="card-con card-con-two card-con-three">`
            freePostData += `<strong color="black" class="h-three carti carti-two carti-thr carti-four" aria-hidden="true">${freePost.postTitle}</strong>`
            freePostData += `<span color="gray60" class="h-three carsub carsub-two carsub-thr carsub-four" aria-hidden="true">${freePost.userSchool} - ${freePost.userName}</span>`
            freePostData += `</div>`
            freePostData += `</a>`
            freePostData += `</div>`
        });
        document.getElementById("result").innerHTML = freePostData;
    }
});