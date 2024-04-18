import heapq

def isEmpty(nums):
    for item in nums:
        if item[1]>0:
            return False
    return True

t = int(input())
for _ in range(t):
    min_heap = []
    max_heap = []
    nums = dict()
    k = int(input())
    for _ in range(k):
        a,b = map(str,input().split())
        if a == "I":
            if int(b) in nums:
                nums[int(b)] += 1
            else:
                nums[int(b)] = 1
                heapq.heappush(min_heap,int(b))
                heapq.heappush(max_heap,-int(b))
        elif a == "D":
            if not isEmpty(nums.items()):
                if int(b) == 1:
                    while -max_heap[0] not in nums or nums[-max_heap[0]]<1:
                        temp = -heapq.heappop(max_heap)
                        if temp in nums:
                            del nums[temp]
                    nums[-max_heap[0]] -= 1
                else:
                    while min_heap[0] not in nums or nums[min_heap[0]]<1:
                        temp = heapq.heappop(min_heap)
                        if temp in nums:
                            del nums[temp]
                    nums[min_heap[0]] -= 1
    
    if isEmpty(nums.items()):
        print("EMPTY")
    else:
        while min_heap[0] not in nums or nums[min_heap[0]]<1:
            heapq.heappop(min_heap)
        while -max_heap[0] not in nums or nums[-max_heap[0]]<1:
            heapq.heappop(max_heap)
        print(-max_heap[0],min_heap[0])


