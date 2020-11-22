/*
	Snippet for range sum query using segment trees
	Methods:
		update(array_size, index_to_update, value_to_update, array)
		query(array_size, query_start, query_end)
*/

#define ARRAY_SIZE 1e5

long segTree[4 * (int)ARRAY_SIZE + 5];

void updateUtil(int node, int start, int end, int idx, int val, int A[]) {
	if (start == end) {
		segTree[node] += val;
		A[start] += val;
		return;
	}

	int mid = (start + end) / 2;

	if (start <= idx && idx <= mid) {
		updateUtil(2 * node + 1, start, mid, idx, val, A);
	} else {
		updateUtil(2 * node + 2, mid + 1, end, idx, val, A);
	}

	segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
}

long queryUtil(int node, int start, int end, int l, int r) {
	if (start > r || end < l) {
		return 0;
	} else if (l <= start && end <= r) {
		return segTree[node];
	} else {
		int mid = (start + end) / 2;
		return (queryUtil(2 * node + 1, start, mid, l, r) + queryUtil(2 * node + 2, mid + 1, end, l, r));
	}
}

void update(int array_size, int index_to_update, int value_to_update, int array[]) {
	updateUtil(0, 0, array_size - 1, index_to_update, value_to_update, array);
}

long query(int array_size, int query_start, int query_end) {
	return queryUtil(0, 0, array_size - 1, query_start, query_end);
}