t = int(input())

for test_case in range(1,t+1):
    n,k = map(int,input().split())
    student = [i for i in range(1,n+1)]
    arr = list(map(int,input().split()))
    for a in arr:
        student.remove(a)
    student.sort()
    print(f"#{test_case}",end=" ")
    print(*student)