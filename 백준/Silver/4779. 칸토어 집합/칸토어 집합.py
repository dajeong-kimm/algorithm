def cnt(a,n):
    if n==1:
        return 
    for i in range(a+n//3,a+(n//3)*2):
        result[i] = " "
    cnt(a,n//3)
    cnt(a+n//3*2,n//3)

while True:
    try:
        n = int(input())
        result = ["-"]*(3**n)
        
        cnt(0,3**n)
        print(''.join(result))
    except:
        break
    

