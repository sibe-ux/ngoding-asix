def closure_calc():
    a = 2

    def mult(x):
        return a * x
    return mult


c = closure_calc()
print(c(1), c(2), c(3))

# output
# 2 4 6

def fungsi_luar(x):
    a = 10
    def addition(z):
        return a + z
    return addition(x)

print(fungsi_luar(10))