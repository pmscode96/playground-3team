document.addEventListener("DOMContentLoaded", function() {

  // 첫번째로 이동버튼
  const firstInMove = document.querySelector(".start");

  // 마지막페이지로 이동 버튼
  const lastInMove = document.querySelector(".last");

  // 왼쪽으로 이동 버튼
  const prevBtn = document.querySelector(".prev");

  // 오른쪽으로 이동 버튼
  const nextBtn = document.querySelector(".next");

  // 페이지 현황 박스
  const pageNavigation = document.querySelector(".page-navigation");

  // 첫번째로 페이지 이동
  firstInMove.addEventListener("click", function() {
    const buttons = pageNavigation.querySelectorAll("button");
    buttons.forEach((button, index) => {
      if (index === 0) {
        button.classList.add("select");
        button.classList.remove("unselect");
      } else {
        button.classList.add("unselect");
        button.classList.remove("select"); // 다른 버튼들의 select 클래스 제거
      }
    });
  });

  // 마지막으로 페이지 이동
  lastInMove.addEventListener("click", function() {
    const buttons = pageNavigation.querySelectorAll("button");
    const lastIndex = buttons.length - 1;

    buttons.forEach((button, index) => {
      if (index === lastIndex) {
        button.classList.add("select");
        button.classList.remove("unselect");
      } else {
        button.classList.add("unselect");
        button.classList.remove("select"); // 다른 버튼들의 select 클래스 제거
      }
    });
  });

  // 왼쪽으로 이동하는 버튼
  prevBtn.addEventListener("click", function() {
    const buttons = pageNavigation.querySelectorAll("button");
    const currentSelectedIndex = Array.from(buttons).findIndex(button => button.classList.contains("select"));
  
    // 현재 선택된 버튼의 이전 버튼 인덱스 계산
    const prevIndex = currentSelectedIndex - 1;
  
    if (prevIndex >= 0) {
      buttons[currentSelectedIndex].classList.remove("select"); // 현재 선택된 버튼에서 select 클래스 제거
      buttons[currentSelectedIndex].classList.add("unselect"); // 현재 선택된 버튼에서 select 클래스 제거
      buttons[prevIndex].classList.add("select"); // 이전 버튼에 select 클래스 추가
      buttons[prevIndex].classList.remove("unselect"); // 이전 버튼에 select 클래스 추가
    }

  });

  // 오른쪽으로 이동하는 버튼
  nextBtn.addEventListener("click", function() {
    const buttons = pageNavigation.querySelectorAll("button");
    const lastIndex = buttons.length - 1;
    const currentSelectedIndex = Array.from(buttons).findIndex(button => button.classList.contains("select"));
  
    // 현재 선택된 버튼의 다음 버튼 인덱스 계산
    const nextIndex = currentSelectedIndex + 1;
  
    if (nextIndex <= lastIndex) {
      buttons[currentSelectedIndex].classList.remove("select"); // 현재 선택된 버튼에서 select 클래스 제거
      buttons[currentSelectedIndex].classList.add("unselect"); // 현재 선택된 버튼에서 select 클래스 제거
      buttons[nextIndex].classList.add("select"); // 다음 버튼에 select 클래스 추가
      buttons[nextIndex].classList.remove("unselect"); // 다음 버튼에 select 클래스 추가
    }
  });

  // 페이지 클릭
  // 각 버튼에 클릭 이벤트 리스너 추가
  pageNavigation.querySelectorAll("button").forEach(button => {
    button.addEventListener("click", function() {
      // 현재 클릭한 버튼에 select 클래스 추가
      this.classList.add("select");
      this.classList.remove("unselect")
      
      // 나머지 버튼에서 select 클래스 제거
      pageNavigation.querySelectorAll("button").forEach(otherButton => {
        if (otherButton !== this) {
          otherButton.classList.remove("select");
          otherButton.classList.add("unselect");
        }
      });
    });
  });

  
  

})