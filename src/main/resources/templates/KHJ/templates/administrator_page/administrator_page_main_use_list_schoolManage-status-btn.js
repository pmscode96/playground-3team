document.addEventListener("DOMContentLoaded", function() {

// more-btn 클래스 요소를 클릭했을 때 이벤트 처리
document.querySelector(".more-btn").addEventListener("click", function () {
  // more-select-bx-status 클래스 요소의 스타일 display 값을 변경하여 보이게 하거나 숨김
  var statusElement = document.querySelector(".more-select-bx-status");
  if (statusElement.style.display === "block") {
    statusElement.style.display = "none";
  } else {
    statusElement.style.display = "block";
  }
});

// status-select-bx-1 클래스 요소를 클릭했을 때 이벤트 처리
document.querySelector(".status-select-bx-1").addEventListener("click", function () {
  // more-btn 클래스 하위에 있는 모든 <p> 요소를 제거
  var moreBtn = document.querySelector(".more-btn");
  var existingParagraphs = moreBtn.querySelectorAll("p");
  existingParagraphs.forEach(function (p) {
    moreBtn.removeChild(p);
  });

  // more-btn 클래스 하위에 있는 모든 <img> 요소를 제거
  var existingImages = moreBtn.querySelectorAll("img");
  existingImages.forEach(function (img) {
    moreBtn.removeChild(img);
  });

  // more-btn 클래스 하위에 <p> 요소 추가
  var pElement = document.createElement("p");
  pElement.className = "poa w-[16px] h-[16px] content_primary";
  pElement.textContent = "가입중";
  moreBtn.appendChild(pElement);

  // more-select-bx-status 클래스를 숨김
  var statusElement = document.querySelector(".more-select-bx-status");
  statusElement.style.display = "none";
});

// status-select-bx-2 클래스 요소를 클릭했을 때 이벤트 처리
document.querySelector(".status-select-bx-2").addEventListener("click", function () {
  // more-btn 클래스 하위에 있는 모든 <p> 요소를 제거
  var moreBtn = document.querySelector(".more-btn");
  var existingParagraphs = moreBtn.querySelectorAll("p");
  existingParagraphs.forEach(function (p) {
    moreBtn.removeChild(p);
  });

  // more-btn 클래스 하위에 있는 모든 <img> 요소를 제거
  var existingImages = moreBtn.querySelectorAll("img");
  existingImages.forEach(function (img) {
    moreBtn.removeChild(img);
  });

  // more-btn 클래스 하위에 <p> 요소 추가
  var pElement = document.createElement("p");
  pElement.className = "poa poa2 w-[16px] h-[16px] content_primary";
  pElement.textContent = "탈퇴";
  moreBtn.appendChild(pElement);

  // more-select-bx-status 클래스를 숨김
  var statusElement = document.querySelector(".more-select-bx-status");
  statusElement.style.display = "none";
});



})