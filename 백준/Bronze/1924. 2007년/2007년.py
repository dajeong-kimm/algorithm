days = [0,31,28,31,30,31,30,31,31,30,31,30,31]

arr = ['MON','TUE','WED','THU','FRI','SAT','SUN']

a,b = map(int,input().split())

count = b-1
for i in range(1,a+1):
    count += days[i-1]


print(arr[count%7])