// 댓글 단 시간
$(document).ready(function() {
    $('.replyTime').each(function() {
        var newText = $(this).text().replace(/T/g, " ");
        $(this).text(newText);
    });
});

let replyForm = document.getElementById("replyCreate");
let submitButton = document.getElementById("textareaSubmitButton");

// 댓글 작성
submitButton.addEventListener("click", e=>{
    replyForm.submit();
})

//     댓글 수정
let replyChangeButtons = document.querySelectorAll(".replyChange")
let replySubmitButtons = document.querySelectorAll(".replySubmit")
let replyCancelButtons = document.querySelectorAll(".replyCancel")
let replyDeleteButtons = document.querySelectorAll(".replyDelete")
let replyContents = document.querySelectorAll(".replyContent")
let replyInputs = document.querySelectorAll(".replyInput")
let likeButtons = document.querySelectorAll(".likeButton")
let likeCancelButtons = document.querySelectorAll(".likeCancelButton")
let userIdInputs = document.querySelectorAll(".userIdInput")
let replyIdInputs = document.querySelectorAll(".replyIdInput")
let likeCounts = document.querySelectorAll(".likeCount")

function setUpReplyChangeButton(replyChangeButton, replyDeleteButton, replyContent, replySubmitButton, replyCancelButton, replyInput) {
    replyChangeButton.addEventListener("click", e =>{
        replyChangeButton.style.display = 'none';
        replyDeleteButton.style.display = 'none';
        replyContent.style.display = 'none';
        replySubmitButton.style.display = 'block';
        replyCancelButton.style.display = 'block';
        replyInput.type = 'text';
    });
}

function setUpReplyCancelButton(replyChangeButton, replyDeleteButton, replyContent, replySubmitButton, replyCancelButton, replyInput) {
    replyCancelButton.addEventListener("click", e =>{
        replyChangeButton.style.display = 'block';
        replyDeleteButton.style.display = 'block';
        replyContent.style.display = 'block';
        replySubmitButton.style.display = 'none';
        replyCancelButton.style.display = 'none';
        replyInput.type = 'hidden';
    });
}

function setUpReplySubmitButton(replySubmitButton, replyInput) {
    replySubmitButton.addEventListener("click", e =>{
        replyInput.closest('form').submit();
    });
}

function setUpLikeButton(likeButton, likeCancelButton, likeCount) {
    likeButton.addEventListener("click", e =>{
        likeCancelButton.style.display = "block";
        likeButton.style.display = "none";
    });
}

function setUpLikeCancelButton(likeButton, likeCancelButton, likeCount) {
    likeCancelButton.addEventListener("click", e =>{
        likeButton.style.display = "block";
        likeCancelButton.style.display = "none";
    });
}

function setUpPostLikeButton(postLikeButton, postLikeCancelButton) {
    postLikeButton.addEventListener("click", e =>{
        postLikeCancelButton.style.display = "block";
        postLikeButton.style.display = "none";
    });
}

function setUpPostLikeCancelButton(postLikeButton, postLikeCancelButton) {
    postLikeCancelButton.addEventListener("click", e =>{
        postLikeButton.style.display = "block";
        postLikeCancelButton.style.display = "none";
    });
}

for (let i = 0; i < replyChangeButtons.length; i++) {
    let replyChangeButton = replyChangeButtons.item(i);
    let replySubmitButton = replySubmitButtons.item(i);
    let replyCancelButton = replyCancelButtons.item(i);
    let replyDeleteButton = replyDeleteButtons.item(i);
    let replyContent = replyContents.item(i);
    let replyInput = replyInputs.item(i);
    let likeButton = likeButtons.item(i);
    let likeCancelButton = likeCancelButtons.item(i);
    let userId = userIdInputs.item(i).value;
    let replyId = replyIdInputs.item(i).value;
    let likeCount =likeCounts.item(i);


    console.log(userId)
    console.log(replyId)

    setUpReplyChangeButton(replyChangeButton, replyDeleteButton, replyContent, replySubmitButton, replyCancelButton, replyInput);
    setUpReplyCancelButton(replyChangeButton, replyDeleteButton, replyContent, replySubmitButton, replyCancelButton, replyInput);
    setUpReplySubmitButton(replySubmitButton, replyInput);
    setUpLikeButton(likeButton, likeCancelButton);
    setUpLikeCancelButton(likeButton, likeCancelButton);
    like(likeButton, userId, replyId, likeCount)
    like(likeCancelButton, userId, replyId, likeCount)

}

let postLikeButton = document.querySelector(".postLikeButton");
let postLikeCancelButton = document.querySelector(".postLikeCancelButton");
let postLikeCount = document.querySelector(".postLikeCount");
let postId = document.querySelector(".postIdInput").value;
let postUserId = document.querySelector(".postUserIdInput").value;

postLike(postLikeButton, postId, postUserId, postLikeCount)
postLike(postLikeCancelButton, postId, postUserId, postLikeCount)
setUpPostLikeCancelButton(postLikeButton, postLikeCancelButton)
setUpPostLikeButton(postLikeButton, postLikeCancelButton)

// 댓글 좋아요 버튼
async function like(button, userId, replyId, likeCount) {
    button.addEventListener("click", async e =>{

        const response = await fetch(`/reply/free-post-reply-like?userId=${userId}&replyId=${replyId}`);

        const reply = await response.json();
        if (response.ok) {
            if(reply.likeCount > 0){
                likeCount.innerText = reply.likeCount + "개"
            }else{
                likeCount.innerText = "0개"
            }
        } else {
            console.error('Failed to like the reply');
        }
    })
}

// 게시글 좋아요 버튼
  function postLike(button,postId, userId, postLikeCount) {

    button.addEventListener("click", async e =>{

        const response = await fetch(`/post/free-post-like?userId=${userId}&postId=${postId}`);

        const post = await response.json();
        if (response.ok) {
            console.log(post)
            if(post.likeCount > 0){
                postLikeCount.innerText = post.likeCount + "개"
                button.unbind("click");
            }else{
                postLikeCount.innerText = "0개"
                button.unbind("click");
            }
        } else {
            console.error('Failed to like the reply');
        }
    })

}