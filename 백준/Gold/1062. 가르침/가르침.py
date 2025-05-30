n,k = map(int,input().split())
learn = [0]*26
words = [set(input()) for _ in range(n)]

answer = 0

for c in ('a','c','i','n','t'):
    learn[ord(c)-ord('a')] = 1

def dfs(idx,cnt):
    global answer

    if cnt == k-5:
        readcnt = 0
        for word in words:
            check = True
            for w in word:
                if not learn[ord(w)-ord('a')]:
                    check = False
                    break
            if check:
                readcnt += 1
        answer = max(answer,readcnt)
        return
    
    for i in range(idx,26):
        if not learn[i]:
            learn[i] = True
            dfs(i,cnt+1)
            learn[i] = False

dfs(0,0)
print(answer)
