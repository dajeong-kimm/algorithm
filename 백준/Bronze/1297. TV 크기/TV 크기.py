d,h,w = map(int,input().split())

n = (d**2/(h**2+w**2))**0.5

print(int(n*h), int(n*w))