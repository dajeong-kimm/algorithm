import sys
input = sys.stdin.readline
stack = []
t = int(input())
for _ in range(t):
    a = input().rstrip()
    if a[:4]=="push":
        _,b = map(str,a.split())
        stack.append(int(b))
    elif a=="pop":
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif a=="size":
        print(len(stack))
    elif a=="empty":
        if stack:
            print(0)
        else:
            print(1)
    else:
        if stack:
            print(stack[-1])
        else:
            print(-1)