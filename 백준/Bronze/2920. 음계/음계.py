asc = [i for i in range(1,9)]
des = [i for i in range(8,0,-1)]

a = list(map(int,input().split()))

if a==asc:
    print("ascending")
elif a==des:
    print("descending")
else:
    print("mixed")