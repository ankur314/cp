package main

import "fmt"

func main() {
	var t int
	fmt.Scanln(&t)

	for t > 0 {
		t--
		var str string
		fmt.Scanln(&str)
		n := len(str)
		ans := 0
		if str == "^" {
			fmt.Println(1)
			continue
		}
		if str[0] == '_' {
			ans++
		}
		if str[n-1] == '_' {
			ans++
		}
		for i := 0; i < n-1; i++ {
			if str[i] == '_' && str[i+1] == '_' {
				ans++
			}
		}
		fmt.Println(ans)
	}
}
