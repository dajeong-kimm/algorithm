arr = [] #(문제 점수, 문제 번호)
for i in range(8):
    score = int(input())
    arr.append([score,(i+1)])

arr.sort(key=lambda x:x[0],reverse=True)
sum_value = 0
problem = []

for a,b in arr[:5]:
    sum_value += a
    problem.append(b)

problem.sort()
print(sum_value)
print(*problem)
