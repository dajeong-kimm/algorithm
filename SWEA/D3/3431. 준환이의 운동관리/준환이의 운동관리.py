t = int(input())

for test_case in range(1,t+1):
    l,u,x = map(int,input().split())
    if l<=x<=u:
        answer = 0
    elif x<l:
        answer = l-x
    else:
        answer = -1
    print(f"#{test_case} {answer}")