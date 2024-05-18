for test_case in range(1,11):
    n,m = input().split()
    m_list = list(m)
    answer = []
    for i in range(int(n)):
        if not answer:
            answer.append(m_list[i])
        else:
            if answer[-1] == m_list[i]:
                answer.pop()
            else:
                answer.append(m_list[i])
    print(f"#{test_case} {''.join(answer)}")