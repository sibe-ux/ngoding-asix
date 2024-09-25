BoardPlace = {'1': ' ' , '2': ' ' , '3': ' ' ,
            '4': ' ' , '5': ' ' , '6': ' ' ,
            '7': ' ' , '8': ' ' , '9': ' ' }
 
placement = []
for x in BoardPlace:
    placement.append(x)
 
def printBoard(place_drop):
    print(place_drop['1'] + '|' + place_drop['2'] + '|' + place_drop['3'])
    print('-+-+-')
    print(place_drop['4'] + '|' + place_drop['5'] + '|' + place_drop['6'])
    print('-+-+-')
    print(place_drop['7'] + '|' + place_drop['8'] + '|' + place_drop['9'])
 
def game():
    turn = 'X'
    count = 0
    for i in range(10):
        printBoard(BoardPlace)
        print(f"It's your turn, {turn}.Move to which place?")
        move = input()        
        if BoardPlace[move] == ' ':
            BoardPlace[move] = turn
            count += 1
        else:
            print("That place is already filled.\nMove to which place?")
            continue
        
        if count >= 5:
            if BoardPlace['3'] == BoardPlace['6'] == BoardPlace['9'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")
                break 
            elif BoardPlace['1'] == BoardPlace['2'] == BoardPlace['3'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")
                break
            elif BoardPlace['2'] == BoardPlace['5'] == BoardPlace['8'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")
                break
            elif BoardPlace['4'] == BoardPlace['5'] == BoardPlace['6'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")
                break
            elif BoardPlace['7'] == BoardPlace['8'] == BoardPlace['9'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")                
                break
            elif BoardPlace['1'] == BoardPlace['5'] == BoardPlace['9'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")
                break 
            elif BoardPlace['7'] == BoardPlace['5'] == BoardPlace['3'] != ' ': 
                printBoard(BoardPlace)
                print("\nGame Over.\n")                
                print(turn + " won")
                break
            elif BoardPlace['1'] == BoardPlace['4'] == BoardPlace['7'] != ' ': 
                print("\nGame Over.\n")                
                print(turn + " won")
                break
 
        if count == 9:
            print("\nGame Over.\n")                
            print("MATCH DRAW!!")
        if turn =='X':
            turn = 'O'
        else:
            turn = 'X'        

    restart = input("Play Again?(y/n)")
    if restart == "y" or restart == "Y":  
        for key in placement:
            BoardPlace[key] = " "
        game()
 
if __name__ == "__main__":
    game()