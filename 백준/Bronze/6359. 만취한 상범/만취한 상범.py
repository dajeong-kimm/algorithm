t = int(input())
for _ in range(t):
    n = int(input())
    room = [0]*(n+1)
    for i in range(1,n+1):
        for j in range(i,n+1,i):
            if room[j] == 0:
                room[j] = 1
            else:
                room[j] = 0
    print(room.count(1))