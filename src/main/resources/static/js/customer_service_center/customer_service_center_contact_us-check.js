document.addEventListener("DOMContentLoaded", function () {
  // 문서가 로드된 후 실행되는 함수
  $(document).ready(function() {
    // 체크박스 요소를 클릭했을 때 이벤트 처리
    $("#agree").click(function() {
      // 체크박스의 체크 상태를 확인
      if ($(this).prop("checked")) {
        // 체크된 경우, 'checked' 클래스 추가
        $(".item_check").addClass("checked");
        console.log("추가됨")
      } else {
        // 체크가 해제된 경우, 'checked' 클래스 제거
        $(".item_check").removeClass("checked");
        console.log("제거됨")
      }
    });
  });
});
