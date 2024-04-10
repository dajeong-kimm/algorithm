t = int(input())

for _ in range(t):
    s = list(input())
    pwd = []
    sub = []
    
    for a in s:
        if a == "<":
            if pwd:
                sub.append(pwd.pop())
        elif a==">":
            if sub:
                pwd.append(sub.pop())
        elif a == "-":
            if pwd:
                pwd.pop()
        else:
            pwd.append(a)
    
    print(''.join(pwd),''.join(sub[::-1]),sep="")



# arr = [1,2,3,4,5]
# arr.insert(5,10)
# print(arr)