n = int(input())

in_cars = {}
out_cars = {}

for i in range(n):
    car = input()
    in_cars[car] = i

for i in range(n):
    car = input()
    out_cars[car] = i

count = 0
out_keys = list(out_cars.keys())

for i in range(len(out_keys)-1):
    now_in = in_cars[out_keys[i]]
    for j in range(i+1,len(out_keys)):
        next_in = in_cars[out_keys[j]]
        if next_in<now_in:
            count += 1
            break
print(count)
