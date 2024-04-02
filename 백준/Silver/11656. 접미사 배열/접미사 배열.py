s = input()
word = []
for i in range(len(s)):
    word.append(s[i:])

word.sort()

for w in word:
    print(w)