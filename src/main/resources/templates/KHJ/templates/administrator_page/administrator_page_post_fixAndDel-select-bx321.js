document.addEventListener("DOMContentLoaded", function() {
  // 버튼 요소들을 가져옵니다.
  const selectBbx1 = document.getElementById("select-bbx-1");
  const selectBbx2 = document.getElementById("select-bbx-2");

  // 드롭다운 메뉴가 열려있는지를 나타내는 플래그 변수
  let isDropdownMenu1Open = false;
  let isDropdownMenu2Open = false;

  // 첫 번째 버튼 클릭 시 드롭다운 메뉴 토글
  selectBbx1.addEventListener("click", function() {
    const dropdownMenu1 = selectBbx1.querySelector(".dropdown-menu");
    isDropdownMenu1Open = !isDropdownMenu1Open;
    dropdownMenu1.style.display = isDropdownMenu1Open ? "block" : "none";
  });

  // 두 번째 버튼 클릭 시 드롭다운 메뉴 토글
  selectBbx2.addEventListener("click", function() {
    const dropdownMenu2 = selectBbx2.querySelector(".dropdown-menu");
    isDropdownMenu2Open = !isDropdownMenu2Open;
    dropdownMenu2.style.display = isDropdownMenu2Open ? "block" : "none";
  });

  // 첫 번째 드롭다운 항목 클릭 시 버튼 레이블 설정 및 드롭다운 메뉴 닫기
  const dropdownItems1 = selectBbx1.querySelectorAll(".dropdown-item");
  dropdownItems1.forEach(function(item) {
    item.addEventListener("click", function() {
      const selectedText = item.textContent;
      const label1 = selectBbx1.querySelector(".tox-tbtn__select-label");
      label1.textContent = selectedText;
      isDropdownMenu1Open = false;
      const dropdownMenu1 = selectBbx1.querySelector(".dropdown-menu");
      isDropdownMenu1Open = !isDropdownMenu1Open;
      dropdownMenu1.style.display = isDropdownMenu1Open ? "block" : "none";
    });
  });

  // 두 번째 드롭다운 항목 클릭 시 버튼 레이블 설정 및 드롭다운 메뉴 닫기
  const dropdownItems2 = selectBbx2.querySelectorAll(".dropdown-item");
  dropdownItems2.forEach(function(item) {
    item.addEventListener("click", function() {
      const selectedText = item.textContent;
      const label2 = selectBbx2.querySelector(".tox-tbtn__select-label");
      label2.textContent = selectedText;
      isDropdownMenu2Open = false;
      const dropdownMenu2 = selectBbx2.querySelector(".dropdown-menu");
      isDropdownMenu2Open = !isDropdownMenu2Open;
      dropdownMenu2.style.display = isDropdownMenu2Open ? "block" : "none";
    });
  });
});
