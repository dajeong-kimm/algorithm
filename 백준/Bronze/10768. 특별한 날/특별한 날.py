m = int(input())
n = int(input())
if m<2 or (m==2 and n<18):
    print("Before")
elif m>2 or (m==2 and n>18):
    print("After")
else:
    print("Special")
