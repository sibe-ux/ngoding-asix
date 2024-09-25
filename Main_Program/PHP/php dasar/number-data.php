<?php

echo "decimal : ";
var_dump(1234);

echo "octal : ";
var_dump(0123);

echo "hexadecimal : ";
var_dump(0x1A);

echo "binary : ";
var_dump(0b111111);

echo "underscore di number : ";
var_dump(1_234_567);

// flaoting point
echo "floating point : ";
var_dump(12.34);

echo "floating point dengan E notation : (1.7 x 1000) : ";
var_dump(1.7e3);

echo "floating point dengan E notation minus : (1.7 x 0.001) : ";
var_dump(1.7e-3);

echo "undersocre di floating point : ";
var_dump(1_234.567);

// integer overflow
echo "integer overflow : ";
var_dump(PHP_INT_MAX + 1);