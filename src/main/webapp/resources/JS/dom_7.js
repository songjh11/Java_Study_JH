const remove1 = document.getElementById("remove1");
const remove2 = document.getElementById("remove2");
const remove3 = document.getElementById("remove3");
const d2 = document.getElementById("d2");
let count = 0;
const d1 = document.getElementById("d1");

remove1.addEventListener("click", function(){
    d1.remove();
})

remove2.addEventListener("click", function(){
    for(let i=1; i<5; i++){
        const d2_1 = document.getElementById("d2_"+i)
        d2.removeChild(d2_1);
    }
})

remove3.addEventListener("click", function(){
    const ar = [];
    const d2all = document.getElementsByClassName("d2all");
    for(let i=0; i<d2all.length; i++){
        ar.push(d2all[i].id);
    }
    for(i of ar){
        let d = document.getElementById(i);
        d2.removeChild(d);

    }
}
)