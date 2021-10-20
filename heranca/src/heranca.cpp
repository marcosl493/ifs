
#include <iostream>
using namespace std;
#include "Aluno.h"
#include "Funcionario.h"
int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	Aluno a1("jubil","aaaaa","ndddhd"," dsdsd",1);
	cout<<a1.getNome()<<endl;
	cout<<a1.getCurso()<<endl;
	cout<<a1.getDataNascimento()<<endl;
	cout<<a1.getEndereco()<<endl;
	cout<<a1.getSemestre()<<endl;
	Funcionario func("atilakw","ruansysydys","17/01/1995",2500.50,"Acessor");
	cout<<func.getNome()<<endl;
	cout<<func.getCargo()<<endl;
	cout<<func.getDataNascimento()<<endl;
	cout<<func.getEndereco()<<endl;
	cout<<func.getSalario()<<endl;
	return 0;
}
