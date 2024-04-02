n = int(input())

tri = []
app = 0
for i in range(1,46):
    app += i
    tri.append(app)

def is_tri(num):
    for i in range(len(tri)):
        for j in range(len(tri)):
            for k in range(len(tri)):
                if num == tri[i]+tri[j]+tri[k]:
                    return 1
    return 0

for _ in range(n):
    num = int(input())
    print(is_tri(num))
# n = int(input())
# answer = 0
# for i in range(1,n+1):
#     answer += i
# print(answer)