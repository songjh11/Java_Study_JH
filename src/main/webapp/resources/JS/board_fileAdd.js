{/* <tr>	
				<td colspan="2">파일1<input type="file" name="files"></td>		
			</tr> */}
            function filesAdd(){

                const tableAdd = document.getElementById("tableAdd");
                const fileAdd = document.getElementById("fileAdd");
                const tbody = document.getElementById("tbody");
                const addFiles = document.getElementById("addFiles");
                let result = 0;
                let idx = 0;
                
                fileAdd.addEventListener("click", function(){
                    if(result<5){
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
                    } else{
                        alert("최대 5개까지 추가 가능");
                    }
                })
                tableAdd.addEventListener("click", function(event){
                   if(event.target.classList[0]=="del"){
                       alert(event.target.innerHTML);
                        tableAdd.removeChild(0);
                                      console.log(event.target);

                   }
                })
            }