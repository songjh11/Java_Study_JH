const btn = document.getElementById("btn");
const loginForm = document.getElementById("loginForm");
const id = document.getElementById("id");
const password = document.getElementById("password");
const fail = document.getElementById("fail");
const idHelp = document.getElementById("idHelp");
const pwHelp = document.getElementById("pwHelp");
const all = document.getElementById("all");
const cb = document.getElementsByClassName("cb");

btn.addEventListener("click", function(){
    let u = id.value;
    console.log(u.length);
    let p = password.value;
    
        if(u==""){
            idHelp.innerHTML = "아이디는 필수입니다"
        }

        if(p==""){
            pwHelp.innerHTML = "패스워드는 필수입니다"
        }

        if(u.length>0 && p.length>0){
                loginForm.submit();
            }
    })

all.addEventListener("click", function(){
    if(all.checked==true){
        for(let i=0; i<cb.length; i++){
            cb[i].checked=true;
        }
    } 
    else{
        for(let i=0; i<cb.length; i++){
            cb[i].checked = false;
        }
    }
    
})
