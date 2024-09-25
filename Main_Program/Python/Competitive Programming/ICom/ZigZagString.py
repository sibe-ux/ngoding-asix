def zigZagConcat(s, n):
	if (n <= 1):
		return s
	
	result = ""

	for rowNum in range(n):
		i = rowNum
		up = True
		
		while(i < len(s)):
			result += s[i]
			
			if (rowNum == 0 or rowNum == n - 1):
				i += (2 * n - 2)
			else:
				if(up):
					i += (2 * (n - rowNum) - 2)
				else:
					i += rowNum * 2
				up ^= True
	
	return result

str = input()
n = int(input())
print(zigZagConcat(str, n))