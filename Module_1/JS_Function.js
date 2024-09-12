function add(a,b){
    return a+b;
}

let sums = add(5,5);
console.log(sums);

function sum (a,b){
    console.log(a,b);

}
sums = sum(5,5);
console.log(sums);


function showMe(){
    console.log("i am in show");
}

showMe(); 

let show = showMe;
show();

function fun (a,passFun){

    console.log(a);
    passFun();
}

fun(15,show);


function fun2(a,b){
    let num = a;
    let num2 = b;
    return function add(){
            return num+num2;
    }
}


let fan = fun2(2,3);
console.log(fan());


//sort some obj
function compareBy(propertyName) {
    return function (a, b) {
      let x = a[propertyName],
        y = b[propertyName];
      if (x > y) {
        return 1;
      } else if (x < y) {
        return -1;
      } else {
        return 0;
      }
    };
  }

let products = [
    {name: 'iPhone', price: 900},
    {name: 'Samsung Galaxy', price: 850},
    {name: 'Sony Xperia', price: 700}
];

console.log('Products sorted by name:');
products.sort(compareBy('name'));

console.table(products);




//fun in fun 
function show2(value2){
return value2+value2;
}

function length2(fn,val){
    return fn(val);
}
let shows = length2(show2,10);

console.log(shows);

//anonymous function
let show5 = function() {
    console.log('Anonymous function');
};

show5();


let person = {
    firstName: 'First',
    lastName: 'Last'
};

(function () {
    console.log(person.firstName + ' ' + person.lastName);
})(person);

let car=()=> console.log("in car");
car();

let car2 = function(){
    console.log("in car 2");
};
car2();

//fun pass by value

let cube =(a)=> console.log(a*a*a);
cube(2);

//recursive


let counter =(x)=>{
console.log(x);
let num = x-1;
if (num >0){
    counter(num);
}
}
counter(5);



function sum(n) {
    if (n <= 1) {
      return n;
    }
    return n + sum(n - 1);
  }

console.log(sum(8));

// default argument in fun


function say(message='Hi') {
    console.log(message);
}

say(); 
say('Hello') 


function says (message){
    console.log(message);

}

says(); 


function says2 (message){
    typeof message ==='undefined'? message='hi':message;
    console.log(message);

}
says2();

function sumOfNum(x=2,y=x,z=x+y){
    console.log(x+y+z);

}

sumOfNum();
sumOfNum(10); 
sumOfNum(10, 20); 
sumOfNum(10, 20, 30); 
