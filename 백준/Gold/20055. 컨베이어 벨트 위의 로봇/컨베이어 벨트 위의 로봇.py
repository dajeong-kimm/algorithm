from collections import deque

n,k = map(int,input().split())
a = deque(list(map(int,input().split())))

def solution(n,k,a):
    answer = 0
    belt = deque([False]*n)

    while True:
        answer += 1
        # 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
        a.rotate(1)
        belt.rotate(1)

        # 로봇이 내리는 위치에 도달하면 그 즉시 내림
        belt[n-1] = False

        # 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있따면
        # 만약 이동할 수 없다면 가만히
        for i in range(n-2,-1,-1):
            # 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상
            if belt[i] and not belt[i+1] and a[i+1]>0:
                belt[i],belt[i+1] = False, True
                a[i+1] -= 1
        
        belt[n-1] = False

        if a[0]>0:
            belt[0] = True
            a[0] -= 1
        
        if a.count(0)>=k:
            break
    
    return answer

response = solution(n,k,a)
print(response)