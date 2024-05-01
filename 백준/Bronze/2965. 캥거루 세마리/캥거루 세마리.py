a,b,c = map(int,input().split())
answer = max(b-a-1,c-b-1)
print(answer)