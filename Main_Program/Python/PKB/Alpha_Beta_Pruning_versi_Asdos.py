import math
MAX, MIN = math.inf, -math.inf

def minimax(depth, nodeIndex, isMax, values, alpha, beta, targetDepth):
    if depth == targetDepth:
        return values[nodeIndex]
    if isMax:
        best = MIN
        for i in range(2):
            value = minimax(depth + 1, nodeIndex * 2 + i, False,values, alpha, beta, targetDepth)
            best = max(best, value)
            alpha = max(alpha, best)
            if beta <= alpha:
                break
        return best
    else:
        best = MAX
        for i in range(2):
            value = minimax(depth + 1, nodeIndex * 2 + i, True,
                            values, alpha, beta, targetDepth)
            best = min(best, value)
            beta = min(beta, best)
            if beta <= alpha:
                break
        return best
    
values = [8, 7, 3, 9, 9, 8, 2, 4, 1, 8, 8, 7, 9, 9, 3, 4]
targetDepth = math.log(len(values), 2)

optimalValue = minimax(0, 0, True, values, MIN, MAX, targetDepth)
print("Optimal values is", optimalValue)


# MAX, MIN = 1000, -1000

# def minimax(kedalaman, nodeIndex, isMax, values, alpha, beta):
#     if kedalaman == 4:
#         return values[nodeIndex]
#     if isMax:
#         best = MIN
#         for i in range(0, 2):
#             val = minimax(kedalaman + 1, nodeIndex * 2 + i, False, values, alpha, beta)
#             best = max(best, val)
#             alpha = max(alpha, best)
#             if beta <= alpha:
#                 break
#         return best
#     else:
#         best = MAX
#         for i in range(0, 2):
#             val = minimax(kedalaman + 1, nodeIndex * 2 + i, True,values, alpha, beta)
#             best = min(best, val)
#             beta = min(beta, best)
#             if beta <= alpha:
#                 break
#         return best
        
# if __name__=="__main__":
#     values = [8, 7, 3, 9, 9, 8, 2, 4, 1, 8, 8, 7, 9, 9, 3, 4]
#     print("Optimal valuenya adalah :", minimax(0, 0, True,values, MIN, MAX))