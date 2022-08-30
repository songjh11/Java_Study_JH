//1. 선택자
//
const d1 = document.getElementById("d1");
alert(d1.value);
alert(d1.getAttribute("value"));

const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const year = document.getElementById("year");
const month = document.getElementById("month");
const date = document.getElementById("date");
const d4 = document.getElementById("d4");

d2.type = "button";

d2.setAttribute("type", "button");

let count = window.prompt("숫자를 입력하세요");
let t = "";
for(let i=0; i<count; i++){
    t=t+'<input type="text">';
}

d3.innerHTML=t;

let y = "";
for(let i=2022; i>=1900; i--){
   y=y+"<option>"+i+"</option>";
}
year.innerHTML = y;    


let m = "";
for(let i=12; i>0; i--){
    m=m+"<option>"+i+"</option>";
}
month.innerHTML = m;    

let d = "";
for(let i=31; i>0; i--){
    d=d+"<option>"+i+"</option>"
}

date.innerHTML = d;

let r = prompt("Row의 갯수 입력"); //tr
let c = prompt("Column의 갯수 입력"); //td

let table = "";

for(let i=0; i<r; i++){
    table=table+"<tr>";
        for(let j=0; j<c; j++){
            table=table+"<td>"+i+j+"</td>";
        }
    table=table+"</tr>";
}

d4.innerHTML = table;