package main

import (
	"fmt"
)

func Reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func solve() {
	var n int
	fmt.Scan(&n)
	if n%2 == 0 {
		fmt.Println(-1)
		return
	}
	ans := ""
	cnt := 0
	for n > 1 {
		a := (n + 1) / 2
		b := (n - 1) / 2
		if a%2 != 0 {
			ans += "1 "
			n = a
		} else {
			ans += "2 "
			n = b
		}
		cnt++
	}
	ans = Reverse(ans)
	fmt.Println(cnt)
	fmt.Println(ans)

}

func main() {
	t := 1
	fmt.Scan(&t)
	for t > 0 {
		t--
		solve()
	}
}
