{/* <tr>	
				<td colspan="2">파일1<input type="file" name="files"></td>		
			</tr> */}
            function filesAdd(){

                const tableAdd = document.getElementById("tableAdd");
                const fileAdd = document.getElementById("fileAdd");
                const tbody = document.getElementById("tbody");
                let result = 0;
                
                fileAdd.addEventListener("click", function(){
                    if(result<5){
                        let tr = document.createElement("tr");
                        let td = document.createElement("td");
                        let input = document.createElement("input");
                        let file = document.createAttribute("type");
                        let text = document.createTextNode("파일: ");
                        file.value="file";
                        input.setAttribute("name", "files");
                        input.setAttributeNode(file);
                        td.setAttribute("colspan", "2");
                        td.appendChild(text);
                        td.appendChild(input);
                        tr.appendChild(td);
                        tbody.append(tr);
                        result++;
                    } else{
                        alert("최대 5개까지 추가 가능");
                    }
                })
            }