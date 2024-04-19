name_dict = {}

n = int(input())
for _ in range(n):
    s = input()
    tmp = s[0]
    if tmp in name_dict:
        name_dict[tmp] += 1
    else:
        name_dict[tmp] = 1

sorted_name = sorted(name_dict.items(),key=lambda x:x[1],reverse=True)

answer = []
for name,count in sorted_name:
    if count>=5:
        answer.append(name)
    else:
        break

if not answer:
    print("PREDAJA")
else:
    answer.sort()
    print(''.join(answer))