n = int(input())
student = []
for _ in range(n):
    student.append(list(map(str,input().split())))

student = sorted(student,key=lambda x:(int(x[3]),int(x[2]),int(x[1])))

print(student[-1][0])
print(student[0][0])