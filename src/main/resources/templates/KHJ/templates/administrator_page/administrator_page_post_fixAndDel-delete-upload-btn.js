document.addEventListener("DOMContentLoaded", function () {
  const deleteBtns = document.querySelectorAll(".delete-upload-btn");

  deleteBtns.forEach((deleteBtn) => {
    deleteBtn.addEventListener("click", function () {
      // 클릭된 delete 버튼의 부모 요소를 선택합니다.
      const parentElement = deleteBtn.parentElement;

      // 부모 요소를 삭제합니다.
      parentElement.remove();
    });
  });
});
