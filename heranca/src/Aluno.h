/*
 * Aluno.h
 *
 *  Created on: 21 de mar de 2020
 *      Author: marco
 */

#ifndef ALUNO_H_
#define ALUNO_H_
#include <string>
#include "Pessoa.h"
namespace std {

class Aluno : public Pessoa{
private:
	string curso;
	int semestre;
public:
	void setCurso(string curso);
	void setSemestre(int semestre);
	string getCurso();
	int getSemestre();
	Aluno(string nome, string endereco, string dataNascimento, string curso, int semestre);
};

} /* namespace std */

#endif /* ALUNO_H_ */
