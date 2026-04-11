import time
import matplotlib.pyplot as plt

# ---------- Call Counters ----------
fact_calls = 0
fib_calls = 0
fib_dp_calls = 0

# ---------- Factorial ----------
def factorial(n):
    global fact_calls
    fact_calls += 1
    if n <= 1:
        return 1
    return n * factorial(n - 1)

# ---------- Fibonacci Naive ----------
def fibonacci(n):
    global fib_calls
    fib_calls += 1
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

# ---------- Fibonacci DP ----------
def fibonacci_dp(n, memo={}):
    global fib_dp_calls
    fib_dp_calls += 1
    
    if n in memo:
        return memo[n]
    
    if n <= 1:
        return n
    
    memo[n] = fibonacci_dp(n-1, memo) + fibonacci_dp(n-2, memo)
    return memo[n]

# ---------- Main Analysis ----------
sizes = [5, 10, 20, 30]

fact_times = []
fib_times = []
fib_dp_times = []

fact_call_list = []
fib_call_list = []
fib_dp_call_list = []

for n in sizes:
    
    # Reset counters
    fact_calls = 0
    fib_calls = 0
    fib_dp_calls = 0
    
    # Factorial
    start = time.perf_counter()
    factorial(n)
    fact_times.append(time.perf_counter() - start)
    fact_call_list.append(fact_calls)
    
    # Fibonacci Naive
    start = time.perf_counter()
    fibonacci(n)
    fib_times.append(time.perf_counter() - start)
    fib_call_list.append(fib_calls)
    
    # Fibonacci DP
    start = time.perf_counter()
    fibonacci_dp(n, {})
    fib_dp_times.append(time.perf_counter() - start)
    fib_dp_call_list.append(fib_dp_calls)

# ---------- Print Table ----------
print("\nn | FactCalls | FibCalls | FibDPCalls")
for i in range(len(sizes)):
    print(sizes[i], "|", fact_call_list[i], "|", fib_call_list[i], "|", fib_dp_call_list[i])

# ---------- Plot Time Comparison ----------
plt.figure()
plt.plot(sizes, fib_times, label="Fibonacci Naive")
plt.plot(sizes, fib_dp_times, label="Fibonacci DP")
plt.xlabel("Input Size (n)")
plt.ylabel("Execution Time")
plt.title("Naive vs DP Fibonacci (Time)")
plt.legend()
plt.show()

# ---------- Plot Call Comparison ----------
plt.figure()
plt.plot(sizes, fib_call_list, label="Naive Calls")
plt.plot(sizes, fib_dp_call_list, label="DP Calls")
plt.xlabel("Input Size (n)")
plt.ylabel("Number of Function Calls")
plt.title("Naive vs DP Fibonacci (Call Count)")
plt.legend()
plt.show()

