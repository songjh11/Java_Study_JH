const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");
const btn = document.querySelector("#btn");

//sibling

console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);


console.log("=============================================")
//parent
console.log(d1_2_1_2.parentNode.parentNode);
btn.addEventListener("click", function(){
    console.log(d1_2_1_2.parentNode.parentNode.parentNode);
    d1_2_1_2.parentNode.parentNode.remove();
})

console.log("=============================================")
//child
console.log(d1.childNodes);
console.log(d1.children[1].children[0].children[0].innerHTML);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);

d1.addEventListener("click", function(){
    //li 태그 모두 삭제
    //ul은 살리고
    console.log(d1.children[1].children[0].innerHTML);
        let ar = document.getElementsByTagName("li");
        let li = d1.children[1].children[0].children;
        console.log(li);

       for (let i=0; i!=li.length;){
                li[0].remove();
                }
})

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667), //인포윈도우 표시 위치입니다
    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성하고 지도에 표시합니다
var infowindow = new kakao.maps.InfoWindow({
    map: map, // 인포윈도우가 표시될 지도
    position : iwPosition, 
    content : iwContent,
    removable : iwRemoveable
});