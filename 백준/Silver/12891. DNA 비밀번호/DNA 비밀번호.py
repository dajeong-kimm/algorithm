from collections import deque
import sys
input = sys.stdin.readline

s,p = map(int,input().split())

string = list(str(input()))

a,c,g,t = map(int,input().split())
dic = {'A':0, 'C':0, 'G':0, 'T':0}

left, right = 0, p-1
queue = deque(string[left:right])
for q in queue:
    dic[q] += 1
cnt = 0

while right<s:
    dic[string[right]] += 1

    if dic['A']>=a and dic['C']>=c and dic['G']>=g and dic['T']>=t:
        cnt += 1
    
    dic[string[left]] -= 1
    left += 1
    right += 1

print(cnt)