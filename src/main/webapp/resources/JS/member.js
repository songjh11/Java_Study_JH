function loginCheck(){
    const btn = document.getElementById("btn");
    const loginForm = document.getElementById("loginForm");
    const id = document.getElementById("id");
    const password = document.getElementById("password");
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

function okCheck(){

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
}

function joinCheck(){
    let uNameResult = false;
    let pwResult = false;
    let nameResult = false;
    let emailResult = false;
    let phoneResult = false;

    const userName = document.getElementById("userName");
    const userNameHelp = document.getElementById("userNameHelp");
   
    const joinPw = document.getElementById("joinPw");
    const passwordHelp = document.getElementById("passwordHelp");
    
    const passwordCheck = document.getElementById("passwordCheck");
    const passwordError = document.getElementById("passwordError");
   
    const name = document.getElementById("name");
    const nameCheck = document.getElementById("nameCheck");
  
    const email = document.getElementById("email");
    const emailCheck = document.getElementById("emailCheck");

    const phone = document.getElementById("phone");
    const phoneCheck = document.getElementById("phoneCheck");

    userName.addEventListener("blur", function(){
        let un = userName.value; 
        uNameResult = false;
        console.log(un.length);
        if(un.length<2){
            userName.focus();
            userNameHelp.innerHTML = "아이디는 2글자 이상 입력하세요";
        } else{
            uNameResult = true;
            userNameHelp.innerHTML = "";
        }
    })
    
    joinPw.addEventListener("change", function(){
        const pv = joinPw.value;
        pwResult = false
        console.log(pv.length);
        if(pv.length<6){
            joinPw.focus();
            passwordHelp.innerHTML = "패스워드는 6글자 이상 입력하세요"
        } else{
            pwResult=true;
            passwordHelp.innerHTML = "";
            passwordCheck.value="";
         }
    })

    passwordCheck.addEventListener("blur", function(){
        let pc = passwordCheck.value;
        pwResult = false
        console.log(pc);
        if(pc.length<6){
            passwordError.innerHTML = "패스워드는 6글자 이상 입력하세요";
        } else{
            if(pc==joinPw.value){
                pwResult=true;
                passwordError.innerHTML = "패스워드 일치";
            } else{
                passwordCheck.value="";
                passwordError.innerHTML = "패스워드 불일치"
            }
        }
    })


    name.addEventListener("blur", function(){
        nameResult = false;
            if(name.value.length<1){
                nameCheck.innerHTML = "1글자 이상 입력하세요";
            } else{
                nameResult = true;
                nameCheck.innerHTML = "";
            }
         
    })
  
    email.addEventListener("blur", function(){
        emailResult = false;
        if(email.value.length<1){
            emailCheck.innerHTML = "1글자 이상 입력하세요";
        } else{
            emailResult = true;
            emailCheck.innerHTML = "";
        }
    })

    phone.addEventListener("blur", function(){
        phoneResult = false;
        if(phone.value.length<1){
            phoneCheck.innerHTML = "1글자 이상 입력하세요";
        } else{
            phoneResult = true;
            phoneCheck.innerHTML = "";
        }
    })

    const joinFrm = document.getElementById("joinFrm")
    const joinBtn = document.getElementById("joinBtn");

    joinBtn.addEventListener("click", function(){
        if(uNameResult&&pwResult&&nameResult&&emailResult&&phoneResult){
            joinFrm.submit();
        }
        else{
            alert("다시 입력하세요");
        }
    })
}