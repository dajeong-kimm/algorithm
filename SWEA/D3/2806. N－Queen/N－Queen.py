def check(x):
    for i in range(x):
        if row[x]==row[i] or abs(row[x]-row[i]) == x-i:
            return False
    return True

def dfs(x):
    global answer
    if x == n:
        answer += 1
        return
    for i in range(n):
        row[x] = i
        if check(x):
            dfs(x+1)


t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    row = [0]*n
    answer = 0
    dfs(0)
    print(f"#{test_case} {answer}")