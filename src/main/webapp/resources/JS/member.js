function loginCheck(){
    const btn = document.getElementById("btn");
    const loginForm = document.getElementById("loginForm");
    const id = document.getElementById("id");
    const password = document.getElementById("password");
    const fail = document.getElementById("fail");
    const idHelp = document.getElementById("idHelp");
    const pwHelp = document.getElementById("pwHelp");

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
            }
    )   
}

const all = document.getElementById("all");
const cb = document.getElementsByClassName("cb");
const joinBtn = document.getElementById("joinBtn");
const frm= document.getElementById("frm");
const req = document.getElementsByClassName("req");

all.addEventListener("click", function(){
  for(let i=0; i<cb.length; i++){ 
    cb[i].checked=all.checked;
  }
})

for(let i=0; i<cb.length; i++){
    cb[i].addEventListener("click", check);
}

function check(){
    let result = true;
    for(let i=0; i<cb.length; i++){
        if(!cb[i].checked){
            result=false;
            break;
        }
    }
    all.checked=result; 
}

joinBtn.addEventListener("click", function(){
    let result = true;
     for(let i=0; i<req.length; i++){
       if(!req[i].checked){
           result=false;
           break;  
        }
    }
        if(result==true){
            frm.submit();
        }
        else{
            alert("필수 약관 동의가 필요합니다");
        }
})