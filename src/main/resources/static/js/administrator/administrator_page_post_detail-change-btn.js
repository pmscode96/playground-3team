document.addEventListener("DOMContentLoaded", function() {
  const replyInput = document.querySelector(".reply-inp");
  const uploadButton = document.querySelector(".upload-btn22");

  replyInput.addEventListener("input", function() {
    if (replyInput.value.trim() !== "") {
      uploadButton.classList.add("chg-btn");
    } else {
      uploadButton.classList.remove("chg-btn");
    }
  });
});
