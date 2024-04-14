from collections import deque
t = int(input())
for _ in range(t):
    func = list(input())
    n = int(input())
    flag = 1
    arr = input()
    dq = deque(arr[1:-1].split(','))

    if n==0:
        dq = deque()
    R = 0
    for i in range(len(func)):
        if func[i] == "R":
            R += 1
        elif func[i] == "D":
            if len(dq) == 0:
                print('error')
                flag = 0
                break
            else:
                if R%2 == 0:
                    dq.popleft()
                else:
                    dq.pop()
    
    if flag == 0:
        continue
    else:
        if R%2 == 0:
            print("["+",".join(dq)+"]")
        else:
            dq.reverse()
            print("["+",".join(dq)+"]")
    