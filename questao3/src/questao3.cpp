//============================================================================
// Name        : questao3.cpp
// Author      : Marcos
// Version     :
// Copyright   : Tanto faz
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int N, M;
	cin >> N >> M;
	int I, R;
	cin >> I >> R;
	int A;
	bool vetorAmigoo[N];
	for (int var = 0; var < N; ++var) {
		vetorAmigoo[var] = false;
	}
	vetorAmigoo[I - 1] = true;
	for (int i = 0; i < M; ++i) {
		cin >> A;
		int P[A];
		for (int var = 0; var < A; ++var) {
			cin >> P[var];
		}
		if (i >= (R - 1)) {
			for (int i = 0; i < A; i++) {
				if (P[i] == I || vetorAmigoo[P[i] - 1] == true) {

					for (int k = 0; k < A; k++) {
						vetorAmigoo[P[k] - 1] = true;
					}
				}
			}
		}

	}
	int s = 0;
	for (int var = 0; var < N; ++var) {
		if (vetorAmigoo[var]) {
			s += 1;
		}
	}
	cout << s << endl;
	return 0;
}
