def print_counter():
    global counter
    counter = 200
    print('counter didalam fungsi =', counter)  # nilai counter didalam fungsi


counter = 100
print_counter()
print('counter diluar fungsi = ', counter)  # nilai counter diluar fungsi

# output
# counter didalam fungsi = 200
# counter diluar fungsi = 200
