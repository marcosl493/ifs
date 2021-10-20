/*
 * Pessoa.h
 *
 *  Created on: 20 de mar de 2020
 *      Author: marco
 */

#ifndef PESSOA_H_
#define PESSOA_H_
#include <string>
namespace std {

class Pessoa {
private:
   string nome;
   string endereco;
   string datanascimento;

public:
   	  void setNome(string nome);
      void setEndereco(string endereco);
      void setDataNascimento(string datanascimento);
      string getNome();
      string getEndereco();
      string getDataNascimento();
      Pessoa(string nome, string endereco, string datanascimento);


};

} /* namespace std */

#endif /* PESSOA_H_ */
