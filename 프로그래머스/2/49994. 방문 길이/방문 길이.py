def solution(dirs):
    visited = []
    x,y = 0,0
    answer = 0
    for d in dirs:
        if d == "U":
            if -5<=y+1<=5:
                y += 1
                if [x,y-1,x,y] not in visited:
                    visited.append([x,y-1,x,y])
                    visited.append([x,y,x,y-1])
                    answer += 1
        elif d == "D":
            if -5<=y-1<=5:
                y -=1
                if [x,y+1,x,y] not in visited:
                    visited.append([x,y+1,x,y])
                    visited.append([x,y,x,y+1])
                    answer += 1
        elif d=="R":
            if -5<=x+1<=5:
                x += 1
                if [x-1,y,x,y] not in visited:
                    visited.append([x-1,y,x,y])
                    visited.append([x,y,x-1,y])
                    answer += 1
        elif d=="L":
            if -5<=x-1<=5:
                x -=1
                if [x+1,y,x,y] not in visited:
                    visited.append([x+1,y,x,y])
                    answer += 1
                    visited.append([x,y,x+1,y])
    return answer
                    
                    
                    