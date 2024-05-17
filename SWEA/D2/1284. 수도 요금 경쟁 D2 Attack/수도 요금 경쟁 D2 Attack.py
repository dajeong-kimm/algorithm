t = int(input())
for test_case in range(1,t+1):
    p,q,r,s,w = map(int,input().split())
    A = 0
    B = 0
    A = p*w
    if w<=r:
        B = q
    else:
        B = q + (w-r)*s
    answer = min(A,B)
    print(f"#{test_case} {answer}")