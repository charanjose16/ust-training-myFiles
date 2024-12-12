const baseUrl="http://localhost:8080/api/v1/task";

async function addTask(task){
    let response=await fetch(baseUrl,{
        method:"POST", 
        headers:{'Content-Type':'application/json'},
        body:JSON.stringify(task)
    })
    let data=await response.json();
    return data;
}

async function viewTasks(){
    let response=await fetch(baseUrl)
    return response;
}

async function deleteTask(id){
    let response=await fetch(`${baseUrl}/${id}`,{
        method:"DELETE"
    });
    let data=response.json();
    return data;
}

async function updateTask(id,task){
    let response=await fetch(`${baseUrl}/${id}`,{
        method:"PUT",
        headers: { 'Content-Type': 'application/json' },
        body:JSON.stringify(task)
    })
    let data=await response.json();
    return data;
}

