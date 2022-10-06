from wsgiref import validate


import numpy as np
import matplotlib.pyplot as plt
f = open("output.csv", "r")
lst1 = list()
lst2 = list()
for line in f:
  lst1.append(int(line.split(',')[0]))
  lst2.append(float(line.split(',')[2]))
x = np.array(lst1)
y = np.array(lst2)

plt.plot(x, y)
plt.show()