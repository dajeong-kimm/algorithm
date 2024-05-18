import math
t = int(input())
for test_case in range(1,t+1):
    print(f"#{test_case}")
    n = int(input())
    arr = [list(map(str,input().split())) for _ in range(n)]
    answer = ''
    length = 0
    for a,b in arr:
        for _ in range(int(b)):
            answer += a
        length += int(b)
    cnt = math.ceil(length/10)
    for i in range(cnt):
        print(answer[i*10:i*10+10])
