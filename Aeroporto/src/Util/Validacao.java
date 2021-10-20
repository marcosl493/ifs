package Util;

import java.util.ArrayList;

public abstract class Validacao {
	public static boolean CPF(String cpf) {
		ArrayList<String> cpfa = new ArrayList<String>();
		ArrayList<String> cpffinal = new ArrayList<String>();
		for (int i = 0; i < cpf.length(); i++) {
			cpffinal.add(Character.toString(cpf.charAt(i)));
		}
		for (int i = 0; i < 9; i++) {
			cpfa.add(Character.toString(cpf.charAt(i)));
		}
		int cpfab = 0;
		int s = 0;
		int nums[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		for (int i = 0; i < cpfa.size(); i++) {
			cpfab = nums[i] * Integer.parseInt(cpfa.get(i));
			s += cpfab;
		}
		int resto = s % 11;
		int restonew = 11 - resto;
		int verif1 = 0;
		if (restonew <= 9) {
			verif1 = restonew;
		}
		int nums2[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		cpfa.add(Integer.toString(verif1));
		s = 0;
		int verif2 = 0;
		for (int i = 0; i < nums2.length; i++) {
			cpfab = nums2[i] * Integer.parseInt(cpfa.get(i));
			s += cpfab;
		}
		resto = s % 11;
		restonew = 11 - resto;
		if (restonew <= 9) {
			verif2 = restonew;
		}
		cpfa.add(Integer.toString(verif2));
		if (cpffinal.get(9).equals(Integer.toString(verif1)) && cpffinal.get(10).equals(Integer.toString(verif2))) {
			return true;
		} // by:MarcosVinicius
		return false;

	}

	public static boolean data(String escreverData) throws Exception {
		String validacaoData[] = new String[8];
		if (escreverData.length() == 8) {
			for (int i = 0; i < validacaoData.length; i++) {
				validacaoData[i] = Character.toString(escreverData.charAt(i));
			}
			if (validacaoData[2].equals("/") && validacaoData[5].equals("/")) {
				return true;
			}
		}
		return false;
	}

	public static boolean horario(String escreverHorario) throws Exception {
		String validacaoHorario[] = new String[5];
		if (escreverHorario.length() == 5) {
			for (int i = 0; i < validacaoHorario.length; i++) {
				validacaoHorario[i] = Character.toString(escreverHorario.charAt(i));
			}
			if (validacaoHorario[2].equals(":")) {
				return true;
			}
		}

		return false;
	}

}
