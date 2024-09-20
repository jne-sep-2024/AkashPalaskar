let arr =[1,2,3,4,5];
let arr2=[6,7,8];

console.log(arr);
console.log(Object.keys(arr));

console.log(Object.values(arr));

console.log(Object.entries(arr));

// console.log(Object.assign(arr,arr2));


let obj ={
    name :"think",
    type:"emp",
    role:"dev"
}

let obj2={
    reportTo:"tl",
    lang:"java",
    greed:()=>{console.log("hello")}
}

let obj3 = Object.assign(obj,obj2);

console.log(obj3);



// Object.freeze(obj3); 
Object.seal(obj3);
obj3.name="ash";

console.log(obj3);


console.log( Object.getOwnPropertyDescriptors(obj3));
console.log( Object.getOwnPropertyDescriptors(obj3));



console.log(arr.includes(6));
console.log(arr);

let proto = Object.create(obj3);


console.log("-------------------");
console.log(proto);
console.log(Object.getPrototypeOf(proto));
console.log(obj3);

console.log(Object.hasOwn(obj, 'name')); // true
console.log(Object.hasOwn(obj, 'toString')); 
let joinarr=arr.join("-");
console.log("---------------------");
console.log(arr.concat(arr2));



console.log(obj3);


Object.freeze(obj3.name);
obj3.name ="think"
obj3.lang="php"
console.log(obj3);

class Animal {
    constructor(name) {
      this.name = name;
    }
  
   speak() {
      console.log(`${this.name} makes a sound.`);
    }
  }
  
  class Dog extends Animal {
    constructor(name, breed) {
      super(name); 
      this.breed = breed;
    }
  
    speak() {
      super.speak(); // if the function is static we can't use it 
      console.log(`${this.name} barks.`);
    }
  }
  
  const dog = new Dog('tommy', 'Goldy');
  dog.speak();



  function higherOrder(fn) {
    console.log("fn");

    return function(value) {
        console.log("val");

      return fn(value);
    };
  }
  
  const double = higherOrder(function(num) {
    console.log("num");
    return num * 2;
  });
  
  console.log(double(5));  // Output: 10
  


  function* count() {
    yield 1;
    yield 20;
    yield 30;
  }
let  counter = count();
console.log(counter.next().value);
console.log(counter.next().value);
console.log(counter.next().value);


const factorial = function fact(n) {
    if (n <= 1) return 1;
    return n * fact(n - 1);  // Using the internal name "fact"
  };
  
  console.log(factorial(5));  // Output: 120
  
