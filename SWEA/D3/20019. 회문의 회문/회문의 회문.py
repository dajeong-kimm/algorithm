t = int(input())

for test_case in range(1,t+1):
    s = list(input())
    len_ = len(s)
    if s == s[::-1]:
        tmp1 = s[:(len_-1)//2]
        tmp2 = s[(len_-1)//2+1:]
        if tmp1 == tmp1[::-1] and tmp2 == tmp2[::-1]:
            answer = "YES"
        else:
            answer = "NO"
    else:
        answer = "NO"
    print(f"#{test_case} {answer}")