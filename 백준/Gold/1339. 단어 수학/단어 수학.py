# n = int(input())
# word = []
# for _ in range(n):
#     word.append(list(input())[::-1])
# word.sort(key = lambda x:len(x))

# max_length = 0
# for w in word:
#     max_length = max(max_length,len(w))

# for i in range(n):
#     for j in range(max_length-len(word[i])):
#         word[i].append('0')
# for i in range(n):
#     word[i].reverse()

# alpha_dict = {}
# num = 9


# for i in range(max_length):
#     for j in range(n):
#         if word[j][i] not in alpha_dict and word[j][i] != '0':
#             alpha_dict[word[j][i]] = str(num)
#             num -=1 

# for i in range(n):
#     for j in range(max_length):
#         if word[i][j] in alpha_dict:
#             word[i][j] = alpha_dict[word[i][j]]

# result = 0
# for w in word:
#     tmp = int(''.join(w))
#     result += tmp

# print(result)     

n = int(input())

alpha = []
alpha_dict = {}
num_list = []

for i in range(n):
    alpha.append(input())

for i in range(n):
    for j in range(len(alpha[i])):
        if alpha[i][j] in alpha_dict:
            alpha_dict[alpha[i][j]] += 10**(len(alpha[i])-j-1)
        else:
            alpha_dict[alpha[i][j]] = 10**(len(alpha[i])-j-1)
for val in alpha_dict.values():
    num_list.append(val)

num_list.sort(reverse=True)

sum = 0
pows = 9
for i in num_list:
    sum += pows*i
    pows -= 1

print(sum)
