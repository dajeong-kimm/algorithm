# 자주 나오는 단어, 단어의 길이 길수록, 사전순 앞에
import sys
input = sys.stdin.readline
n,m = map(int,input().split())
word = {}
for _ in range(n):
    w = input().rstrip()
    if len(w)>=m:
        if w not in word:
            word[w] = 0
        word[w] += 1
sorted_word = sorted(word.items(),key=lambda x:(-x[1],-len(x[0]),x[0]))

for w, _ in sorted_word:
    print(w)