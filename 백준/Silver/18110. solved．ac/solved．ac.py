n = int(input())
arr = []

def my_round(val):
    if val-int(val)>=0.5:
        return int(val)+1
    else:
        return int(val)

for _ in range(n):
    arr.append(int(input()))

if n==0:
    print(0)
    exit()

many = my_round(n*0.15)
arr.sort()
new_arr = arr[many:n-many]

print(my_round(sum(new_arr)/len(new_arr)))
