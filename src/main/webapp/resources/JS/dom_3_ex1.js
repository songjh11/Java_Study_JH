const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");
const btn4 = document.getElementById("btn4");
const select = document.getElementById("select");
const c1 = document.getElementsByClassName("c1");


btn.addEventListener("click", function(){
    // console.log("work");
    // console.log(d1.value);
    // console.log(d2.value);
    // d3.value = d1.value*1+d2.value*1;
    console.log(select.value)
    let result = "";

    switch(select.value){
        case "+"
            : result=d1.value*1+d2.value;
        case "-"
            : result=d1.value*1-d2.value;
        case "*"
            : result=d1.value*d2.value;
        case "/"
            : result=d1.value*1 / d2.value*1;
        case "%"
            : result= d1.value*1 % d2.value*1;        
    }
    d3.value = result;
});

btn2.addEventListener("click",function(){
    alert("버튼2")
});

btn3.addEventListener("click", function(){
    btn2.click();
});

btn4.addEventListener("click", function(){
    alert(c1);
    console.log(c1);
    for(let i=0; i<c1.length; i++){
        console.log(c1[i].value);
    }
    c1[1].selected = true;

});

