document.addEventListener("DOMContentLoaded", function() {

  const DifficultySelector = document.querySelectorAll(".DifficultySelector");

  // 펼쳐질 요소
  const menuList = document.querySelector(".dropdown-content")

  DifficultySelector.forEach(event => {
    const ulElement = event.querySelector("ul");
    ulElement.style.display = "none"; // 모든 ul을 초기에 숨김

    event.addEventListener("click", function(e) {
      // 클릭된 요소의 하위 ul 엘리먼트 선택
      const ulElement = this.querySelector("ul");

      menuList.style.display = "none";

      // 모든 ul을 숨김
      DifficultySelector.forEach(item => {
        const otherUlElement = item.querySelector("ul");
        if (ulElement === otherUlElement) {
          ulElement.style.display = "flex"; // 클릭한 ul만 보임
        } else {
          otherUlElement.style.display = "none";
        }
      });

      // 클릭 이벤트 전파 방지
      e.stopPropagation();
    });
  });

  // 문서 어느 곳을 클릭해도 모든 ul 숨김
  document.addEventListener("click", function() {
    DifficultySelector.forEach(item => {
      const ulElement = item.querySelector("ul");
      ulElement.style.display = "none";
    });
  });
  
});
