package etapa1_prova;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computador pc1 = new Computador("Processador Intel Core i5 10400", 16, "Colorful BATTLE-AX Z490AK GAMING V20", false,3500,
				"Gamer Razer Cynosa V2 Chroma RGB, Membrana, Black", 
				"Gamer Dazz Legacy RGB, 6400 DPI, 3 Botões Programáveis, BlackCÓD: Dazz Legacy");
		System.out.println(pc1.ToString());
		Computador pc2 = new Computador();
		System.out.println(pc2.ToString());
		Computador pc3 = new Computador("AMD Ryzen 5 3400G 3.7GHz (4.2GHz Turbo), 4-Cores 8-Threads",16,"Gigabyte A520MH, AMD, DDR4, AM4",2500);
		pc3.setPreco(2700);
		System.out.println(pc3.ToString());
	}
}
