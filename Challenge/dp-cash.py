'''
	动态规划算法
	但是，如果我们换一组钞票的面值，贪心策略就也许不成立了。如果一个奇葩国家的钞票面额分别是1、5、11，那么我们在凑出15的时候，贪心策略会出错：
'''

w = 16

f = [0 for i in range(w+1)]
m = [0 for i in range(w+1)]

f[0] = 0

for i in range(1, w+1):
	cost = 1000000
	idx_cost = 0
	
	if i - 1 >= 0:
		if cost > f[i-1] +1:
			cost = f[i-1] +1
			m[i] = 1
		
	if i - 5 >= 0:
		if cost > f[i-5] +1:
			cost = f[i-5] +1
			m[i] = 5
		
	if i - 11 >= 0:
		if cost > f[i-11] +1:
			cost = f[i-11] +1
			m[i] = 11
		
	f[i] = cost


print w

for i in range(1,w+1):
	print "f[%d]=%d, m[%d]=%d" % (i, f[i], i, m[i])

a = w
sl = []

while a>0:
	sl.append(m[a])
	a = a-m[a]

print "plan:", sl