/*
 * Funcionario.h
 *
 *  Created on: 23 de mar de 2020
 *      Author: marco
 */

#ifndef FUNCIONARIO_H_
#define FUNCIONARIO_H_
#include  <string>
#include "Pessoa.h"
namespace std {

class Funcionario : public Pessoa{
private:
	double salario;
	string cargo;
public:
	void setSalario(double sal);
	void setCargo(string cargo);
	double getSalario();
	string getCargo();
	Funcionario(string nome,string endereco, string dataNascimento,double salario,string cargo);
};

} /* namespace std */

#endif /* FUNCIONARIO_H_ */
