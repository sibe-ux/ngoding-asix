#include <iostream>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    int a;
    scanf("%d", &a);
    int b;
    scanf("%d", &b);

    int result;
    for (int x = 1;x <= n;x++){
        if (x % a == 0 || x % b == 0){
            result += 1;
        }
    }
    printf("%d", result);
}