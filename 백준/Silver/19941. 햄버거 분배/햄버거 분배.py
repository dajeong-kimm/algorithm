n, k = map(int,input().split())
ham = list(input())
answer = 0

for i in range(n):
    if ham[i] == "P":
        for j in range(max(i-k,0),min(i+k+1,n)):
            if ham[j] == "H":
                ham[j] = 0
                answer += 1
                break

print(answer)
        