alert("Hello"); 

var num=1;
//num = 'abc';
let num2 = '1';

//콘솔프린트문
console.log(num==num2);

console.log(num===num2);

var count = 1;

for(var i=0; i<10; i++){
    console.log(i);
    var count=2;
}
console.log("====================================")
//i=지역변수
console.log(i);
console.log(count);

let ar = ['4', 1, 3, '2', 3];
console.log(ar[0], ar[1]);

ar.push(5);
console.log("====================================")
console.log(ar);

ar.unshift('9');

console.log("====================================")
console.log(ar);

ar.sort();
console.log("====================================")
console.log(ar);

ar.reverse();
console.log("====================================")
console.log(ar);

ar.forEach(function(v, i, ar){
    console.log("v: ", v);
    console.log("i: ", i);
})
