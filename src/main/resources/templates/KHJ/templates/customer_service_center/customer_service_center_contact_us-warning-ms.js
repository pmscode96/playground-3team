document.addEventListener("DOMContentLoaded", function () {
  const emailField = document.querySelector(".email-bx");
  
  const phoneNumberField = document.querySelector(".phone-number-bx");

  const inquireField = document.querySelector(".inquire-bx");

  const contentField = document.querySelector(".content-bx");

    emailField.addEventListener("blur", function () {
      if (emailField.value === "") {
        emailField.setAttribute("placeholder", "이메일을 입력하세요!");
        emailField.classList.add("chg-plchd");
      }
    });

    phoneNumberField.addEventListener("blur", function () {
      if (phoneNumberField.value === "") {
        phoneNumberField.setAttribute("placeholder", "전화번호를 입력하세요!");
        phoneNumberField.classList.add("chg-plchd");
      }
    });

    inquireField.addEventListener("blur", function () {
      if (inquireField.value === "") {
        inquireField.setAttribute("placeholder", "제목을 입력하세요!");
        inquireField.classList.add("chg-plchd");
      }
    });

    contentField.addEventListener("blur", function () {
      if (contentField.value === "") {
        contentField.setAttribute("placeholder", "내용을 입력하세요!");
        contentField.classList.add("chg-plchd");
      }
    });

});
