max_value = 0
answer = 0

for i in range(5):
    tmp = list(map(int,input().split()))
    if sum(tmp)>max_value:
        max_value = sum(tmp)
        answer = i+1
    
print(answer,max_value)
