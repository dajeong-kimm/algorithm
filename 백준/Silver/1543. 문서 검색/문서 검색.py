import sys
input = sys.stdin.readline

dic = list(input())
dic.pop()
word = list(input())
word.pop()
i = 0
answer = 0
while i<=(len(dic)-len(word)):
    if dic[i]==word[0]:
        avail = True
        for j in range(1,len(word)):
            if dic[i+j] != word[j]:
                avail = False
                break
        if avail:
            answer += 1
            i += len(word)
        else:
            i+=1
    else:
        i+=1
print(answer)
                


