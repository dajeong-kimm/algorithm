s = list(input())
tmp_cnt = 0
answer = ""
for i in range(len(s)):
    if s[i] == "X":
        tmp_cnt += 1
    elif s[i] == ".":
        while tmp_cnt>0:
            if tmp_cnt == 1:
                print(-1)
                exit()
            elif tmp_cnt>=4:
                answer += "AAAA"
                tmp_cnt -= 4
            elif tmp_cnt>=2:
                answer += "BB"
                tmp_cnt -= 2
        answer += "."

if tmp_cnt>0:
    while tmp_cnt>0:
        if tmp_cnt == 1:
            print(-1)
            exit()
        elif tmp_cnt>=4:
            answer += "AAAA"
            tmp_cnt -= 4
        elif tmp_cnt>=2:
            answer += "BB"
            tmp_cnt -= 2

print(answer)