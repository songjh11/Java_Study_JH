
const btn = document.getElementById("btn");
const d1 = document.getElementById("d1");
const add = document.getElementById("add");
const list = document.getElementById("list");
const add2 = document.getElementById("add2");
const list2 = document.getElementById("list2");
const add3 = document.getElementById("add3");
const d2 = document.getElementById("d2");
const add4 = document.getElementById("add4");
const add5 = document.getElementById("add5");
const d3 = document.getElementById("d3");


btn.addEventListener("click", function(){
    
    d1.innerHTML = '<img src="/resources/images/wallpaper_1.jpg">'
})

add.addEventListener("click", function(){
    let li = document.createElement("li");//<li></li>
    let t = document.createTextNode("test");
    li.appendChild(t);
    list.append(li);
    
})

add2.addEventListener("click", function(){
    let li = document.createElement("li");//<li></li>
    let h = document.createElement("h3");//<h3></h3>
    let t = document.createTextNode("Hello");
    h.appendChild(t);
    li.appendChild(h);
    list2.prepend(li);
})

add3.addEventListener("click", function(){
    let ip = document.createElement("input");
    let ch = document.createAttribute("type");//type
    ch.value = "checkbox";                    //type = "checkbox"  
    ip.setAttributeNode(ch);
    d2.appendChild(ip);
})

add4.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("Before");
    h.appendChild(t);
    d3.before(h);
})

add5.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("After")
    h.appendChild(t);
    d3.after(h);
    
})