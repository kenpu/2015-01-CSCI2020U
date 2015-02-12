import re
from matplotlib import pylab

name_p = r">([A-Z- ]+)<"
money_p = r">\$([0-9.,]+)<"

salaries = []

f = open("data/output.txt", "r")
for line in f.readlines():
    m1 = re.findall(name_p, line)
    if m1: print m1
    m2 = re.findall(money_p, line)
    if m2: 
        print m2[0]
        s = m2[0]
        amt = float(s.replace(",", ""))
        if amt > 100000: salaries.append(amt)

pylab.hist(salaries, 100)
pylab.show()


