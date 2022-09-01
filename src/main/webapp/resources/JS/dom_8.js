const count = document.getElementById("count");
const btn = document.getElementById("btn");
const result = document.getElementById("result");
const c1 = document.getElementsByClassName("c1");

const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");

const google = document.getElementById("google");

btn.addEventListener("click", function(){
    const textCount = document.createTextNode(count.value+"번");
    btn.appendChild(textCount);
    
    for(let i=0; i<count.value; i++){
        console.log(i);
        let button = document.createElement("button");
        let t = document.createTextNode("Click"+i);
        button.appendChild(t);
        let attr = document.createAttribute("class");
        attr.value = "c1";
        button.setAttributeNode(attr);
        result.append(button);
    }
})


d1.addEventListener("click", function(event){
    console.log("d1찍음");
    console.log(event);
    console.log(event.currentTarget);//부모영역
    console.log(event.target);//현재클릭한영역

    if(event.target.className=='buttons'){
        alert("맞다");
        console.log('this: ',this);
        alert(event.target.innerHTML);
    }
})



google.addEventListener("click", function(event){
    alert("Go google");
    event.preventDefault();
    
})

//------------------------------------------------------------

result.addEventListener("click", function(event){
    if(event.target.className=='c1'){
        alert(event.target.innerHTML);
    }
})