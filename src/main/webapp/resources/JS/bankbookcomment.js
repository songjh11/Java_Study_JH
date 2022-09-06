const commentAdd = document.querySelector("#comment");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");

getCommentList();

commentAdd.addEventListener("click", function(){
    
    let bookNum= commentAdd.getAttribute("data-book-num")
    let wv = writer.value;
    let cv = contents.value;
    
    console.log(wv);
    console.log(cv);
    console.log(booknum);
    //ajax
    //1. xmlhttprequest 객체 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 준비
    xhttp.open("POST", "./commentAdd");
    
    //3. EncType 
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 전송(POST일 경우 파라미터 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result= xhttp.responseText.trim();
            console.log(result);
            result=JSON.parse(result);

            if(result.result==1){
                alert("댓글 등록 완료");
                getCommentList();
            }
        }
    }

    
})//click event end

function getCommentList(){
    let bookNum= commentAdd.getAttribute("data-book-num")

    //1. XMLHttpRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 정보
    xhttp.open("GET","./commentList?page=1&bookNum="+bookNum);

    //3. 요청 전송
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            console.log(xhttp.responseText);
            // 1. 
            // commentList.innerHTML = xhttp.responseText;

            let ar = JSON.parse(xhttp.responseText.trim());
            let result = document.createElement("table");
            let resultAttr = document.createAttribute("class");
            resultAttr.value="table table-bordered border-primary";
            result.setAttributeNode(resultAttr);
            
            for(let i=0; i<ar.length; i++){
                let tr = document.createElement("tr");
                let td = document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);

                result.appendChild(tr);
                console.log(ar[i]);
                console.log(ar[i].contents);
                console.log(ar[i].writer);
            }

            commentList.append(result);
            
        }
    })
}