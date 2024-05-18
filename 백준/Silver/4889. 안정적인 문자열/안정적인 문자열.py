test_case = 1
while True:
    try:
        test = list(input())
        if '-' in test:
            exit()
        stack = []
        answer = 0
        for t in test:
            if t == "{":
                stack.append(t)
            else:
                if not stack:
                    answer += 1
                    stack.append("{")
                else:
                    stack.pop()
        answer += len(stack)//2
        print(f"{test_case}. {answer}")
        test_case += 1
    except EOFError:
        break