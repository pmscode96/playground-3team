document.addEventListener("DOMContentLoaded", function() {
  
  // .tab-item 요소들을 선택합니다.
  const tabItems = document.querySelectorAll('.tab-item');

  // .ProseMirror 요소를 선택합니다.
  const proseMirror = document.querySelector('.ProseMirror');

  // 각 .tab-item 요소에 클릭 이벤트 리스너를 추가합니다.
  tabItems.forEach(tabItem => {
    tabItem.addEventListener('click', () => {
      // .ProseMirror 요소의 텍스트가 "Preview"이면 display: none을 적용하고,
      // 그 외에는 display: block을 적용합니다.
      if (tabItem.textContent === "Preview") {
        proseMirror.style.display = 'none';
      } else {
        proseMirror.style.display = 'block';
      }

      // 현재 클릭된 .tab-item 요소에만 .active 클래스를 추가하고,
      // 다른 .tab-item 요소들의 .active 클래스를 제거합니다.
      tabItems.forEach(item => item.classList.remove('active'));
      tabItem.classList.add('active');
    });
  });


})