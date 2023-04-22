package main

import (
	"fmt"
	"strconv"
)

func solve() {
	var n, d int
	fmt.Scan(&n)
	fmt.Scan(&d)
	var num string
	fmt.Scan(&num)
	var ans string
	flag := false
	for i := 0; i < len(num); i++ {
		if val, _ := strconv.Atoi((num[i : i+1])); val < d {
			flag = true
			if i > 0 {
				ans = num[0:i] + strconv.Itoa(d) + num[i:]
			} else {
				ans = strconv.Itoa(d) + num
			}
			break
		}
	}
	if flag == false {
		ans = num + strconv.Itoa(d)
	}
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
