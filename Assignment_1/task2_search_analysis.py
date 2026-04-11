import time
import random
import matplotlib.pyplot as plt

# ---------- Linear Search ----------
def linear_search(arr, key):
    for i in range(len(arr)):
        if arr[i] == key:
            return i
    return -1

# ---------- Binary Search ----------
def binary_search(arr, key):
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

# ---------- Main Analysis ----------
sizes = [10, 100, 500, 1000]
REPEAT = 1000  # repeat to get measurable time

linear_best = []
linear_avg = []
linear_worst = []

binary_best = []
binary_avg = []
binary_worst = []

for n in sizes:
    arr = sorted(random.sample(range(n*10), n))
    
    best_key = arr[0]
    avg_key = arr[n//2]
    worst_key = -1  # not present

    # ----- Linear Best -----
    start = time.perf_counter()
    for _ in range(REPEAT):
        linear_search(arr, best_key)
    linear_best.append(time.perf_counter() - start)

    # ----- Linear Average -----
    start = time.perf_counter()
    for _ in range(REPEAT):
        linear_search(arr, avg_key)
    linear_avg.append(time.perf_counter() - start)

    # ----- Linear Worst -----
    start = time.perf_counter()
    for _ in range(REPEAT):
        linear_search(arr, worst_key)
    linear_worst.append(time.perf_counter() - start)

    # ----- Binary Best -----
    start = time.perf_counter()
    for _ in range(REPEAT):
        binary_search(arr, best_key)
    binary_best.append(time.perf_counter() - start)

    # ----- Binary Average -----
    start = time.perf_counter()
    for _ in range(REPEAT):
        binary_search(arr, avg_key)
    binary_avg.append(time.perf_counter() - start)

    # ----- Binary Worst -----
    start = time.perf_counter()
    for _ in range(REPEAT):
        binary_search(arr, worst_key)
    binary_worst.append(time.perf_counter() - start)

# ---------- Plot Worst Case ----------
plt.figure()
plt.plot(sizes, linear_worst, label="Linear Worst")
plt.plot(sizes, binary_worst, label="Binary Worst")
plt.xlabel("Input Size")
plt.ylabel("Execution Time")
plt.title("Linear vs Binary Search (Worst Case)")
plt.legend()
plt.show()

# ---------- Plot Average Case ----------
plt.figure()
plt.plot(sizes, linear_avg, label="Linear Average")
plt.plot(sizes, binary_avg, label="Binary Average")
plt.xlabel("Input Size")
plt.ylabel("Execution Time")
plt.title("Linear vs Binary Search (Average Case)")
plt.legend()
plt.show()

# ---------- Plot Best Case ----------
plt.figure()
plt.plot(sizes, linear_best, label="Linear Best")
plt.plot(sizes, binary_best, label="Binary Best")
plt.xlabel("Input Size")
plt.ylabel("Execution Time")
plt.title("Linear vs Binary Search (Best Case)")
plt.legend()
plt.show()