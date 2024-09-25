minutes = eval(input())
days = minutes // 1440
hours = (minutes % 1440) // 60
minutes = (minutes % 1440) % 60
print(days)
print(hours)
print(minutes)