import pandas as pd
import numpy as np

n_rows = 5
n_cols = 5
cols = tuple("ABCDE")

df = pd.DataFrame(np.random.randint(1,10,size=(n_rows,n_cols)),columns=cols)

df