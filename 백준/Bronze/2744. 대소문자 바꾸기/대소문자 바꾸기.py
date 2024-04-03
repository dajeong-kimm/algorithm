s = list(input())
arr = []
for i in s:
    if i.islower():
        arr.append(i.upper())
    else:
        arr.append(i.lower())
    
print(''.join(arr))