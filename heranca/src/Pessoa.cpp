/*
 * Pessoa.cpp
 *
 *  Created on: 20 de mar de 2020
 *      Author: marco
 */

#include "Pessoa.h"
#include <iostream>
#include <string>
namespace std {

Pessoa::Pessoa(string nome, string endereco, string datanascimento) {
	// TODO Auto-generated constructor stub
	this->nome = nome;
	this->endereco = endereco;
	this->datanascimento = datanascimento;
	cout<<"Construindo Pessoa"<<endl;
}
string Pessoa::getDataNascimento(){
	return Pessoa::datanascimento;
}
string Pessoa::getEndereco(){
	return endereco;
}
string Pessoa::getNome(){
	return nome;
}

} /* namespace std */
