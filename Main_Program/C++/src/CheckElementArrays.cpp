#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int arr[] = {5, 3, 7, 6, 8, 2};
    int target = 7;

    int n = sizeof(arr) / sizeof(*arr);

    bool exists = std::find(arr, arr + n, target) != arr + n;
    if (exists)
    {
        std::cout << "Element found";
    }
    else
    {
        std::cout << "Element not found";
    }

    return 0;
}