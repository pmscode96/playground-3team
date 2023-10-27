let title = document.querySelectorAll(".tit_info");
let content = document.querySelectorAll(".item_info");
let deleteButtons = document.querySelectorAll(".deleteBtn");
let cancelButtons = document.querySelectorAll(".cancelBtn");
let editButtons = document.querySelectorAll(".editBtn");
let contentAreas = document.querySelectorAll(".content_area");
let editAreas = document.querySelectorAll(".edit_area");
let updateButtons = document.querySelectorAll(".updateButton");
let updatePosts = document.querySelectorAll(".updatePost")


for (let i = 0; i < updateButtons.length; i++) {

    let updateButton = updateButtons.item(i);




}


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

for (let i = 0; i < title.length; i++) {
    let deleteButton = deleteButtons.item(i);
    let cancelButton = cancelButtons.item(i);
    let editButton = editButtons.item(i);
    let contentArea = contentAreas.item(i);
    let editArea = editAreas.item(i);
    let updateButton = updateButtons.item(i);
    let updatePost = updatePosts.item(i);



    editButton.addEventListener("click",e=>{
        deleteButton.classList.add("hide_btn");
        editButton.classList.add("hide_btn");
        cancelButton.classList.remove("hide_btn");
        updateButton.classList.remove("hide_btn");
        contentArea.classList.add("hide");
        editArea.classList.remove("hide");
    })

    cancelButton.addEventListener("click" , e =>{
        deleteButton.classList.remove("hide_btn");
        cancelButton.classList.add("hide_btn");
        editButton.classList.remove("hide_btn");
        updateButton.classList.add("hide_btn");
        contentArea.classList.remove("hide");
        editArea.classList.add("hide");
    })

    updateButton.addEventListener("click", e =>{
        updatePost.submit();
    })
}

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