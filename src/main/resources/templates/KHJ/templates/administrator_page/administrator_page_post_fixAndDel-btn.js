document.addEventListener("DOMContentLoaded", function () {
  const titleInput = document.querySelector(".title-input");
  const contentTextarea = document.querySelector(".content-input-bx");
  const sBtn = document.querySelector(".s-btn");

  // 입력 필드에서 입력 내용이 변경될 때마다 실행
  titleInput.addEventListener("input", toggleSBtnClass);
  contentTextarea.addEventListener("input", toggleSBtnClass);

  function toggleSBtnClass() {

    if (titleInput.value.trim() !== "" && contentTextarea.value.trim() !== "") {
      sBtn.classList.add("select-bx22");
    } else {
      sBtn.classList.remove("select-bx22");
    }
  }

});
