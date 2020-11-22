/*
	Declaration: TrieNode* root = new TrieNode();
	Methods:
		insert(root, pattern)
		search(root, pattern)
*/

#define ALPHABET_SIZE 26

struct TrieNode {
	TrieNode* children[ALPHABET_SIZE];
	bool isLeaf;

	TrieNode() {
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			children[i] = NULL;
		}
		isLeaf = false;
	}
};

void insert(TrieNode* root, string word) {
	TrieNode* ptr = root;
	int n = word.length();

	for (int i = 0; i < n; i++) {
		if(ptr->children[(word[i] - 'a')] == NULL) {
			TrieNode* newNode = new TrieNode();
			ptr->children[(word[i] - 'a')] = newNode;
		}

		ptr = ptr->children[(word[i] - 'a')];
	}

	ptr->isLeaf = true;
}

bool search(TrieNode* root, string word) {
	TrieNode* ptr = root;
	int n = word.length();

	for (int i = 0; i < n; i++) {
		if(ptr->children[(word[i] - 'a')]) {
			ptr = ptr->children[(word[i] - 'a')];
		} else {
			return false;
		}
	}

	return ptr->isLeaf;
}