

try{  
     /*
    prompt is not a valid construct in the Node.js runtime ( running in through VSCode). It will only work in browser-based JavaScript engines.
    "require("prompt-sync")"have to be isntalled if the code is running in node.js envirmonet
    const prompt is declared if the runtime env is Node.js
    */
    // const prompt = require("prompt-sync")();  
    // ask users to enter the whole mathematical expression in ONE line and stored in a String Variable.
    const enteredOperation = prompt("Enter two numbers seperated by arithmetic operators (+,-,*,/): ");
    
    //declaring variables for the numbers and the result
    let numbers=[]
    //create array of the operators types
    const validOperators = ['+','-','*','/'];

    function calculator(enteredOperation){
        let operater_index=[];
        let operatorEnteredValue=[];

        //counter to check the number of entered validOperators
        let operatorsCounter = 0;
        
        //loops to extract operators and their indices in the expression and store them in an array
        for (let j=1; j < enteredOperation.length; j++){
            for(let i = 0; i < validOperators.length; i++){
                if(validOperators[i] == enteredOperation[j]){
                    operater_index[operatorsCounter] = j;
                    operatorEnteredValue[operatorsCounter] = enteredOperation[j];
                    ++operatorsCounter;
                }
               }
          
            }

        //To check that each two numbers is separated by only one operator, and there is no two consecutive operators.
        for(let i =1;i<operater_index.length;i++){
            if( operater_index[i]==operater_index[i-1]+1)
             throw "Please enter one operator between numbers"
            }
        
        //extract the  numbers from the entered string using the index of the operator
        for (let i=0; i< ((operater_index.length)+1);i++){
            if (i==0){
                numbers [i]= Number(enteredOperation.slice(0,operater_index[i]));
            }
            else{
                if((enteredOperation.slice(operater_index[i-1]+1,operater_index[i]))!=""){ 
                    numbers[i] =   Number((enteredOperation.slice(operater_index[i-1]+1,operater_index[i])));
                }
            }
        }

        // Loop to check each number follows the requirment 
        // To check if the number is entered
        // To check if the number is between 1 and 10
        //  To check if the number is Integer

        for (let i=0; i<numbers.length;i++){
            // To check if the number is entered
            if(isNaN(numbers[i])){
                throw "Only numbers are allowed"
            } 
            if((numbers[i]<0)|| (numbers[i]>10)){
                console.log("zaha "+numbers[i]);
                throw "Please enter number from 1 to 10 Only"
            }
            //  To check if the number is Integer
            if (!(Number. isInteger(numbers[i]) )){
                throw "Only Integer Numbers are allowed"
            }
        }
        //  To check no more than three numbers are entered
        if(numbers.length>4){
            throw "Please no more than three number"
        }
        else if(numbers.length>1&&operater_index.length>0){
        // calculate the operations with the specific order
        // multiplication and division are performed first, which is happens from left to right.

        for(let i=0; i<operatorEnteredValue.length;i++){
            if(operatorEnteredValue[i]=="*"){
                numbers[i+1]=numbers[i]*numbers[i+1];
                delete numbers[i];
            }
            else if(operatorEnteredValue[i+1]=="*"){
                numbers[i+2]=numbers[i+1]*numbers[i+2];
                delete numbers[i+1];
                i++;
            }
            else  if(operatorEnteredValue[i]=="/"&&numbers[i+1]!=0){
                numbers[i+1]=numbers[i]/numbers[i+1];
                delete numbers[i];
            }
            // checks for division by 0 and throw error
            else if( operatorEnteredValue[i]=="/"&&numbers[i+1]==0)
                throw "Can not divide on zero, Please enter valid expression"
            
            }
          
        // And then we have addition and subtraction, which also happens from left to right.
        for(let i=0; i<operatorEnteredValue.length;i++){
            let count=1;
            
            // After the divion and multiplication, some items in the numberd array are empty 
            // So the loop is to detect the next item not NaN items at index i to be added or subtracted from the 
            for(j=i+1;j<operatorEnteredValue.length;j++){
                if((isNaN(numbers[j]))){
                    count++;
                }
                else{
                    break;
                }
            }   

            if(operatorEnteredValue[i]=="-"){
                numbers[i+count]=numbers[i]-numbers[i+count];
                delete numbers[i]
                count=1;
            }
            else if(operatorEnteredValue[i]=="+"){
                numbers[i+count]=numbers[i]+numbers[i+count];
                delete numbers[i]
                count=1;
                }
            }

       }
       else
       throw "Please enter valid expression"

    return enteredOperation+" =  "+String(numbers[numbers.length-1])
}
// call the calculator function
console.log(calculator(enteredOperation));
}
catch(error){
    console.log(error);
}
    