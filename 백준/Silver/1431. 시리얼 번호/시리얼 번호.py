n = int(input())

serial = [] # (시리얼, 길이, 숫자합)
for _ in range(n):
    tmp = input()
    len_tmp = len(tmp)
    digit_sum = 0
    for t in tmp:
        if t.isdigit():
            digit_sum += int(t)
    
    serial.append((tmp,len_tmp,digit_sum))

serial.sort(key=lambda x:(x[1],x[2],x[0]))

for s in serial:
    print(s[0])
