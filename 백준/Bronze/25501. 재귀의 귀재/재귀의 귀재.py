# 자주 나오는 단어, 단어의 길이 길수록, 사전순 앞에
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    word = input().rstrip()
    start = 0
    end = len(word)-1
    isPalin = True
    count = 1
    while True:
        if start>=end:
            isPalin = True
            break
        elif word[start] != word[end]:
            isPalin = False
            break
        else:
            start += 1
            end -=1
            count += 1
    print(int(isPalin),count)


        
