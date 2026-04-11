import time
import random
import matplotlib.pyplot as plt

# O(1)
def constant_time(arr):
    return arr[0]

# O(n)
def linear_time(arr):
    total = 0
    for x in arr:
        total += x
    return total

# O(n^2)
def quadratic_time(arr):
    for i in range(len(arr)):
        for j in range(len(arr)):
            _ = arr[i] + arr[j]

# O(log n)
def logarithmic_time(arr, key):
    low = 0
    high = len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == key:
            return mid
        elif arr[mid] < key:
            low = mid + 1
        else:
            high = mid - 1
    return -1


sizes = [10, 100, 500, 1000]

o1_times = []
on_times = []
on2_times = []
ologn_times = []

for n in sizes:
    arr = list(range(n))
    
    start = time.time()
    constant_time(arr)
    o1_times.append(time.time() - start)

    start = time.time()
    linear_time(arr)
    on_times.append(time.time() - start)

    start = time.time()
    quadratic_time(arr)
    on2_times.append(time.time() - start)

    start = time.time()
    logarithmic_time(arr, n-1)
    ologn_times.append(time.time() - start)


plt.plot(sizes, o1_times, label="O(1)")
plt.plot(sizes, on_times, label="O(n)")
plt.plot(sizes, on2_times, label="O(n^2)")
plt.plot(sizes, ologn_times, label="O(log n)")

plt.xlabel("Input Size")
plt.ylabel("Execution Time")
plt.title("Algorithm Growth Comparison")
plt.legend()
plt.show()