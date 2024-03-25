m = int(input())
n = int(input())
pow_list = []
num = 1
while num**2<=n:
    if m<=num*num<=n:
        pow_list.append(num**2)
    num += 1
if not pow_list:
    print(-1)
else:
    print(sum(pow_list))
    print(pow_list[0])