package examples;

public class Metodos {
	
public static double soma(double a, double b) {
	return a+b;
}
public static double subtracao(double a, double b) {
	return a-b;
}
public static double multiplicacao(double a, double b) {
	return a*b;
}
public static double divisao(double a, double b) {
	return a/b;
}
public static int fibonacci(int i) {
	int fibbo[] = new int[i];
	for (int j = 0; j < fibbo.length; j++) {
		fibbo[j]=1;
	}
	for (int j = 2; j < fibbo.length; j++) {
		fibbo[j]=fibbo[j-1]+fibbo[j-2];
	}
	return fibbo[i-1];
}public static int N_Termo(int i) {
	int Ntermo[] = new int[i];
	int razao = 2;
	Ntermo[0]=1;
	for (int j = 1; j < Ntermo.length; j++) {
		Ntermo[j]=Ntermo[j-1]+razao;
		razao++;
	}
	return Ntermo[i-1];
}public static int primo(int a) {
	int cont=0;
	for (int i = 1; i <=a; i++) {
		if(a%i==0) {
			cont++;
		}
	}if (cont==2) {
		return 1;
	}
	return 0;
}public static int par_impar(int i) {
	if(i%2!=0) {
		return 1;
	}
	return 0;
}
public static int fatorial(int i) {
	int fat=1;
	int vetor[] = new int[i];
	int cont=i;
	int r=0;
	for (int j = 0; j < vetor.length; j++) {
		vetor[j]=cont-r;
		r++;
	}	
	for (int j = 0; j < vetor.length; j++) {
		fat*=vetor[j];
	}
	for (int j = 0; j < vetor.length; j++) {
		//System.out.println(vetor[j]);
		
	}
	
	
	return fat;
	
}public static String classificacao_triangulo(int a,int b,int c) {
	
	if(Math.abs(b-c) < a &&  a<b + c &&
			Math.abs(a-c)  < b && b< a + c&&
			Math.abs(a-b) < c&& c<a + b) {
		if(a<90&& b<90&& c<90 ) {
			return "Agudo";
		}if(a==90 || b==90 || c==90) {
			return "Reto";
		}if(a>90 || b>90 || c>90) {
			return "Obtuso";
		}
	}else {
	return "Não forma um triangulo";
	}return"";
	}
public static double fumante(int anos, int ncigarro, double preco) {
	
	double reais=((preco/20)*ncigarro)*(anos*365);
	return reais;
}
public static double iluminacao(int potencialp, double largura, double comprimento) {
	double mq = largura*comprimento;
	double whattsn=mq*18;
	int lampn=1;
	int cont=0;
	if(whattsn>=18) {
		for (int i = 18; i < whattsn; i++) {
			if(cont==18) {
				cont=0;
				lampn++;
			}cont++;
		}
	}
	
	return lampn;
}
public static double pedreiro( double largura, double altura) {
	double mq = (largura*altura);
	int blocon=0;
	int cont=0;
	for (double i = 0; i <= mq; i++) {
		cont++;
		if(cont==2) {
			cont=0;
			blocon++;
		}
	}
	return blocon;
}

}
