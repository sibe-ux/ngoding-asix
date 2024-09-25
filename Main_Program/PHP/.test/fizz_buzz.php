<?php

for ($x = 1; $x <= 30; $x++) {
    if ($x % 3 == 0 && $x % 5 == 0) {
        echo "FizzBuzz\n";
    } else if ($x % 3 == 0) {
        echo "Fizz\n";
    } else if ($x % 5 == 0) {
        echo "Buzz\n";
    } else {
        echo $x . "\n";
    }
}
