document.addEventListener("DOMContentLoaded", function() {

  // item_info 클래스를 가진 모든 요소를 선택합니다.
  const itemInfoElements = document.querySelectorAll('.item_info');

  // 각 item_info 요소에 대한 이벤트 리스너를 추가합니다.
  itemInfoElements.forEach((itemInfo) => {
      itemInfo.addEventListener('click', function() {
          itemInfo.classList.toggle('on');
      });
  });

})