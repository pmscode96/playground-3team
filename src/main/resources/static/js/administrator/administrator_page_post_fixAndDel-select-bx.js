document.addEventListener("DOMContentLoaded", function () {
  // 모든 surface_primary 요소를 선택합니다.
  const surfacePrimaryElements = document.querySelector('.sl1 input');
  const selectBx = document.querySelector('.select-bx');
  const sss1 = document.querySelector(".sss1");
  const sss2 = document.querySelector(".sss2");

  // 포커스가 발생할 때
  surfacePrimaryElements.addEventListener('focus', function () {
      // 해당 요소 내부의 select-bx 클래스를 가진 요소를 보이도록 변경합니다.
      if (selectBx) {
        selectBx.classList.add("db2");
      }
      // console.log("rrr");
  });

  // 교사 클릭할 때
  sss1.addEventListener('click', function () {
    if (selectBx) {
      selectBx.classList.remove("db2");
      // sss1의 하위 input 요소의 placeholder 값을 surfacePrimaryElements의 value 값으로 설정합니다.
      const inputElement = sss1.querySelector('input');
      if (inputElement) {
        surfacePrimaryElements.value = inputElement.placeholder;
        // console.log("dkdk");
      }
    }
  });

  // 학생 클릭할 때
  sss2.addEventListener('click', function () {
    if (selectBx) {
      selectBx.classList.remove("db2");
      // sss2의 하위 input 요소의 placeholder 값을 surfacePrimaryElements의 value 값으로 설정합니다.
      const inputElement = sss2.querySelector('input');
      if (inputElement) {
        surfacePrimaryElements.value = inputElement.placeholder;
        // console.log("dkdk2");
      }
    }
  });

  // surfacePrimaryElements의 포커스가 해제될 때
  surfacePrimaryElements.addEventListener('blur', function (e) {
      // 해당 요소 내부의 select-bx 클래스를 가진 요소를 보이도록 변경합니다.
      if (selectBx) {
        setTimeout(() => {
          selectBx.classList.remove("db2");
        }, 100);
      }
  });
});
