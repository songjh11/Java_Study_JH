const commentAdd = document.querySelector("#comment");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.getElementById("more");
const deleteComment = document.getElementsByClassName("delete");

//page 번호 담는 변수
let page = 1;
//booknum을 담는 변수
const bookNum = commentAdd.getAttribute("data-book-num");

getCommentList(page, bookNum);

commentAdd.addEventListener("click", function(){
    let wv = writer.value;
    let cv = contents.value;
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
            result=JSON.parse(result);

            writer.value = "";
            contents.value = "";

            if(result.result==1){
                alert("댓글 등록 완료");
                if(commentList.children.length !=0){
                    for(let i=0; i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                }
                page = 1;
                getCommentList(page, bookNum);
            }
        }
    }
})//click event end

function getCommentList(p, bn){
    //1. XMLHttpRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 정보
    xhttp.open("GET","./commentList?page="+p+"&bookNum="+bn);

    //3. 요청 전송
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            // 1. 
            // commentList.innerHTML = xhttp.responseText;
            let result = JSON.parse(xhttp.responseText.trim());
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value="table table-bordered border-primary";
            // result.setAttributeNode(resultAttr);
            
            let pager = result.pager; //commentpager
            let ar = result.list; //댓글 리스트

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
                // 날짜 변경
                // const d = new Date(ar[i].regDate);
                // const year = d.getFullYear();
                // const month = d.getMonth()+1;
                // const day = d.getDate();
                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class")
                tdAttr.value = "update";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value = ar[i].num;
                td.setAttributeNode(tdAttr); 
                td.appendChild(tdText);
                tr.appendChild(td);
                
                td = document.createElement("td");
                tdText = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class")
                tdAttr.value = "delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value = ar[i].num;
                td.setAttributeNode(tdAttr); 
                td.appendChild(tdText);
                tr.appendChild(td);

                commentList.append(tr)
                
                if(pager.page >= pager.totalPage){
                    more.classList.add("disabled");
                } else{
                    more.classList.remove("disabled");
                }
            }
            // let t = commentList.children;

            // if(t.length != 0){
            //     commentList.children[0].remove();
            // }

            // try{
                //     console.log(commentList.children);
                //     throw new Error("에러");
                // } catch(exception){
                    
                    // } finally{
                        
                        // }
        //    commentList.append(result);
        }
 })
}//commentList 끝

//-----------더보기---------------------

more.addEventListener("click", function(){
    console.log("yaho");
    page++;
    console.log(page);
    console.log(bookNum);
    getCommentList(page, bookNum);
})

commentList.addEventListener("click", function(event){
     let buttonClick = event.target;
        console.log(event.target);
        if(buttonClick.className=="delete"){
            console.log("delete");
            let check = window.confirm("삭제하시겠습니까?")
            if(check){
                let num = buttonClick.getAttribute("data-comment-num");
                console.log("Num"+num);
        //1. 객체 생성, 메소드, 주소 , 요청 전송, 응답처리
                const xhttp = new XMLHttpRequest();

                xhttp.open("POST", "commentDelete")
                
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//post는 헤더 정보가 필요함

                xhttp.send("num="+num);

                xhttp.onreadystatechange = function(){
                    if(this.readyState==4 && this.status==200){
                        let result = xhttp.responseText.trim();
                    if(result==1){
                        alert("삭제 완료");

                        for(let i=0; i<commentList.children.length;){
                            commentList.children[0].remove();
                        }

                        page=1;

                        getCommentList(page, bookNum);
                    } else{
                        alert("삭제 실패");
                    }
                    }
                }
            }
    }    
        
   if(buttonClick.className=="update"){
            let buttonClick = event.target;
            if(buttonClick.className == "update"){
                    let contents = buttonClick.previousSibling.previousSibling.previousSibling.innerHTML;
                    let writer = buttonClick.previousSibling.previousSibling.innerHTML;
                    let num = buttonClick.getAttribute("data-comment-num");
                    console.log(writer);
                    console.log(num);
                    console.log(contents);
                    document.querySelector("#up").click();
                    document.querySelector("#updateContents").value = contents;
                    document.querySelector("#updateWriter").value = writer;
                    document.querySelector("#num").value = num;
                }
    }

    const updateCommentButton = document.querySelector("#updateCommentButton");

    updateCommentButton.addEventListener("click", function(){
        //modal에서 num, contents 가져오기
        const num = document.querySelector("#num").value;
        const uv = document.querySelector("#updateContents").value;
 
        //1. 객체 생성
        //2. 요청 정보(method. URL)
        //3. 헤더 정보
        //4. 요청 실행
        //5. 응답 처리

        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","commentUpdate"); //GET이면 commentUpdate?로 보냄

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("num="+num+"&contents="+uv);//파라미터는 DTO의 변수명으로 보내야 STS에서 데이터 확인이 가능

        xhttp.onreadystatechange = function(){
            if(xhttp.readyState==4 && xhttp.status==200){
                let result = xhttp.responseText.trim();
                if(result==1){
                    alert("댓글 수정 완료");
                    
                    //기존 리스트 삭제 및 새로운 리스트 호출
                    for(let i=0; i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                    page=1;
                    getCommentList(page, bookNum);
                } else{
                    alert("댓글 수정 실패");
                }
            }
        }

    })
     
    
})
