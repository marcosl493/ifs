#include <iostream>
using namespace std;

int main() {
	int N, K;
	cin >> N >> K;
	int X[N];
	for (int var = 0; var < N; ++var) {
		cin >> X[var];
	}
	int s = 0;
	int qtd = 0;

	int aux = 0;
	for (int i = 0; i < N; i++) {
		aux = X[i];
		s += aux;

		if (s > K) {
			s = 0;
		}
		if (aux == K) {
			s = 0;
			qtd++;
		}
		if (s == K) {
			qtd++;
		}

	}
	cout << qtd << endl;

	return 0;
}
