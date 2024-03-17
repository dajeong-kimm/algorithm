def solution(array, commands):
    answer = []
    for com in commands:
        i, j, k = com
        sliced_arr = array[i-1:j]
        sorted_slice = sorted(sliced_arr)
        answer.append(sorted_slice[k-1])
    return answer
        