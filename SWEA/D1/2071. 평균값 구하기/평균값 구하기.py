import math
t = int(input())

for test_case in range(1,t+1):
    arr = list(map(int,input().split()))
    answer = sum(arr)/10
    if answer-int(answer)>=0.5:
        answer = int(answer)+1
    else:
        answer = int(answer)
    print(f"#{test_case} {answer}")