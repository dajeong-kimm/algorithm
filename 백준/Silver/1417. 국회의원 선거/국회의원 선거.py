import heapq
one = 0
n = int(input())
if n == 1:
    print(0)
else:
    one = int(input())
    other = []
    for _ in range(n-1):
        heapq.heappush(other,-int(input()))
    answer = 0
    while True:
        tmp = -heapq.heappop(other)
        if one>tmp:
            print(answer)
            break
        one += 1
        heapq.heappush(other,-(tmp-1))
        answer += 1