document.addEventListener("DOMContentLoaded", function() {
  const deleteButtons = document.querySelectorAll(".btn_delete");

  deleteButtons.forEach((deleteButton) => {
    deleteButton.addEventListener("click", function() {
      const fi1Elements = document.querySelectorAll(".fi1");
      fi1Elements.forEach((fi1Element) => {
        fi1Element.remove();
      });
    });
  });
});
