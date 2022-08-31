const ch = document.getElementsByClassName("ch");
for(let i=0; i<ch.length; i++){
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    })
}

const id = document.getElementById("all");
const cb = document.getElementsByClassName("cb");

all.addEventListener("click", function(){
    console.log("click");
    if(all.checked==true){
        for(let i=0; i<cb.length; i++){
            console.log(i);   
            cb[i].checked=true;
            }
        }
      else{ for(let i=0; i<cb.length; i++){
        console.log(i);   
        cb[i].checked=false;
        }
    }        
})

for(let i=0; i<cb.length; i++){
    cb[i].addEventListener("click", check);
   }

   function check(){
    let result = true;
        for(let i=0; i<cb.length; i++){
            console.log(cb[i].checked);
            if(!cb[i].checked){
                result = false;
                break;
            }
        }
      all.checked = result;  
   }