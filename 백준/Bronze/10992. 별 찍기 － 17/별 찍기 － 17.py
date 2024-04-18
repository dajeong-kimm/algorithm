n = int(input())
if n==1:
    print("*")
    exit()
tmp = ""
for i in range(n-1):
    tmp += " "
tmp += "*"
print(tmp)
for i in range(1,n-1):
    tmp = ""
    for _ in range(n-i-1):
       tmp += " "
    tmp += "*"
    for _ in range(i*2-1):
        tmp += " "
    tmp += "*"
    print(tmp)
tmp = ""
for _ in range(n*2-1):
    tmp += "*"
print(tmp)
    
