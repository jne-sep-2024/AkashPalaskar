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



const obj = { a: 1, b: 2 };
console.log(Object.keys(obj));  
console.log(Object.values(obj));  
console.log(Object.entries(obj)); 

console.log(Object.getOwnPropertyNames(obj)); 

console.log(Object.getOwnPropertyDescriptor(obj, 'a'));

Object.defineProperty(obj, 'c', { value: 42, writable: false });
console.log(Object.entries(obj)); 
Object.defineProperties(obj, {
    f: { value: 42, writable: true },
    e: { value: 'foo', configurable: true }
  });

  console.log(Object.entries(obj)); 
  console.log(Object.hasOwn(obj, 'f'));  // true

  const proto = Object.getPrototypeOf(obj);
  console.log(obj);
  Object.freeze(obj);
  console.log(Object.isFrozen(obj));  // true
  Object.seal(obj);

Object.isSealed(obj);
console.log(Object.isSealed(obj));  // true

Object.preventExtensions(obj);

let obj2 =obj.__proto__;

console.log(Object.isExtensible(obj));  // false

console.log(Object.isExtensible(obj2));  // true


function fun3(){
    var a ='aa';
    let a1='bb';
    console.log(c);

}

fun3();
var c ='cc';

// console.log(c);
// console.log(a1);

console.log(obj.valueOf());
const arr = [['a', 1], ['b', 2],['c', 3]];

const obj3 = Object.fromEntries(arr);  // { a: 1, b: 2 }
console.log(obj3);

let arr2=[2,4,6,8]

let arr3=[1,3,6,9]

console.log(arr2.every(item=>item%2===0)); //let arr2=[2,4,6,8] every item have to true

console.log(arr3.some(item=>item%2===0)); //let arr3=[1,3,6,9] at least on item should be true
console.log(Object.getOwnPropertyNames(obj)); 
