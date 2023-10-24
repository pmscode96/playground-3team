let join = document.getElementById("join");


// $('#phone_b1').click(function(){
//
//     let phoneNumber = $('#userPhone').val();
//     console.log(phoneNumber);
//     phoneNumber = phoneNumber.replace(/-/g, "");
//     console.log(phoneNumber);
//
//     $.ajax({
//         type: "GET",
//         url: "/check/sendSMS",
//         data: {
//             "phoneNumber" : phoneNumber
//         },
//         success: function(res){
//             $('.phonecheck_b1').click(function(){
//                 if($.trim(res) === $('#checkNum').val()){
//                     join.disabled = false
//                     join.style.backgroundColor = "#191919";
//                     join.style.borderColor = "#191919";
//                 }else{
//                     alert("인증번호가 일치하지 않습니다!")
//                 }
//             })
//         }
//     })
// });
