async function getuser() {

    let getdata = await fetch("https://jsonplaceholder.typicode.com/users")
        .then((res) => res.json());


    let rows = [];

    for (const user in getdata) {

        rows += "<tbody><tr><td>" + getdata[user].id + "</td>";
        rows += "<td>" + getdata[user].name + "</td>";
        rows += "<td>" + getdata[user].email + "</td>";
        rows += "<td>" + getdata[user].phone + "</td></tr></tbody>";




        document.getElementById("table").innerHTML += rows;


    }
    document.getElementById("table").style.display = 'inline-table'; 
    document.getElementById("table").style.width=" 100%";

        document.getElementById("botton").style.display = 'none'; 

}