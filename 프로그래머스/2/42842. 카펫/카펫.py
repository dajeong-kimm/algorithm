def solution(brown, yellow):
    divisor = []
    for i in range(1,int((yellow)**(0.5))+1):
        if yellow % i == 0:
            divisor.append(i)
    
    for div in divisor:
        y = div+2
        x = (yellow//div)+2
        if (x*y) == (brown+yellow):
            return [x,y]