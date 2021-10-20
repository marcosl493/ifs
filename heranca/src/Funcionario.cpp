/*
 * Funcionario.cpp
 *
 *  Created on: 23 de mar de 2020
 *      Author: marco
 */

#include "Funcionario.h"
#include "Pessoa.h"
namespace std {

Funcionario::Funcionario(string nome, string endereco, string dataNascimento, double salario, string cargo) : Pessoa(nome, endereco,dataNascimento){
	// TODO Auto-generated constructor stub
	this->cargo = cargo;
	this->salario = salario;
}
string Funcionario::getCargo(){
	return cargo;
}
double Funcionario::getSalario(){
	return salario;
}

} /* namespace std */
