n = int(input())
arr = list(map(int,input().split()))

LIS = [arr[0]]

def findPlace(e):
    start = 0
    end = len(LIS)-1

    while start<=end:
        mid = (start+end)//2

        if LIS[mid] == e:
            return mid
        elif LIS[mid]<e:
            start = mid+1
        else:
            end = mid-1
    return start

for a in arr:
    if LIS[-1]<a:
        LIS.append(a)
    else:
        idx = findPlace(a)
        LIS[idx] = a

print(len(LIS))