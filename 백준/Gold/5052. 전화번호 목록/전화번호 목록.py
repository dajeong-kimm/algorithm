t = int(input())
for _ in range(t):
    n = int(input())
    num = [list(input()) for _ in range(n)]

    num.sort()

    answer = True
    for i in range(len(num)-1):
        if num[i] == num[i+1][:len(num[i])]:
            answer = False
            break
    
    if answer:
        print("YES")
    else:
        print("NO")