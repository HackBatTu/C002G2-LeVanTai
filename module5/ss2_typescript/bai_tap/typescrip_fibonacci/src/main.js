function isFibonacci(number) {
    if (number == 0) {
        return 0;
    }
    if (number == 1) {
        return 1;
    }
    return isFibonacci(number - 1) + isFibonacci(number - 2);
}
var sum = 0;
var sizeNumber = 10;
for (var i = 0; i < sizeNumber; i++) {
    sum += isFibonacci(i);
    console.log(isFibonacci(i));
}
console.log("sum = " + sum);
