const d1 = document.querySelector("#d1");
const d2 = document.querySelector("#d2");
const result = document.querySelector("#result");


d1.addEventListener("click", function(){
    console.log("실행");

    //1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2. 요청 정보
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+d2.value);

    //3. 요청 발생
    xhttp.send();

    //4. 응답 결과 처리
    xhttp.onreadystatechange = function(){
        //this는 xhttp객체
        // console.log(this.status);
        // console.log(this.readyState);
        // console.log("================================")
        if(this.readyState==4 && this.status==200){
            //console.log(this.responseText);
            let response = this.responseText.trim();
            response = JSON.parse(response);//문자열을 객체로 변환

            console.log("userId: ", response.userId);
            console.log("id: ", response.id);
            console.log("title: ", response.title);
            console.log("body: ", response.body);

            let h = document.createElement("h3");
            let h_text = document.createTextNode(response.userId);
            h.appendChild(h_text);
            result.append(h);

            h = document.createElement("h3");
            h_text = document.createTextNode(response.title);
            h.appendChild(h_text);
            result.append(h);

            h = document.createElement("h3");
            h_text = document.createTextNode(response.id);
            h.appendChild(h_text);
            result.append(h);

            h = document.createElement("h3");
            h_text = document.createTextNode(response.body);
            h.appendChild(h_text);
            result.append(h);

        }
    }

    console.log("ajax 발생")
})