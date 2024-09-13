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


//loop 
var decoration = {
    color: 'red'
};

var circle = Object.create(decoration);
circle.radius = 10;


for(const prop in circle) {
    console.log(prop);
}

console.log(circle);


//for in array 

const items = [10 , 20, 30];
let total = 0;

for(const item in items) {
    console.log(item); 

    total += items[item];
}
console.log(total); 

// somewhere else
Array.prototype.foo = 100;

const items2 = [10, 20, 30];
let total2 = 0;

for (var prop in items2) {
  console.log({ prop, value: items2[prop] });
  total2 += items2[prop];
}
console.log(total2);


var arr = [];
// set the third element to 3, other elements are `undefined`
arr[2] = 3; 

for (let i = 0; i <arr.length; i++) {
    console.log(arr[i]);    
}
// diff of for ....in 
for (const key in arr) {
    console.log(arr[key]);
}


//callback hell

function fetchData(callback2) {
    setTimeout(() => {
        console.log('Data fetched');
        callback2(null, 'data');
    }, 1000);
}

function processData(data, callback2) {
    setTimeout(() => {
        console.log('Data processed');
        callback2(null, 'processedData');
    }, 1000);
}

function saveData(data, callback2) {
    setTimeout(() => {
        console.log('Data saved');
        callback2(null, 'success');
    }, 1000);
}



// // Callback Hell

fetchData((err, data) => {
    if (err) {
        console.error('Error fetching data:', err);
        return;
    }

    processData(data, (err, processedData) => {
        if (err) {
            console.error('Error processing data:', err);
            return;
        }

        saveData(processedData, (err, result) => {
            if (err) {
                console.error('Error saving data:', err);
                return;
            }

            console.log('Operation completed:', result);
        });
    });
});




//enumerable properties
//by default enumareable property is tru so we can itrate every properties of array or obj if we make the proeprtiey enummarable false
// then it will not itrate

const person3 = {
    firstName: 'John',
    lastName: 'Doe'
  };
  
  person3.age = 25;
  
  for (const key in person3) {
    console.log(key);
  }
  
  //
  const person5 = {
    firstName: 'John',
    lastName: 'Doe'
  };
  
  person5.age = 25;
  
  Object.defineProperty(person5, 'age2', {
    enumerable: false,
    value: '123'
  });
  
  for (const key in person5) {
    console.log(key);
  }
  
  
  console.log(person5.propertyIsEnumerable('firstName')); // => true
  console.log(person5.propertyIsEnumerable('lastName')); // => true
  console.log(person5.propertyIsEnumerable('age')); // => true
  console.log(person5.propertyIsEnumerable('age2')); // => false
  
  
  //own properties of obj

  const own = {
    firstName: 'John',
    lastName: 'Doe'
};

const inherited = Object.create(own, {
    job: {
        value: 'JS Developer',
        enumerable: true
    }
});

console.log("own properties or not , job , firstame, lastname , ssh")
console.log(inherited.hasOwnProperty('job')); // => true
console.log(inherited.hasOwnProperty('firstName')); // => false
console.log(inherited.hasOwnProperty('lastName')); // => false
console.log(inherited.hasOwnProperty('ssn')); // => false



function guys3(firstname,lastname){
    return {
        firstname:firstname,
        lastname:lastname,
        getfulname(){
            return firstname+' '+lastname;
        },
    }
}
let guys4=guys3("think","itivre");
console.log(guys4.firstname);
console.log(guys4.lastname);
console.log(guys4.getfulname());




function createGuy(firstname,lastname){
    return {
        firstname:firstname,
        lastname:lastname,
    }

}

let guyAction ={
    getfulnameguys(){

        return this.firstname +' '+ this.lastname;
    }
}

let createg=createGuy("guy","created");

createg.getfulnameguys = guyAction.getfulnameguys;
console.log(createg.getfulnameguys());


var personActions = {
    getFullName() {
      return this.firstName + ' ' + this.lastName;
    },
  };
  
  function createPerson(firstName, lastName) {
    let person = Object.create(personActions); //
    person.firstName = firstName;
    person.lastName = lastName;
    return person;
  }


  let destructurePerson ={
    firstName:"js",
    lastName:"programing"
  }

  let {firstName,lastName} = destructurePerson;
  console.log(firstName+" "+lastName) 

  let employee = {
    id: 1001,
    name: {
        empFirst: 'John',
        empLast: 'Doe'
    }
};

let {
    name:{ 
        empFirst,
        empLast
        }} = employee;

console.log(empFirst+" "+empLast)



let display = (person) => console.log(`${person.firstName} ${person.lastName}`);

let displayPerson = {
    firstName: 'display',
    lastName: 'person'
};

display(displayPerson);



//Optional Chaining Operator



function getcar(id){
    if(id<0){
        return null;
    }

    return {
        id:id,
        name:"car",
        engine:"powerfullEngine",
        tire:{
            company:"MRF",
            grip:"goodGrip"
        },
        getcarProfile(){
return this.name+" "+this.engine;
        }
    }

}

let carDetails = getcar(2);
let profileName=carDetails ?. name; //  send undefine if user is null
console.log(profileName);

let carprofile= carDetails.getcarProfile ?.();

console.log(carprofile);


const data = [
    { name: 'Alice' },
    { name: 'Bob' }
];

console.log(data[0]?.name); 
console.log(data[1]?.name); 
console.log(data[2]?.name); 


