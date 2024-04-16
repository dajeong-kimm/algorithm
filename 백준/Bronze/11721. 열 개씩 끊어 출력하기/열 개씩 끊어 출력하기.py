s = input()

if len(s)%10 == 0:
    n = len(s)//10

else:
    n = len(s)//10+1

for i in range(n):
    print(s[i*10:i*10+10])