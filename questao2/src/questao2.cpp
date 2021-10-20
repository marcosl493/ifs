//============================================================================
// Name        : questao2.cpp
// Author      : Marcos
// Version     :
// Copyright   : Tanto faz
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int N,F;
	cin>>N>>F;
	char matriz[N][N];
	for (int var = 0; var < N; ++var) {
		for (int j = 0; j < N; ++j) {
			cin>>matriz[var][j];
		}
	}
	char matrizok[N][N];
	int n;
	for (int var = 0; var < N; ++var) {
				for (int j = 0; j < N; ++j) {
					n = (int)matriz[var][j];
					if(n<=F){
						matrizok[var][j] = '*';
					}else{
						matrizok[var][j] = matriz[var][j];
					}
				}
			}
	for (int var = 0; var < N; ++var) {
			for (int j = 0; j < N; ++j) {
				cout<<matrizok[var][j];
			}
			cout<<endl;
		}

	return 0;
}
