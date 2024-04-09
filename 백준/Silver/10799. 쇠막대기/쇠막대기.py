arr = list(input())
stack = []
idx = 0
answer = 0
while idx<len(arr):
    if arr[idx] == "(":
        if arr[idx+1] == ")":
            idx += 2
            answer += len(stack)
        else:
            stack.append(arr[idx])
            answer += 1
            idx += 1
    else:
        stack.pop()
        idx += 1

print(answer)
