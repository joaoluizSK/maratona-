import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		while (sc.hasNext()) {
			double valorAposta = sc.nextDouble();
			int numeroApostado = sc.nextInt();
			int numeroSorteado = sc.nextInt();
			if (valorAposta == 0.0 & numeroApostado == 0 && numeroSorteado == 0) {
				break;
			}
			System.out.println(calcular(valorAposta, numeroApostado + "", numeroSorteado + ""));
		}

	}

	public static String adicionarZero(String numero) {
		if (numero.length() < 4) {
			numero = "0" + numero;
			numero = adicionarZero(numero);
		}
		return numero;
	}

	public static String calcular(double valorAposta, String numeroAposta, String numeroSorteado) {

		if (compararNumeros(adicionarZero(numeroAposta), adicionarZero(numeroSorteado), 4)) {
			return String.format("%.2f", valorAposta * 3000.00).replace(",", ".");
		}

		if (compararNumeros(adicionarZero(numeroAposta), adicionarZero(numeroSorteado), 3)) {
			return String.format("%.2f", valorAposta * 500.00).replace(",", ".");
		}

		if (compararNumeros(adicionarZero(numeroAposta), adicionarZero(numeroSorteado), 2)) {
			return String.format("%.2f", valorAposta * 50.00).replace(",", ".");
		}

		if (calcularGrupo(adicionarZero(numeroAposta)) == calcularGrupo(adicionarZero(numeroSorteado))) {
			return String.format("%.2f", valorAposta * 16.00).replace(",", ".");
		}

		return "0.00";
	}

	public static boolean compararNumeros(String numero1, String numero2, int qtde) {
		return (numero1.substring(numero1.length() - qtde, numero1.length())
				.equals(numero2.substring(numero2.length() - qtde, numero2.length())));
	}

	public static int calcularGrupo(String numero) {
		String pedaco = numero.substring(numero.length() - 2, numero.length());
		int numeroInt = Integer.parseInt(pedaco);
		if (numeroInt == 0) {
			return 24;
		}
		return (numeroInt - 1) / 4;
	}
}
