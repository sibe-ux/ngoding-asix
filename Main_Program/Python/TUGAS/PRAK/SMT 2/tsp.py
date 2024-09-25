from itertools import permutations

# graf n cost between node
graph = [#0 mewakili node 1
         [0, 10, 15, 20], 
         #1 mewakili node 2
         [5, 0, 9, 10],
         #2 mewakili node 3
         [6, 13, 0, 12],
         #3 mewakili node 4
         [8, 8, 9, 0]]
# start
s = 0 

# function that count minimum cost
def tsp(graph, s):
  node = []
  for i in range(len(graph)):
    if i != s:
      node.append(i)
  
  min_cost = 999999999
  next_path = permutations(node)
  
  for x in next_path:
    print(x)
    current_cost = 0
    k = s
    for y in x:
      current_cost += graph[k][y]
      k = y
    current_cost += graph[k][0]
    print(f'current_cost: {current_cost}')

    min_cost = min(min_cost, current_cost)
    print(f'min_cost: {min_cost}')
  
  return min_cost


print(f'tsp: {tsp(graph, s)}')

# graph = [#0 mewakili node 1
#          [0, 10, 15, 20], 
#          #1 mewakili node 2
#          [10, 0, 35, 25],
#          #2 mewakili node 3
#          [15, 35, 0, 30],
#          #3 mewakili node 4
#          [20, 25, 30, 0]]

# index >> 0 1 2 3 0
# node >> 1 2 3 4 1
# k = 0 ; y = 1 ; cost = 0 + 10 = 10
# k = 1 ; y = 2 ; cost = 10 + 35 = 45
# k = 2 ; y = 3 ; cost = 45 + 30 = 75
# k = 3 ; y = 0 ; cost = 75 + 20 = 95from itertools import permutations

# graf n cost between node
graph = [#0 mewakili node 1
         [0, 10, 15, 20], 
         #1 mewakili node 2
         [5, 0, 9, 10],
         #2 mewakili node 3
         [6, 13, 0, 12],
         #3 mewakili node 4
         [8, 8, 9, 0]]
# start
s = 0 

# function that count minimum cost
def tsp(graph, s):
  node = []
  for i in range(len(graph)):
    if i != s:
      node.append(i)
  
  min_cost = 999999999
  next_path = permutations(node)
  
  for x in next_path:
    print(x)
    current_cost = 0
    k = s
    for y in x:
      current_cost += graph[k][y]
      k = y
    current_cost += graph[k][0]
    print(f'current_cost: {current_cost}')

    min_cost = min(min_cost, current_cost)
    print(f'min_cost: {min_cost}')
  
  return min_cost


print(f'tsp: {tsp(graph, s)}')

# graph = [#0 mewakili node 1
#          [0, 10, 15, 20], 
#          #1 mewakili node 2
#          [10, 0, 35, 25],
#          #2 mewakili node 3
#          [15, 35, 0, 30],
#          #3 mewakili node 4
#          [20, 25, 30, 0]]

# index >> 0 1 2 3 0
# node >> 1 2 3 4 1
# k = 0 ; y = 1 ; cost = 0 + 10 = 10
# k = 1 ; y = 2 ; cost = 10 + 35 = 45
# k = 2 ; y = 3 ; cost = 45 + 30 = 75
# k = 3 ; y = 0 ; cost = 75 + 20 = 95