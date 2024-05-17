t = int(input())

for _ in range(t):
    test_case = int(input())
    arr = list(map(int,input().split()))
    score = {}
    for a in arr:
        if a not in score:
            score[a] = 0
        score[a] += 1

    sorted_score = sorted(score.items(),  key= lambda x:(-x[1],-x[0]))
    answer = sorted_score[0][0]
    print(f"#{test_case} {answer}")
