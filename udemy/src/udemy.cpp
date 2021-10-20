//============================================================================
// Name        : udemy.cpp
// Author      : Marcos
// Version     :
// Copyright   : meeee
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string.h>
using namespace std;
int my_strlen(char * str){
	int len = 0;
	while(*str!='\0'){
		str++;
		len++;
	}
	return len;
}
char *my_strcat(char * dest, char * orig){
	char * resultado = new char[my_strlen(dest)+my_strlen(orig)];
	char *p_str = resultado;
	while(*dest != '\0'){
		*p_str = *dest;
		 p_str++;
		 dest++;
	}
	while(*orig != '\0'){
			*p_str = *orig;
			 p_str++;
			 orig++;
		}

	return resultado;
}
int main() {
	char * nome1 = new char[100];
	char * nome2 = new char[100];

	cout<<"Digite o nome 1"<<endl;
	cin>>nome1;
	cout<<"Digite o nome "<<endl;
	cin >> nome2;
	//char * resultado = my_strcat(nome1,nome2);
	cout<<"Resultado: "<<my_strcat(nome1,nome2);
	/*Imprimir ao contrário
	 * char nome[100];
	int tam;
	char* p;
	char* pini;

	cout<<"Digite uma string"<<endl;
	cin>>nome;

	tam = strlen(nome);
	p = &nome[tam-1];
	pini = &nome[0];
	while(true){
		cout<< *p;
		if(p==pini){
			break;
	} p--;
	}

	cout<<endl;
*/

	return 0;
}
