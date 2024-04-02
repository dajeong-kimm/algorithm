from itertools import product
num = int(input())

n = len(str(num))
num_list = []
# 4, 7, 44, 47, 74, 77, 444
for i in range(1,7):
    for p in product(['4','7'],repeat=i):
        number = ''.join(p)
        num_list.append(int(number))
num_list.append(4444444)
num_list.sort()
i = 0
while True:
    if num_list[i]==num:
        answer = num
        break
    elif num_list[i]>num:
        answer = num_list[i-1]
        break
    i+=1

print(answer)