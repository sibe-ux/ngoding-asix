# include <iostream>

using namespace std;
int main(){
    int numb1, numb2, numb3;
    scanf("%d %d %d", &numb1, &numb2, &numb3);
    int match = (numb1 + numb2 + numb3) / 7;
    if (numb1 == match*4 || numb2 == match*4 || numb3 == match*4)
        printf("YA");
    else
        printf("TIDAK");
}