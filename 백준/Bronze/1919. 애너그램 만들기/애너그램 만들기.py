from collections import deque
s1 = list(input())
s2 = list(input())
answer = 0
# s1_queue = deque(s1)
# s2_queue = deque(s2)
s_set = set(s1+s2)

for s in s_set:
    count_min = min(s1.count(s),s2.count(s))
    count_max = max(s1.count(s),s2.count(s))
    answer += (count_max-count_min)

print(answer)

