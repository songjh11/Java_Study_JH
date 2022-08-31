const d2 = document.getElementById("d2");

d2.addEventListener("focus", function(){
    console.log("입력 대기 상태");

})

d2.addEventListener("blur", function(){
    console.log("블러 발생")
})

// d1에 입력하고 나왔을때 글자의 길이가 3글자 이하라면 d1에 포커스 발생

const d1 = document.getElementById("d1");

d1.addEventListener("blur", function(){
    console.log("d1blur");
    console.log(d1.value.length);
    if(d1.value.length<3){
        d1.focus();
    }
})

