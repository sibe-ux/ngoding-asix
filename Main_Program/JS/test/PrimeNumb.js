for(var x = 1;x <= 30;x++){
    var isPrime = true;
    for(var y = 2;y < x;y++){
        if(x % y == 0){
            isPrime = false;
            break;
        } 
    }

    if(isPrime){
        console.log(x);
    }
}