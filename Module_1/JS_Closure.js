
//Closures


//Lexical scoping

let name = 'Think';

function greeting() { 
    let message = 'Hi';
    console.log(message + ' '+ name);
}


greeting();




function greeting2() {
    let message = 'Hi';

    function sayHi() {
        console.log(message);
    }

    sayHi();
}

greeting2();


console.log("-----------------");

function makeCounter() {
    let count = 0;

    return {
        increment: function() {
            count += 1;
            return count;
        },
        decrement: function() {
            count -= 1;
            return count;
        },
        getCount: function() {
            return count;
        }
    };
}

const counter3 = makeCounter();
console.log(counter3.increment()); // Output: 1
console.log(counter3.increment()); // Output: 2
console.log(counter3.decrement()); // Output: 1
console.log(counter3.getCount()); // Output: 1


//call Stack

function first() {
    console.log('First function');
    second();
    console.log('Back to first function');
}

function second() {
    console.log('Second function');
    third();
}

function third() {
    console.log('Third function');

    
}

first();

//Output:
//First function
//Second function
//Third function
//Back to first function



//Hoisting 


//call before declare;

// console.log(y); // ReferenceError: Cannot access 'y' before initialization
// let y = 10;


// Under the hood:


var x;
console.log(x); // Outputs: undefined
x = 5;
console.log(x); // Outputs: 5



//Hoisting 


// bar();

// var bar = function() {
//   console.log("Hi");
// };


foo(); 

function foo() {
  console.log("Hello, World!");
}

// Under the hood:

function foo() {
    console.log("Hello, World!");
  }
  
  foo(); // Outputs: "Hello, World!"
  


let now = new Date();
console.log(now);  // Outputs the current date and time


let specificDate = new Date("2024-09-12");
console.log(specificDate);  // Outputs Thu Sep 12 2024 00:00:00 GMT+0000 (UTC)


let specificDate2 = new Date(2024, 8, 12);  // Note: month is 0-indexed, so 8 represents September
console.log(specificDate2);  // Outputs Thu Sep 12 2024 00:00:00 GMT+0000 (UTC)


let fromTimestamp = new Date(1600000000000);
console.log(fromTimestamp);  // Outputs Fri Sep 13 2024 05:26:40 GMT+0000 (UTC)

let unixDate = new Date(0);  // Date for Unix epoch
console.log(unixDate);  // Outputs Thu Jan 01 1970 00:00:00 GMT+0000 (UTC)


let today = new Date();
console.log(today.toString());  // Full date and time string

let year = today.getFullYear();      // Current year (e.g., 2024)
let month = today.getMonth();        // Month (0-11, where 0 is January)
let day = today.getDate();           // Day of the month (1-31)
let weekDay = today.getDay();        // Day of the week (0-6, where 0 is Sunday)
console.log(year);
console.log(month);
console.log(day);
console.log(weekDay);


let date1 = new Date("2024-09-12");
let date2 = new Date("2024-12-25");

console.log(date1 > date2);  // false
console.log(date1 < date2);  // true



