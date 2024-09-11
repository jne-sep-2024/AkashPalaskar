let person={
    firstname:"visual",
    lastname:"studio"
}
// person.greet=function (){
//     console.log("hello");
// }

console.log(person.greet);
// person.greet();

console.log(person);
// person.greet();

function greets() {
    console.log('Hello, World!');
}

person.greet =greets;
person.greet();


let person2 ={
    firstname:"visual",
    lastname:"studio",
    greet:function(){
        console.log("hello");
    },
    fullname:function(){
        return this.firstname+" "+this.lastname;
    }
}
console.log("--------------");
person2.greet();
console.log(person2.fullname());
console.log("--------------");


//constructor funcation

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;

    this.getFullName = function () {
        return this.firstName + " " + this.lastName;
    };
}


let person4  = new Person("visual","studio");
console.log(person4);
console.log(person4.getFullName());

console.log("--------------");

function Personfun(firstName, lastName) {
    if (!new.target) {
        throw Error("Cannot be called without the new keyword");
    }

    this.firstName = firstName;
    this.lastName = lastName;
}

// let person5 = Personfun("think", "trainee");

// console.log(person5.firstName);

console.log("--------------");

function Personfun2(firstName, lastName) {

    console.log(new.target);
    console.log("--------------");

    if (!new.target) {
return new Personfun2(firstName,lastName);
    }

    this.firstName = firstName;
    this.lastName = lastName;
}

let person6 = Personfun2("think", "study");

console.log(person6.firstName);


function Person5(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  Person5.prototype.getFullName = function () {
    return this.firstName + ' ' + this.lastName;
  };
  
  let p1 = new Person('thinki', 'tive');
  let p2 = new Person5('thinki', 'tive');
  
  console.log(p1.getFullName());
  console.log(p2.getFullName());

//ES6 has introduce class keyword

  class Person8 {
	constructor(firstName, lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	getFullName() {
		return this.firstName + " " + this.lastName;
	}
}

let p12 = new Person8('thinking', 'soo much');
let p22 = new Person8('thinking', 'too much');

console.log(p12.getFullName());
console.log(p22.getFullName());

let guys = {
    name: "John Doe",
    greet: function () {
        return "Hi, I'm " + this.name;
    }
};
console.log(guys.toString());

console.log(guys.__proto__);
console.log(Object.prototype);

let guysObj= Object.create(guys);
guysObj.name="think";
guysObj.teach = function (subject) {
    return "I can teach " + subject;
}
let sub = guysObj.teach ("java");
console.log(sub);


let counter = {
    count: 0,
    next: function () {
      return ++this.count;
    },
  };
  
  counter.next();
  console.log(counter.count);

//   console.log(this === window); // true

//   this.color= 'Red';
// console.log(window.color); 


let cars = {
    brand: 'Honda',
    getBrand: function () {
        return this.brand;
    }
}

console.log(cars.getBrand()); 

let car = {
    brand: 'Honda',
    getBrand: function () {
        return this.brand;
    }
}

let bike = {
    brand: 'Harley Davidson'
}

let brand = car.getBrand.bind(bike);
console.log(brand());

//obj properties

let child={};
child.age=2;
console.log(child.age);
delete child.age;
console.log(child.age);



// 'use strict'

'use strict';


let child2={};
// child2.age=2;
// console.log(child2.age);


Object.defineProperty(child2, 'age', {
    configurable: false,
    value: '20'
});
console.log(child2.age);
delete child2.age;
console.log(child2.age);


let person9 = {
    firstName: 'thinki',
    lastName: 'tive'
};


let descriptor = Object.getOwnPropertyDescriptor(person9, 'firstName');

console.log(descriptor);
