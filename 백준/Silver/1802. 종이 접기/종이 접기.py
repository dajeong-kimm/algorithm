t = int(input())

for _ in range(t):
    fold = list(input())


    if len(fold)==1:
        print("YES")
        continue

    def divide_conq(low,high):
        if low==high:
            return low
        mid = (low+high)//2

        left = divide_conq(low,mid-1)
        right = divide_conq(mid+1,high)

        if left==-1 or right==-1:
            return -1
        
        left_part = fold[low:mid]
        right_part = fold[mid+1:high+1]
        for i in range(mid-low):
            if left_part[-i-1]==right_part[i]:
                return -1
        return mid

    if divide_conq(0,len(fold)-1)==-1:
        print("NO")
    else:
        print("YES")