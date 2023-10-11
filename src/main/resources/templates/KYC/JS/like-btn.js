document.addEventListener("DOMContentLoaded", function() {
  const likeButtons = document.querySelectorAll('.like-btn');

likeButtons.forEach(likeButton => {
  const likeCountSpan = likeButton.querySelector('span');

  likeButton.addEventListener('click', toggleSelected);

  function toggleSelected() {
    likeButton.classList.toggle('selected1');

    // selected 클래스가 추가되면 +1, 제거되면 -1
    if (likeButton.classList.contains('selected1')) {
      // +1
      const currentCount = parseInt(likeCountSpan.textContent, 10);
      likeCountSpan.textContent = (currentCount + 1).toString();
    } else {
      // -1
      const currentCount = parseInt(likeCountSpan.textContent, 10);
      likeCountSpan.textContent = (currentCount - 1).toString();
    }
    console.log("ddd");
  }
});


})