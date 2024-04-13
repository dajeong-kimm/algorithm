import heapq
import sys

input = sys.stdin.readline

n = int(input())

heap = []
for _ in range(n):
    num = int(input())
    if num>0:
        heapq.heappush(heap,(num,1))
    elif num<0:
        heapq.heappush(heap,(-num,0))
    elif num == 0:
        if not heap:
            print(0)
        else:
            tmp,check = heapq.heappop(heap)
            if check==1:
                print(tmp)
            else:
                print(-tmp)
