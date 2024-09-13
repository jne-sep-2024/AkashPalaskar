//Arithmatic + - * / 

let num = 20+2;
console.log("Addition of 20 and 2");

console.log(num);

let num2 = 20 - 2;
console.log("Subtraction of 20 and 2");
console.log(num2);

let num3 = 20 *2;
console.log("Multiplication of 20 and 2");
console.log(num3);

let num4 = 20 / 2;
console.log("DEvision of 20 and 2");
console.log(num4);

// Remainder Operator

let remainder = 20 % 2;
console.log("Remainder of 20 and 2");
console.log(remainder);

let remainder2 = -5% 3;
console.log("Remainder of -5 and 3");
console.log(remainder2);

let remainder3 = -5% -3;
console.log("Remainder of -5 and -3");
console.log(remainder3);


let remainder4 = 21% 2;
if (remainder4 == 0){
console.log("num 21 is even");
}
else{
    console.log("num 21 is odd");

}


//  Assignment Operators

let a = 10;
let b = a;
console.log(b);
b = b+ 1;
console.log(b);

b+=1;
console.log(b);

b -= 1;
console.log(b);

b *=2;
console.log(b);

b /=2;
console.log(b);

let c= 20;
console.log(c);

console.log(a);

a =c=b;
console.log(a);
console.log(b);
console.log(c);


// Unary Operators

let x = 10;
let y = +x;

console.log(y);

//Suppose you have a product object with the toString() method as follows:


let person = {
    name: 'John',
    toString: function () {
      return '25';
    },
  };
  
  console.log(+person);

  let person2 = {
    name: 'John',
    toString: function () {
      return '25';
    },
    valueOf: function () {
      return '30';
    },
  };
  
  console.log(+person2);
  
  let weight = 90;
  console.log(`old weight ${weight}`); 

let newWeight = weight++ + 5;


console.log(`new weight ${newWeight}`); 
console.log(`old weight ${weight}`); 

//Comparison Operators

let com1 = 10;
let com2 = 20;
console.log("com 1 is less than com 2 ");
console.log(com1 <com2);


console.log("com 1 is greater than com 2 ");
console.log(com1 >com2);

console.log("com 1 is less than or equal to com 2");
console.log(com1 >=com2);

console.log("com 1 is greater than or equal to com 2");
console.log(com1 >=com2);

console.log("com 1 is equal to com 2");

console.log(com1 ==com2);

console.log("com 1 is not equal to com 2");
console.log(com1 !=com2);

console.log("null == undifine");
console.log(null == undefined);

console.log("NaN = =NaN");
console.log(NaN == NaN); // false

console.log("'10' == 10  not strict equal" );
console.log("10" == 10); // true

console.log("'10' === 10 strict equal");
console.log("10" === 10); // false



//Logical Operators

//NOT
let eligible = false,
    required = true;

console.log(!eligible);
console.log(!required);


//AND
let f = true;
let g = false;

let result = f&& g;
console.log(result);




//OR
let result2 = f || g;
console.log(result);


//Logical Assignment Operators

/*The logical OR assignment :- 
operator (||=) accepts two operands and assigns the right operand to the left operand if the left operand is falsy:
*/
let X =10;
let Y = 20;
X ||= Y;
console.log(X);

/* Logical AND assignment operator:-
x &&= y;
The logical AND assignment operator only assigns y to x if x is truthy:
*/


X &&= Y;
console.log(X);

//The nullish coalescing assignment operator only assigns y to x if x is null or undefined:4let
let p;
let l = 22;
p ??= l;
console.log(p);

//Exponentiation Operator

let result4 = Math.pow(2,2);
console.log(result4); 

result4 = Math.pow(2,3);
console.log(result4); 


let result5 = 2 ** 2;
console.log(result5); 

result5 = 2 ** 3;
console.log(result5); 


let z = 2;
z **= 4;
console.log(z); 
