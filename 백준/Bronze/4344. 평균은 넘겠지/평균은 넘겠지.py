N = int(input())

for _ in range(N):
    input_list = list(map(int, input().split()))
    average = sum(input_list[1:])/input_list[0]
    cnt = 0
    for num in input_list[1:]:
        if(num > average):
            cnt += 1
    print(f'{(cnt/input_list[0])*100:.3f}%')