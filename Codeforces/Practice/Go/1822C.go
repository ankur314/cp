package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
)

func solve(in io.Reader, out io.Writer) {
	
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