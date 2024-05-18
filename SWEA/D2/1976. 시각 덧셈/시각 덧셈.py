t = int(input())

for test_case in range(1,t+1):
    a,b,c,d = map(int,input().split())
    answer = [0,0]
    answer[0] = a+c
    answer[1] = b+d
    if (b+d)>=60:
        answer[1] -= 60
        answer[0] += 1
    if answer[0]>12:
        answer[0] -= 12
    print(f"#{test_case} {answer[0]} {answer[1]}")