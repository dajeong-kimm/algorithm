s = input()
boom = input()
boom_len = len(boom)

stack = []
for i in s:
    stack.append(i)
    if stack[-1] == boom[-1]:
        tmp = []
        tmp.append(stack.pop())
        flag = 0
        for j in range(boom_len-2,-1,-1):
            if stack:
                if stack[-1] == boom[j]:
                    tmp.append(stack.pop())
                elif stack[-1] != boom[j]:
                    flag = 1
                    break
            else:
                stack += tmp[::-1]
                tmp = []
        if flag == 1 and tmp:
            stack += tmp[::-1]
    
        

if not stack:
    print("FRULA")
else:
    print(''.join(stack))
                
