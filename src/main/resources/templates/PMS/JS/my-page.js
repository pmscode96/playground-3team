let title = document.querySelectorAll(".tit_info");
let content = document.querySelectorAll(".item_info");
let deleteButtons = document.querySelector(".deleteBtn");
let cancelButtons = document.querySelector(".cancelBtn");
let editButtons = document.querySelector(".editBtn");
let contentAreas = document.querySelector(".content_area");
let editAreas = document.querySelector(".edit_area");


for (let i = 0; i < title.length; i++) {

    let item = title.item(i);
    let contents = content.item(i);




    item.addEventListener("click", e =>{
        if(contents.classList.contains('on')){
            contents.classList.remove('on');

        }else{
            contents.classList.add('on');

            // contents.siblings().classList.remove('on');
        }
    })
}

editButtons.addEventListener("click",e=>{
    deleteButtons.classList.add("hide_btn");
    cancelButtons.classList.remove("hide_btn");
    contentAreas.classList.add("hide");
    editAreas.classList.remove("hide");
})

cancelButtons.addEventListener("click" , e =>{
    deleteButtons.classList.remove("hide_btn");
    cancelButtons.classList.add("hide_btn");
    contentAreas.classList.remove("hide");
    editAreas.classList.add("hide");
})

// for(let i = 0; i < title.length; i++ ){
//     let deleteButton = deleteButtons.item(i);
//     let cancelButton = cancelButtons.item(i);
//     let editButton = editButtons.item(i);
//
//     editButton.addEventListener("click", e => {
//
//     })
// }
// window.onload = function(){
//
// }