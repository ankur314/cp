package main

import (
	"fmt"
)

func solve() {
	var n, t int
	fmt.Scan(&n)
	fmt.Scan(&t)
	a := make([]int, n)
	b := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}
	for i := 0; i < n; i++ {
		fmt.Scan(&b[i])
	}
	ans := -1
	prev := -1
	for i := 0; i < n; i++ {
		if (i+a[i]) <= t && b[i] > prev {
			ans = i + 1
			prev = b[i]
		}
	}
	fmt.Println(ans)
}

func main() {
	t := 1
	fmt.Scan(&t)
	for t > 0 {
		t -= 1
		solve()
	}
}
