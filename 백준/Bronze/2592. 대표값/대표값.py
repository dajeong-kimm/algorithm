arr = [int(input()) for _ in range(10)]
print(sum(arr)//10)

arr_set = set(arr)
cur_num = 0
cur_count = 0
for s in arr_set:
    if arr.count(s)>cur_count:
        cur_count = arr.count(s)
        cur_num = s

print(cur_num)
