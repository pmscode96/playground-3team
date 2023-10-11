document.addEventListener("DOMContentLoaded", function() {
  
  // content_primary 클래스를 가진 요소들을 선택합니다.
  const contentPrimaryElements = document.querySelectorAll('.content_primary');

  // 각 요소에 대한 클릭 이벤트 리스너를 추가합니다.
  contentPrimaryElements.forEach((element) => {
      element.addEventListener('click', function() {
          // 클릭된 요소에서 SVG 요소를 찾아냅니다.
          const svgElement = element.querySelector('svg');

          // SVG 요소의 첫 번째 path와 두 번째 path의 fill 속성을 토글합니다.
          const paths = svgElement.querySelectorAll('path');
          paths.forEach((path) => {
              if (path.getAttribute('fill') === '#B9B9BB') {
                  path.setAttribute('fill', '#333334');
              } else {
                  path.setAttribute('fill', '#B9B9BB');
              }
          });
      });
  });

})