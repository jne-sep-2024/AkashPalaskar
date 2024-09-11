var demo = 22;


console.log (demo);

let counter = 120;
console.log (typeof(counter));

counter= false;
console.log (typeof(counter));


counter= "hi";
console.log (typeof(counter));

let num = 1000000;
console.log(num);
let num2= 10_00_000;
console.log(num2);

let a = Boolean("hi");
console.log(a);
console.log(typeof(a));

let b = new Boolean(false);
console.log(b.valueOf());

console.log("-----------------");

let c = true;
let d = new Boolean(true);

c.name="demo";
d.name="demo";

console.log(c.name);
console.log(d.name);

console.log("-----------------");

if(c){
    console.log("i am in c");

}
if (d){
    console.log("i am in d");

}

console.log("---------------");
let str = "i am ";
let str2 = " ash";

let str3 = str + str2;
console.log(str3); 

let str4 = `Hi , ${str3}`;
console.log(str4);

let str5 =`${str4} \r\ni am emp of think `;
console.log(str5);

let str6 = `${str4} \t\t\t i am emp of think`;
console.log(str6);

console.log("---------------");

let person = {
    firstname:"john",
    lastname:"doe"
}
console.log(typeof(person));
console.log(person.firstname);
console.log(person.lastname);
console.log(person['firstname']);
console.log(person['lastname']);

person.address={
    buldingNo:'102',
    street:'besa street',
    state: 'maharashtra',
    city:'nagpur'
}
console.log(person);
delete person.lastname;
console.log(person);

console.log('lastname'in person);
console.log('firstname' in person);

let name = "akash";
name.empno=1001;
console.log(name);
console.log(name.empno);

console.log("--------------");

let arr = Array(9,8,7,6,4,5,4);

console.log(arr.length);
console.log(arr.indexOf(arr.length-1));

arr.map(value => console.log(value));

const pop = arr.pop();
console.log("pop "+ pop);

arr.map(value => console.log(value));

const shift = arr.shift();
console.log("shift : " +shift);

arr.map(value => console.log(value));

const unshift = arr.unshift();
console.log("upshift : "+ unshift);

arr.map(value => console.log(value));

console.log(Array.isArray(arr));
console.log(Array.isArray(unshift));
