#include <iostream>
#include <cstdio>

int main(){
    int n;
    scanf("%d", &n);

    int result = 0;
    int index = n;
    while (index > 0){
        if (index == n){
            int numb;
            scanf("%d", &numb);
            result = numb;
            index--;
        }else{
            int numb;
            scanf("%d", &numb);
            if (numb % result == 0){
                result = numb;
                index--;
            } else if (result % numb == 0){
                index--;
            } else{
                result = numb * result;
                index--;
            }
        }
    ;
}
    printf("%d", result);
    return 0;
}