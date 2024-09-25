#include <iostream>

int main()
{
    int awal;
    std::cin >> awal;
    int find;
    std::cin >> find;

    int findNumber[find];
    for (int x = 0; x < find; x++)
    {
        std::cin >> findNumber[x];
    };

    for (int x = 1; x <= awal; x++)
    {
        int target = x;

        int n = sizeof(findNumber) / sizeof(*findNumber);

        bool exists = std::find(findNumber, findNumber + n, target) != findNumber + n;
        if (!exists)
        {
            std::cout << x << " ";
        }
    }
}