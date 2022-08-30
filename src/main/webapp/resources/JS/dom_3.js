const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const btn1 = document.getElementById("btn1")
d1.innerHTML = "Hello";

//function 함수명(){}
function test(){
    alert("Click Event");
    let result = test2(1,2); 
    console.log(result);
    f1();
}

//명명함수-이름이 있는 함수
function test2(num1, num2){
    let result = num1+num2;
    return result;
}

//익명함수-함수명이 없는 함수
let f1 = function (){
    console.log("익명함수실행");
}

//Event 적용 2
//d2.onclick = f1;
d2.onclick = function(){
    console.log("Click 콜백 함수 실행");
};

//Event 적용 3 이걸 쓰자!
btn1.addEventListener("click", function(){
    console.log("실행");
});