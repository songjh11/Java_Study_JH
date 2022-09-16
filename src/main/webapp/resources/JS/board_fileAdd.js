{/* <tr>	
				<td colspan="2">파일1<input type="file" name="files"></td>		
			</tr> */}
            const tableAdd = document.getElementById("tableAdd");
            const fileAdd = document.getElementById("fileAdd");
            const tbody = document.getElementById("tbody");
            const addFiles = document.getElementById("addFiles");
            const fileDelete = document.querySelectorAll(".fileDelete");
                //const fileDelete = document.getElementsByClassName("fileDelete"); //foreach불가능
                
                // --------update시 file Delete
                
                try{
                fileDelete.forEach(function(f){
                   f.addEventListener("click", function(){
                        console.log(f.parentNode)
                      let check = window.confirm("삭제하면 되돌리기X");
                      
                      if(!check){
                        return;
                      }
                          let fileNum = f.getAttribute("data-file-num");
                          // ---이제 파일을 삭제하는 ajax 생성 (비동기)
                          const xhttp = new XMLHttpRequest();
                          xhttp.open("POST", "./fileDelete");
    
                          xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
                          xhttp.send("fileNum="+fileNum);
                          
                          xhttp.onreadystatechange=function(){
                            if(xhttp.readyState==4&&xhttp.status==200){
                                let result = xhttp.responseText.trim();
                                if(result==1){
                                    console.log(result);
                                    f.parentNode.remove();   
                                } else{
                                    console.log(result);
                                }
                            }
                          }
                  
                    });
                });
                
                }catch(e){
                    console.log(e);
                }
                
                // for(fi of fileDelete){
                //    console.log(fi);
                // }

                //----------------------------------
                let result = 0;
                let idx=0;

                function setCount(c){
                    if(c>=0){
                        result=c;
                    }
                }
                try{

                    fileAdd.addEventListener("click", function(){
                                      
                        if(result>4){
                            alert("최대 5개만 가능")
                            return;
                        }

                        let tr = document.createElement("tr");
                        let td = document.createElement("td");
                        let input = document.createElement("input");
                        let file = document.createAttribute("type");
                        let text = document.createTextNode("파일: ");
                        let button = document.createElement("button");
                        let btype = document.createAttribute("type");
                        let btext = document.createTextNode("파일 삭제");

                        
                        file.value="file";
                        input.setAttributeNode(file);
                        
                        file = document.createAttribute("name");
                        file.value = "files";
                        input.setAttributeNode(file);
                        
                        let span = document.createAttribute("colspan");
                        span.value = "2";
                        td.setAttributeNode(span);
                        td.appendChild(text);
                        td.appendChild(input);

                        btype.value = "button";
                        button.setAttributeNode(btype);

                        btype = document.createAttribute("class");
                        btype.value = "del btn btn-danger";
                        button.setAttributeNode(btype);
                        
                        btype = document.createAttribute("id");
                        btype.value = idx;
                        button.setAttributeNode(btype);
                        button.appendChild(btext);
                        
                        td.appendChild(button);

                        let trid = document.createAttribute("id");
                        trid.value="file"+idx;
                        tr.setAttributeNode(trid);
                        tr.appendChild(td);
                        tbody.append(tr);

                        result++;
                        idx++;
                    
                })
                tableAdd.addEventListener("click", function(event){
                    let buttondel = event.target;
                   if(buttondel.classList[0]=="del"){
                       alert(buttondel.innerHTML);
                            document.getElementById("file"+buttondel.id).remove();
                               result--;
                               console.log(result);
                   }
                })
            }catch(e){

            }
