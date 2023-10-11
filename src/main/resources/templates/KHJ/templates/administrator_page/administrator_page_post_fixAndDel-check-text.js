document.addEventListener("DOMContentLoaded", function() {

  const contentInputBx = document.querySelector('.content-input-bx');
const textarea = contentInputBx.querySelector('textarea');
const chgBx22 = document.querySelector('.chg-bx22');

// textarea 내용이 변경될 때마다 이벤트를 처리합니다.
contentInputBx.addEventListener('input', function() {
  // textarea 내용의 길이를 가져옵니다.
  const textLength = contentInputBx.value.length;
  
  // chg-bx22 요소에 길이 정보를 업데이트합니다.
  chgBx22.textContent = textLength + ' 자';
});


})