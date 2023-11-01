// 이름 글자수
$(document).ready(function() {
    $('#subTitle').on('input', function() {
        var inputLength = $(this).val().length;
        $('.txt_num').text(inputLength + '/20');
    });
    $('.select_on').text($('#opAge').find(':selected').text());
});

// 프로필 이미지
let file = document.querySelector("#profileInput");
const form = document.querySelector("form[name='edit-form']");
let src = document.querySelector(".img_thumb").src;

document.querySelector(".cancel").addEventListener("click", (e) => {
    e.target.style.display = "none";
    document.querySelector(".img_thumb").setAttribute("src", `${src}`);
    document.querySelector("#profileInput").value = "";
})

file.addEventListener("change", (e) => {
    const file = e.target.files[0];
    const name = file.name;
    const formData = new FormData();
    formData.append("uploadFiles", file);

    fetch("/file/upload", {
        method: "POST",
        body: formData
    }).then((response) => response.json())
        .then((uuids) => {
            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();
            month = month < 10 ? '0' + month : month;
            date = date < 10 ? '0' + date : date;
            let fileName = `${year}/${month}/${date}/t_${uuids[0]}_${name}`;
            document.querySelector(".img_thumb").setAttribute("src", `/file/display?fileName=${fileName}`)
            document.querySelector(".cancel").style.display = "block";
            let input = document.getElementById("uuidInput");
            input.value = uuids[0];
        })
});


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
    // console.log(e.options[e.selectedIndex].text);

    // 데이터 출력
    e.previousElementSibling.innerHTML = e.options[e.selectedIndex].text;
}

// 휴대폰 번호 형태 검사
function validatePhoneNumber() {
    var phoneNumberInput1 = $('#phoneNum1');
    var phoneNumberInput2 = $('#phoneNum2');
    var phoneNumberInput3 = $('#phoneNum3');
    var phoneNumber = phoneNumberInput1.val() + '-' + phoneNumberInput2.val() + '-' + phoneNumberInput3.val();
    var pattern = /^(010|011|016|017|018|019)-?\d{3,4}-?\d{4}$/;

    if (pattern.test(phoneNumber)) {
        phoneNumberInput1.css({'border': '1px solid #ddd', 'color': 'black'});
        phoneNumberInput2.css({'border': '1px solid #ddd', 'color': 'black'});
        phoneNumberInput3.css({'border': '1px solid #ddd', 'color': 'black'});
        return true;
    } else {
        phoneNumberInput1.css({'border': '1px solid red', 'color': 'red'});
        phoneNumberInput2.css({'border': '1px solid red', 'color': 'red'});
        phoneNumberInput3.css({'border': '1px solid red', 'color': 'red'});
        return false;
    }
}

// 핸드폰 번호 인증
$('#phone_b1').click(function() {
    var isValid = validatePhoneNumber();
    console.log("유효성 검사: " + isValid);

    if(isValid) {
        // 받아온 번호 3개를 형태에 맞게 합치고 변환
        var phoneNumber = $('#phoneNum1').val() + '-' + $('#phoneNum2').val() + '-' + $('#phoneNum3').val();
        $.ajax({
            type: "GET",
            url: "/check/phone",
            data: {
                "phoneNumber": phoneNumber
            },
            success: function (exists) {
                console.log(exists)
                if (exists === true) {
                    alert("이미 사용 중인 전화번호입니다.");
                } else {
                    $.ajax({
                        type: "GET",
                        url: "/check/sendSMS",
                        data: {
                            "phoneNumber": phoneNumber
                        },
                        success: function (res) {
                            $('.phonecheck_b1').click(function () {
                                if ($.trim(res) === $('#certifyNum').val()) {
                                    $.ajax({
                                        type: "GET",
                                        url: "/check/phoneNumberUpdate",
                                        data: {
                                            "phoneNumber": phoneNumber
                                        },
                                        success: function (res) {
                                            console.log("업데이트 성공")
                                            modal.item(0).classList.remove('modalON');
                                            modal.item(0).classList.add('modalOFF');
                                            back.classList.remove("on");
                                        }
                                    });
                                } else {
                                    alert("인증번호가 일치하지 않습니다!")
                                }
                            })
                        }
                    });
                }
            }
        });
    }
});