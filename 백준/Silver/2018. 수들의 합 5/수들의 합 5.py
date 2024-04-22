import math

n = int(input())
end = 0
sum_ = 0
count = 0

for start in range(0,n):
    while sum_<n and end<n:
        sum_ += end+1
        end += 1
    if sum_ == n:
        count += 1
    sum_ -= (start+1)

print(count)