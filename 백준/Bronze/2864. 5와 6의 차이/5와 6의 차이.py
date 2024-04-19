import copy
a,b = map(str,input().split())
answer = [int(a)+int(b)]

a = a.replace("5","6")
b = b.replace("5","6")
answer.append(int(a)+int(b))

a  = a.replace("6","5")
b = b.replace("6","5")
answer.append(int(a)+int(b))

print(min(answer),max(answer))
