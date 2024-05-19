import math
t = int(input())

for test_case in range(1,t+1):
    n,d = map(int,input().split())
    answer = math.ceil(n/(2*d+1))
    print(f"#{test_case} {answer}")