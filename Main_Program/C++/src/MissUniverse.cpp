#include <iostream>

int main(){
    int n;
    std::cin >> n;

    int result = 0;
    for (int x = 1; x <= n; x++){
        int hasil;
        std::cin >> hasil;
        if (hasil > result){
            result = hasil;
        }
    }
    std::cout << result;
}