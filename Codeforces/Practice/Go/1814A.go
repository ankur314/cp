package main

import (
	"fmt"
)

func solve() {
	var n, k int64
	fmt.Scan(&n)
	fmt.Scan(&k)
	if n%2 == 0 || (n-k)%2 == 0 {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}

func main() {
	t := 1
	fmt.Scan(&t)
	for t > 0 {
		t--
		solve()
	}
}
