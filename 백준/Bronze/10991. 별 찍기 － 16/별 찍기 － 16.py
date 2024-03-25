n = int(input())

for i in range(1,n+1):
    star = ['*' for _ in range(i)]
    none = [' ' for _ in range(n-i)]
    print(''.join(none)+' '.join(star))