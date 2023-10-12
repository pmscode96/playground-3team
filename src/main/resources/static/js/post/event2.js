document.addEventListener("DOMContentLoaded", function() {

  // 클릭할 요소
  const sortingBox = document.querySelector(".sorting");

  // 펼쳐질 요소
  const menuList = document.querySelector(".dropdown-content");

  // 텍스트 바뀔 요소
  const SortText = document.querySelector(".sorting-btn");

  const DifficultySelector = document.querySelectorAll(".DifficultySelector");

  menuList.style.display = "none";

  sortingBox.addEventListener("click", function(e) {
  
    menuListDisplay = menuList.style.display;

    if(menuListDisplay === "none" || menuListDisplay === "") {
      menuList.style.display = "block";
    } else {
      menuList.style.display = "none";
    }

    DifficultySelector.forEach(event => {
      const ulElement = event.querySelector("ul");
      ulElement.style.display = "none"; // 모든 ul을 초기에 숨김
    })

    e.stopPropagation();

  });

  // 메뉴 리스트 항목(li) 클릭 시 SortText 업데이트
  menuList.querySelectorAll("li").forEach(item => {
    item.addEventListener("click", function() {
      // 기존의 SortText 내용을 유지하면서 텍스트만 변경
      SortText.innerHTML = `${item.textContent}<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 24 24" width="1.875rem" height="1.875rem"><path d="m2 8 1.775-1.77L12 14.45l8.225-8.22L22 8 12 18 2 8Z"></path></svg>`;
    });
  });

  document.addEventListener("click", function() {
    menuList.style.display = "none";
  });

});
