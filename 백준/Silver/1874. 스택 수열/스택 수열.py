n = int(input())

arr = [int(input()) for _ in range(n)]

num = 1
idx = 0
stack = []
print_list = []
while idx<n:
    if not stack or arr[idx]>stack[-1]:
        for i in range(num,arr[idx]+1):
            stack.append(i)
            print_list.append("+")
        num = arr[idx]+1
        stack.pop()
        print_list.append("-")
        idx += 1
    elif arr[idx] == stack[-1]:
        stack.pop()
        print_list.append("-")
        idx += 1
    else:
        print("NO")
        exit()

for p in print_list:
    print(p)

    
        