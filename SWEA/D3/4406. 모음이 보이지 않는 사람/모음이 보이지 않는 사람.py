t = int(input())
for test_case in range(1,t+1):
    alpha = ['a','e','i','o','u']
    word = input()
    answer = ""
    for w in word:
        if w not in alpha:
            answer += w
    print(f"#{test_case} {answer}")