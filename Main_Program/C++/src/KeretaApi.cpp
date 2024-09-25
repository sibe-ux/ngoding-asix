#include <cstdio>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int numb;
    // printf("Enter a number: ");
    scanf("%d", &numb);
    int arr_numb[numb];
    int index = numb;
    while (index > 0)
    {
        int number;
        scanf("%d", &number);
        arr_numb[numb-index] = {number};
        index--;
    }
    int n = sizeof(arr_numb) / sizeof(arr_numb[0]);
    sort(arr_numb, arr_numb + n, greater<int>());

    for (int i = 0; i < n; i++)
    if (i == n - 1){
        cout << arr_numb[i];
    } else{
        cout << arr_numb[i] << ",";
    }
    return 0;
}