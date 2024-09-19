let todo = []



function addTodo() {

    console.log("in fun add todo");

    let todoname = document.getElementById("todoName").value;
    let date = document.getElementById("date").value;

    console.log(todoname);

    console.log(date);


    todo.push({
        todo: todoname,
        dueDate: date,
        status: "to-do"
    });



let rows = "";

rows += "<tbody><tr><td>" + todo[todo.length - 1].todo + "</td>";
rows += "<td>" + todo[todo.length - 1].dueDate + "</td>";
rows += "<td>" + todo[todo.length - 1].status + "</td>";

rows += `<td><button onclick='deleteTodo(${[todo.length - 1]})'>Delete</button></td></tr></tbody>`;

document.getElementById("todo").innerHTML += rows;

console.log(rows);



}



function deleteTodo(num) {
    let item = num;
    console.log(item);
    todo.splice(item,1);

    console.log(todo);

  document.getElementById("todo").deleteRow(num+1);



}