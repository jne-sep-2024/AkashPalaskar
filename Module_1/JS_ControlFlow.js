//JavaScript if

let age = 18;
if (age >= 18) {
  console.log('You can sign up');
}

let age2 = 10;

if (age2 >= 10) {
    console.log('You can sign up');
  }

let age3 = 16;
let state = 'CA';

//nested if

if (state == 'CA') {
  if (age3 >= 16) {
    console.log('You can drive.');
  }
}

//if else

let age4 = 17;

if (age4 >= 18) {
  console.log('You can sign up.');
} else {
  console.log('You must be at least 18 to sign up.');
}

let age5 = 18;

if (age5 >= 18) {
  console.log('You can sign up.');
} else {
  console.log('You must be at least 18 to sign up.');
}


let age6 = 16;
let country = 'India';

if (age6>= 16 && country === 'India') {
  console.log('You can get a driving license.');
} else {
  console.log('You are not eligible to get a driving license.');
}

// if else if

let month = 6;
let monthName;

if (month == 1) {
  monthName = 'Jan';
} else if (month == 2) {
  monthName = 'Feb';
} else if (month == 3) {
  monthName = 'Mar';
} else if (month == 4) {
  monthName = 'Apr';
} else if (month == 5) {
  monthName = 'May';
} else if (month == 6) {
  monthName = 'Jun';
} else if (month == 7) {
  monthName = 'Jul';
} else if (month == 8) {
  monthName = 'Aug';
} else if (month == 9) {
  monthName = 'Sep';
} else if (month == 10) {
  monthName = 'Oct';
} else if (month == 11) {
  monthName = 'Nov';
} else if (month == 12) {
  monthName = 'Dec';
} else {
  monthName = 'Invalid month';
}
console.log(monthName);


//Ternary Operator

let age7 = 16;
let message;

age7 >= 16 ? message = 'You can drive.' : message = 'You cannot drive.';

console.log(message);

let speed = 90;
let message2 = speed >= 120 ? 'Too Fast' : speed >= 80 ? 'Fast' : 'OK';

console.log(message2);


//switch case


let day = 3;
let dayName;

switch (day) {
  case 1:
    dayName = 'Sunday';
    break;
  case 2:
    dayName = 'Monday';
    break;
  case 3:
    dayName = 'Tuesday';
    break;
  case 4:
    dayName = 'Wednesday';
    break;
  case 5:
    dayName = 'Thursday';
    break;
  case 6:
    dayName = 'Friday';
    break;
  case 7:
    dayName = 'Saturday';
    break;
  default:
    dayName = 'Invalid day';
}

console.log(dayName); 

let year = 2016;
let month2 = 2;
let dayCount;

switch (month2) {
  case 1:
  case 3:
  case 5:
  case 7:
  case 8:
  case 10:
  case 12:
    dayCount = 31;
    break;
  case 4:
  case 6:
  case 9:
  case 11:
    dayCount = 30;
    break;
  case 2:
    // leap year
    if ((year % 4 == 0 && !(year % 100 == 0)) || year % 400 == 0) {
      dayCount = 29;
    } else {
      dayCount = 28;
    }
    break;
  default:
    dayCount = -1; // invalid month
}

console.log(dayCount); 



//whille

let count = 1;
while (count < 10) {
    console.log(count);
    count +=2;
}

//do while
let count1 = 0;
do {
  console.log(count1);
  count1++;
} while (count1 < 5)

console.log("------");
let count2 = 0;
do{
    console.log(count2);
    count2++;
} while (count2 < 5)

    //completed till do while


  //for loop

  for (let i = 0 ; i < 5 ; i++){
    console.log(i);
  }
  console.log("---------------");


  let names = "think";
for (let j = 0 ; j < names.length; j++){
console.log(names[j]);
}

//break 
console.log("---------------");

for (let j = 0 ; j < 5; j++){
  console.log(j);
  if(j==2){
    break;
  }
  }
  console.log("---------------");


for(let i = 0;i<5;i++){
    for (let j = 0 ; j < 5; j++){
      console.log("j "+ j);
      if(i==2){
        break ;
      }
      }
    }

    console.log("---------------");

  outter: for(let i = 0;i<5;i++){
  for (let j = 0 ; j < 5; j++){
    console.log("j "+ j);
    if(i==2){
      break outter;       //outter is lable to the first loop 
    }
    }
  }

  console.log("---------------");

  //continue

  for (let i = 0; i < 10; i++) {
    if (i % 2 === 0) {
      continue;
    }
    console.log(i);
  }

  console.log("---------------");

  for (let i = 1; i <= 3; i++) {
    for (let j = 1; j <= 3; j++) {
      console.log(i, j);
    }
  }
  console.log("---------------");

  outer: for (let i = 1; i <= 3; i++) {
    for (let j = 1; j <= 3; j++) {
      if(i==2) continue outer;
      console.log(i, j);
    }
  }

  //comma operator
  let result = (10, 30);
console.log(result);
let result2 = (30,10);
console.log(result2);
