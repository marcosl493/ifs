/*
 * Aluno.cpp
 *
 *  Created on: 21 de mar de 2020
 *      Author: marco
 */
#include <iostream>
#include "Aluno.h"
#include <string>
namespace std {

Aluno::Aluno(string nome, string endereco, string dataNascimento, string curso, int semestre) : Pessoa(nome, endereco, dataNascimento){
	cout<<"Construindo Pessoa"<<endl;
	this->curso = curso;
	this->semestre = semestre;

}

string Aluno::getCurso(){
	return curso;
}
int Aluno::getSemestre(){
	return semestre;
}
void Aluno::setCurso(string curso){
	this->curso = curso;
}
void Aluno::setSemestre(int semestre){
	this->semestre = semestre;
}
} /* namespace std */
