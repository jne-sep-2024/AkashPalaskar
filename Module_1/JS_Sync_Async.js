//its Synchronous 
//example

console.log('Start');

function sayHello() {
    console.log('Hello');
}

sayHello();
console.log('End');



// Asynchronous
//example

console.log('Start');

setTimeout(() => {
    console.log('Hello after 2 seconds');
}, 1000);

console.log('End');




//call back
function fetchData(callback) {
    setTimeout(() => {
        callback('Data received');
    }, 1000);
}

fetchData((data) => {
    console.log(data); 
});


//promise

let promise = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('Data received');
    }, 1000);
});

promise.then((data) => {
    console.log(data); 
}).catch((error) => {
    console.error(error);
});


//async and await

async function fetchData() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve('Data received');
        }, 1000);
    });
}

async function displayData() {
    try {
        let data = await fetchData();
        console.log(data); 
    } catch (error) {
        console.error(error);
    }
}

displayData();


//promise all
//Promise.all allows you to run multiple asynchronous operations in parallel and wait for all of them to complete.

let promise1 = new Promise((resolve) => setTimeout(() => resolve('Data 1'), 1000));
let promise2 = new Promise((resolve) => setTimeout(() => resolve('Data 2'), 1000));

Promise.all([promise1, promise2]).then((results) => {
    console.log(results); 
});


//promise race
//Promise.race returns a promise that resolves or rejects as soon as one of the promises in the iterable resolves or rejects.

let promise3 = new Promise((resolve) => setTimeout(() => resolve('Data 1'), 1000));
let promise4 = new Promise((resolve) => setTimeout(() => resolve('Data 2'), 500));

Promise.race([promise3, promise4]).then((result) => {
    console.log(result); // Output after 0.5 seconds: 'Data 2'
});


//promise all settel
//: Promise.allSettled waits for all promises to complete, regardless of whether they are fulfilled or rejected

let promise5 = new Promise((resolve) => setTimeout(() => resolve('Data 1'), 1000));
let promise6 = new Promise((_, reject) => setTimeout(() => reject('Error 2'), 500));

Promise.allSettled([promise5, promise6]).then((results) => {
    console.log(results);
    // Output: [{status: 'fulfilled', value: 'Data 1'}, {status: 'rejected', reason: 'Error 2'}]
});


//call back 
// //one call back fun depend on another data then this call back logic is difficult to read and main tain and under stand 


// function fetchData(callback2) {
//     setTimeout(() => {
//         console.log('Data fetched');
//         callback2(null, 'data');
//     }, 1000);
// }

// function processData(data, callback2) {
//     setTimeout(() => {
//         console.log('Data processed');
//         callback2(null, 'processedData');
//     }, 1000);
// }

// function saveData(data, callback2) {
//     setTimeout(() => {
//         console.log('Data saved');
//         callback2(null, 'success');
//     }, 1000);
// }



// // // Callback Hell

// fetchData((err, data) => {
//     if (err) {
//         console.error('Error fetching data:', err);
//         return;
//     }

//     processData(data, (err, processedData) => {
//         if (err) {
//             console.error('Error processing data:', err);
//             return;
//         }

//         saveData(processedData, (err, result) => {
//             if (err) {
//                 console.error('Error saving data:', err);
//                 return;
//             }

//             console.log('Operation completed:', result);
//         });
//     });
// });


// promise one promis depend on another by promise chaining
function fetchData2() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Data fetched');
            resolve('data');
        }, 1000);
    });
}

function processData2(data) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Data processed');
            resolve('processedData');
        }, 1000);
    });
}

function saveData2(data) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Data saved');
            resolve('success');
        }, 1000);
    });
}



function promisefun(data){
    return new Promise((seccess,err)=>{
    setTimeout(()=>{console.log("in promise fun");
        seccess('success')
    },1000);
    })
} 
promisefun("ash").then(data=>console.log(data));

// Chaining Promises
fetchData2()
    .then(data => processData2(data))
    .then(processedData => saveData2(processedData))
    .then(result => console.log('Operation completed:', result))
    .catch(err => console.error('Error:', err));


//promise in promise by asycn and await
    function fetchData() {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log('Data fetched');
                resolve('data');
            }, 1000);
        });
    }
    
    function processData(data) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log('Data processed');
                resolve('processedData');
            }, 1000);
        });
    }
    
    function saveData(data) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log('Data saved');
                resolve('success');
            }, 1000);
        });
    }
    
    async function performOperations() {
        try {
            const data = await fetchData();
            const processedData = await processData(data);
            const result = await saveData(processedData);
            console.log('Operation completed:', result);
        } catch (err) {
            console.error('Error:', err);
        }
    }
    
    performOperations();
    


