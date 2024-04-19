from collections import deque
def cal_d(num):
    return num*2%10000

def cal_s(num):
    if num==0:
        return 9999
    return num-1

def cal_l(num):
    return num//1000 + (num%1000)*10

def cal_r(num):
    return num//10 + (num%10)*1000

def bfs(A,B):
    ch = [0 for _ in range(10001)]
    queue = deque()
    queue.append((A,""))
    ch[A] = True
    while queue:
        num,comm = queue.popleft()
        if num==B:
            return comm
        d = cal_d(num)
        if not ch[d]:
            ch[d] = True
            queue.append((d,comm+"D"))
        s = cal_s(num)
        if not ch[s]:
            ch[s] = True
            queue.append((s,comm+"S"))
        l = cal_l(num)
        if not ch[l]:
            ch[l] = True
            queue.append((l,comm+"L"))
        r = cal_r(num)
        if not ch[r]:
            ch[r] = True
            queue.append((r,comm+"R"))

t = int(input())
for _ in range(t):
    A,B = map(int,input().split())
    print(bfs(A,B))
