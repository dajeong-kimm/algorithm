n = int(input())

# 제곱수는 1로 저장
arr = [0 if i**0.5%1 else 1 for i in range(n+1)]

min_value = 4
for i in range(int(n**0.5),0,-1):
    if arr[n]:
        min_value=1
        break
    elif arr[n-i**2]:
        min_value =2
        break
    else:
        for j in range(int((n-i**2)**0.5),0,-1):
            if arr[(n-i**2)-j**2]:
                min_value = 3
print(min_value)