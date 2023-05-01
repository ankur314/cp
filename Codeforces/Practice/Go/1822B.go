package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
)

func solve(in io.Reader, out io.Writer) {
	var n int
	fmt.Fscan(in, &n)
	a := make([]int, n)
	zeroPresent := false
	for i := 0; i < n; i++ {
		fmt.Fscan(in, &a[i])
		if a[i] == 0 {
			zeroPresent = true
		}
	}
	sort.Ints(a)
	res1 := a[0] * a[1]
	res2 := a[n-2] * a[n-1]

	if zeroPresent {
		if res1 < 0 {
			res1 = 0
		}
		if res2 < 0 {
			res2 = 0
		}
	}
	ans := res1
	if res2 > ans {
		ans = res2
	}
	fmt.Fprintln(out, ans)

}

func main() {
	in := bufio.NewReader(os.Stdin)
	out := bufio.NewWriter(os.Stdout)
	defer out.Flush()
	t := 1
	fmt.Fscan(in, &t)
	for t > 0 {
		t -= 1
		solve(in, out)
	}
}
