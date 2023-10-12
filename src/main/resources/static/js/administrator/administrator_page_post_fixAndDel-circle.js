document.addEventListener("DOMContentLoaded", function () {
  const selectBx2 = document.querySelector('.select-bx2');

  if (selectBx2) {
    const liElements = selectBx2.querySelectorAll('li');

    liElements.forEach((liElement) => {
      liElement.addEventListener('click', function () {
        // 선택한 li의 하위 요소 c00 클래스에 border_accent_active 클래스 추가, border_active 클래스 제거
        const c00Element = liElement.querySelector('.c00');
        if (c00Element) {
          c00Element.classList.add('border_accent_active');
          c00Element.classList.remove('border_active');
        }

        // 선택한 li 하위 요소 svg 요소에 content_accent_active 클래스 추가, hidden 클래스 제거
        const svgElement = liElement.querySelector('svg');
        if (svgElement) {
          svgElement.classList.add('content_accent_active');
          svgElement.classList.remove('hidden');
        }

        // 나머지 li 요소들에 대한 처리
        liElements.forEach((otherLiElement) => {
          if (otherLiElement !== liElement) {
            // c00 클래스에 border_active 클래스 추가, border_accent_active 클래스 제거
            const otherC00Element = otherLiElement.querySelector('.c00');
            if (otherC00Element) {
              otherC00Element.classList.add('border_active');
              otherC00Element.classList.remove('border_accent_active');
            }

            // svg 요소에 hidden 클래스 추가, content_accent_active 클래스 제거
            const otherSvgElement = otherLiElement.querySelector('svg');
            if (otherSvgElement) {
              otherSvgElement.classList.add('hidden');
              otherSvgElement.classList.remove('content_accent_active');
            }
          }
        });
      });
    });
  }
});
