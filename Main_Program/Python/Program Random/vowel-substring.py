def is_vowel(char):
    return char.lower() in "aeiou"


def findSubstring(s, k):
    if k > len(s):
        return "Not found!"

    max_vowels = 0
    max_substring = ""
    window_vowels = 0

    for i in range(len(s)):
        if is_vowel(s[i]):
            window_vowels += 1
        if i >= k:
            if is_vowel(s[i - k]):
                window_vowels -= 1
        if i >= k - 1 and window_vowels > max_vowels:
            max_vowels = window_vowels
            max_substring = s[i - k + 1 : i + 1]

    if max_vowels == 0:
        return "Not found!"

    return max_substring


# Input
s = input().strip()
k = int(input().strip())

# Output
result = findSubstring(s, k)
print(result)
