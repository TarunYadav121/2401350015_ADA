import time
import matplotlib.pyplot as plt

# Call counters
calls_T1 = 0
calls_T2 = 0

# ---------- Recurrence 1 ----------
# T(n) = T(n/2) + n
def T1(n):
    global calls_T1
    calls_T1 += 1
    
    if n <= 1:
        return 1
    
    # linear work
    for _ in range(n):
        pass
    
    return T1(n // 2) + n


# ---------- Recurrence 2 ----------
# T(n) = 2T(n/2) + n
def T2(n):
    global calls_T2
    calls_T2 += 1
    
    if n <= 1:
        return 1
    
    # linear work
    for _ in range(n):
        pass
    
    return T2(n // 2) + T2(n // 2) + n


# ---------- Main ----------
sizes = [8, 16, 32, 64, 128, 256]

time_T1 = []
time_T2 = []

call_list_T1 = []
call_list_T2 = []

for n in sizes:
    
    calls_T1 = 0
    calls_T2 = 0
    
    # Measure T1
    start = time.perf_counter()
    T1(n)
    time_T1.append(time.perf_counter() - start)
    call_list_T1.append(calls_T1)
    
    # Measure T2
    start = time.perf_counter()
    T2(n)
    time_T2.append(time.perf_counter() - start)
    call_list_T2.append(calls_T2)


# Print table
print("\nn | Calls_T1 | Calls_T2")
for i in range(len(sizes)):
    print(sizes[i], "|", call_list_T1[i], "|", call_list_T2[i])


# ---------- Plot Call Count ----------
plt.figure()
plt.plot(sizes, call_list_T1, label="T(n)=T(n/2)+n")
plt.plot(sizes, call_list_T2, label="T(n)=2T(n/2)+n")
plt.xlabel("Input Size (n)")
plt.ylabel("Number of Recursive Calls")
plt.title("Recurrence Call Comparison")
plt.legend()
plt.show()


# ---------- Plot Execution Time ----------
plt.figure()
plt.plot(sizes, time_T1, label="T(n)=T(n/2)+n")
plt.plot(sizes, time_T2, label="T(n)=2T(n/2)+n")
plt.xlabel("Input Size (n)")
plt.ylabel("Execution Time")
plt.title("Recurrence Time Comparison")
plt.legend()
plt.show()