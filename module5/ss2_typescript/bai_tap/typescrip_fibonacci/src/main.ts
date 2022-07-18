function isFibonacci(number: number): number {
    if(number==0){
        return 0;
    }
    if(number==1){
        return 1;
    }
    return isFibonacci(number-1)+isFibonacci(number-2)
}

let sum  = 0;
let sizeNumber = 10;

for (let i = 0; i<sizeNumber; i++){
   sum+= isFibonacci(i);
    console.log(isFibonacci(i))
}
console.log(`sum = `+ sum);
