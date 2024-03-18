def solution(keyinput, board):
    limit_x, limit_y = (board[0]-1)//2, (board[1]-1)//2
    
    def is_valid(x,y):
        return -limit_x<=x<=limit_x and -limit_y<=y<=limit_y
    
    x, y = 0, 0
    
    for key in keyinput:
        if key == "left":
            if is_valid(x-1,y):
                x -= 1
        if key == "right":
            if is_valid(x+1,y):
                x += 1
        if key == "up":
            if is_valid(x,y+1):
                y+=1
        if key == "down":
            if is_valid(x,y-1):
                y -= 1
    
    return [x,y]