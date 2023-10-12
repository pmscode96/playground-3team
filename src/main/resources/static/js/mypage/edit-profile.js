

let phoneOpenBtn = document.querySelectorAll(".btn_number");
let phoneClose = document.querySelectorAll(".btn_close");
let modal = document.querySelectorAll(".ngdialog-content")
let back = document.querySelector(".dimmed_layer");
for (let i = 0; i < phoneOpenBtn.length; i++) {

    let item = phoneOpenBtn.item(i);
    let modalContainer = modal.item(i);


    item.addEventListener("click", e =>{
        if(modalContainer.classList.contains('modalOFF')){
            modalContainer.classList.remove('modalOFF');
            modalContainer.classList.add('modalOn')
            back.classList.add("on");
        }
    })
}

for(let i =0; i < phoneClose.length; i++){
    let item = phoneClose.item(i);
    item.addEventListener("click", e =>{
        modal.item(0).classList.remove('modalON');
        modal.item(1).classList.remove('modalON');
        modal.item(0).classList.add('modalOFF');
        modal.item(1).classList.add('modalOFF');
        back.classList.remove("on");
    })
}

// 셀렉터
let options = document.querySelectorAll("#opAge > option");
let select = document.querySelector('.select_on');

for(let i =0; i < options.length; i++){
    let item = options.item(i);

    item.addEventListener("click", e =>{
        alert("asdf");
        item.parentElement.previousElementSibling.innerHTML = item.innerHTML;
    })
}
function handleOnChange(e) {
    // 선택된 데이터 가져오기
    console.log(e.options[e.selectedIndex].text);

    // 데이터 출력
    e.previousElementSibling.innerHTML = e.options[e.selectedIndex].text;
}

