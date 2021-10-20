#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#define TAM 1
typedef struct livro LIVRO;
struct livro {
	int caixa;
	char titulo[50];
	char autor[30];
	char ISBN[30];
	int ano;
	char editora[30];
	int exemQunt;
};
void incluir();
void livros();
void revistas();
void Caixa();
struct livro ficha[TAM];
int busca;
int main() {
	int i, j, acha, op;
	op = 0;

	while (op != 5) {
		for (i = 0; i < 80; i++) {
			printf("*");
		}
		printf("\t>>>>> JOAS LUIZ SANTOS CARDOSO <<<<<\n");
		printf("\t     >>>>> RA: 20026019-5 <<<<<\n");
		printf("\t >>>>> Engenharia de Software <<<<<\n");
		for (i = 0; i < 80; i++) {
			printf("*");
		}
		printf(" 1 - Incluir registros de obras\n");
		printf(" 2 - Listar todos os livros\n");
		printf(" 3 - Listar todas as revistas\n");
		printf(" 4 - Listar as obras por caixas\n");
		printf(" 5 - Sair\n");

		printf("Digite a opção desejada: ");
		scanf("%d", &op);
		fflush(stdin);
		switch (op) {
		case 1:
			incluir();
			break;
		case 2:
			livros();
			break;
		case 3:
			revistas();
			break;
		case 4:
			Caixa();

		case 0:
			printf("Finalizando Registros!!!\n");
			//getch();
			break;
		default:
			printf("Opcao Invalida!\n");
			//getch();
			break;
		}
	}
}
void incluir() {
	//int system("cls");
	for (int i = 0; i < TAM; i++) {
		setlocale(LC_ALL, "");
		int tipo;

		printf("  \n1 - Livro \n2 - Revista\nInforme o tipo:\n");
		scanf("%d", &tipo);

		if (tipo == 1) {
			printf("Informe a caixa: ");
			scanf("%d", &ficha[i].caixa);
			fflush(stdin);
			printf("Digite o titulo do livro: ");
			scanf("%50[^\n]s", &ficha[i].titulo);
			fflush(stdin);
			printf("Digite o nome do autor: ");
			scanf("%30[^\n]s", &ficha[i].autor);
			fflush(stdin);
			printf("Digite o nome do ISBN: ");
			scanf("%30[^\n]s", &ficha[i].ISBN);
			fflush(stdin);
			printf("Digite o ano: ");
			scanf("%d", &ficha[i].ano);
			fflush(stdin);
			printf("Digite o nome da editora: ");
			scanf("%30[^\n]s", &ficha[i].editora);
			fflush(stdin);
			printf("Digite a quantidade de exemplares: ");
			scanf("%d", &ficha[i].exemQunt);
			fflush(stdin);
		}
		if (tipo == 2) {
			printf("Informe o caixa: ");
			scanf("%d", &ficha[i].caixa);
			fflush(stdin);
			printf("Digite o titulo da revista: ");
			scanf("%50[^\n]s", &ficha[i].titulo);
			fflush(stdin);
			printf("Digite o nome do autor: ");
			scanf("%30[^\n]s", &ficha[i].autor);
			fflush(stdin);
			printf("Digite o nome do ISBN: ");
			scanf("%30[^\n]s", &ficha[i].ISBN);
			fflush(stdin);
			printf("Digite o ano: ");
			scanf("%d", &ficha[i].ano);
			fflush(stdin);
			printf("Digite o nome da editora: ");
			scanf("%30[^\n]s", &ficha[i].editora);
			fflush(stdin);
			printf("Digite a quantidade de exemplares: ");
			scanf("%d", &ficha[i].exemQunt);
			fflush(stdin);
		}
	}
}
void livros() {
	//int system("cls");
	for (int i = 0; i < TAM; i++) {
		printf("\nCAIXA: %d\n", ficha[i].caixa);
		printf("TÍTULO: %s\n", ficha[i].titulo);
		printf("AUTOR: %s\n", ficha[i].autor);
		printf("ISBN: %s\n", ficha[i].ISBN);
		printf("ANO: %d\n", ficha[i].ano);
		printf("EDITORA: %s\n", ficha[i].editora);
		printf("QUANTIDADE DE EXEMPLARES: %d\n", ficha[i].exemQunt);
	}
}
void revistas() {
	//int system("cls");
	for (int i = 0; i < TAM; i++) {
		printf("\nCAIXA: %d\n", ficha[i].caixa);
		printf("TÍTULO: %s\n", ficha[i].titulo);
		printf("AUTOR: %s\n", ficha[i].autor);
		printf("ISBN: %s\n", ficha[i].ISBN);
		printf("ANO: %d\n", ficha[i].ano);
		printf("EDITORA: %s\n", ficha[i].editora);
		printf("QUANTIDADE DE EXEMPLARES: %d\n", ficha[i].exemQunt);
	}
}

void Caixa() {
	//int system("cls");
	printf("Digite a caixa que deseja buscar: ");
	scanf("%d", &busca);
	int i = 0;
	int acha = 0;
	while ((i < TAM) && (acha == 0)) {
		if (ficha[i].caixa == busca)
			acha = 1;
		else
			i++;
	}
	if (acha == 1) {
		printf("\nCAIXA: %d\n", ficha[i].caixa);
		printf("TÍTULO: %s\n", ficha[i].titulo);
		printf("AUTOR: %s\n", ficha[i].autor);
		printf("ISBN: %s\n", ficha[i].ISBN);
		printf("ANO: %d\n", ficha[i].ano);
		printf("EDITORA: %s\n\n", ficha[i].editora);
		printf("QUANTIDADE DE EXEMPLARES: %d\n", ficha[i].exemQunt);

	} else {
		printf("\n Registro não encontrado\n");
	}
}

