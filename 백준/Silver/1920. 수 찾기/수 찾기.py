import sys
input = sys.stdin.readline

n = int(input())

a_list = list(map(int,input().split()))
a_list = set(a_list)

m = int(input())
number = list(map(int,input().split()))

for num in number:
    if num in a_list:
        print(1)
    else:
        print(0)