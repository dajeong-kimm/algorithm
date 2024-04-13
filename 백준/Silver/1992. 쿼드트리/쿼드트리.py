n = int(input())
arr = []
for _ in range(n):
    tmp = [int(x) for x in list(input())]
    arr.append(tmp)

def quadtree(n,arr):
    s = 0
    for a in arr:
        s += sum(a)
    
    if s==n**2:
        return '1'
    if s==0:
        return '0'
    
    half = n//2
    temp = "("
    temp += quadtree(half,[a[:half] for a in arr[:half]])
    temp += quadtree(half,[a[half:] for a in arr[:half]])
    temp += quadtree(half,[a[:half] for a in arr[half:]])
    temp += quadtree(half,[a[half:] for a in arr[half:]])
    temp += ")"

    return temp

print(quadtree(n,arr))
