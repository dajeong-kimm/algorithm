t = int(input())

for _ in range(t):
    n = int(input())
    note1 = list(map(int,input().split()))
    note1 = set(note1)
    m = int(input())
    note2 = list(map(int,input().split()))
    for i in range(m):
        if note2[i] in note1:
            print(1)
        else:
            print(0)