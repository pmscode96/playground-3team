document.addEventListener("DOMContentLoaded", function () {
  const wrapSelect = document.querySelector(".wrap_select");
  const linkSelect = document.querySelector(".link_select");

  // wrap_select를 클릭하면 list_select를 보이게 하고, 다른 곳 클릭 시 숨김
  wrapSelect.addEventListener("click", function (event) {
    wrapSelect.classList.toggle("open-ul"); // ul의 표시 여부를 토글
    event.stopPropagation(); // 클릭 이벤트 전파 중지
  });

  document.addEventListener("click", function () {
    // 다른 곳 클릭 시 ul을 숨김
    wrapSelect.classList.remove("open-ul");
  });

  // list_select의 li를 클릭하면 해당 텍스트를 link_select에 설정
  const listItems = document.querySelectorAll(".list_select li");
  listItems.forEach(function (item) {
    item.addEventListener("click", function () {
      const selectedText = item.textContent;
      linkSelect.innerHTML = selectedText + '<span class="ico_cs ico_arr"></span>'; // 텍스트 뒤에 span 태그 추가
    });
    wrapSelect.classList.remove("open-ul"); // 선택 후 ul을 숨김
  });
});
