#include <iostream>
using namespace std;

int main() {
	int D;
	cin >> D;
	int soma = 3;
	int ind = 0;
	while (soma <= D) {
		ind++;
		soma++;
		if (ind == 8) {
			ind = 0;
		}
		if (soma == D) {
			ind -= 2;
			if (ind == 1) {
				cout << 1 << endl;
			} else if (ind == 2) {
				cout << 2 << endl;
			} else if (ind == 3) {
				cout << 3 << endl;
			}
		}
	}
	return 0;
}
