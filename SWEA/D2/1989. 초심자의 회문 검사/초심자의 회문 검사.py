t = int(input())
for test_case in range(1,t+1):
    s = list(input())
    # print(s[::-1])
    if s == s[::-1]:
        answer = 1
    else:
        answer = 0
    print(f"#{test_case} {answer}")