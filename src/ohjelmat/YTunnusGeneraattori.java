package ohjelmat;

import java.util.Random;

/**
 * Lähde: https://tarkistusmerkit.teppovuori.fi/tarkmerk.htm#y-tunnus2
 * 
 * @author Teemu Havulinna, Jukka Juslin
 *
 */

public class YTunnusGeneraattori {

	private static final Random random = new Random();

	public static String generoiYTunnus() {
		int numerot = random.nextInt(10_000_000);
		String alkuosa = String.format("%07d", numerot);
		int tarkistusNumero = laskeTarkistusNumero(alkuosa);
		if (tarkistusNumero >= 0) {
			return alkuosa + "-" + tarkistusNumero;
		} else {
			return generoiYTunnus();
		}
	}

	public static boolean tarkistaYTunnus(String yTunnus) {
		String muoto = "\\d{7}-\\d";

		if (!yTunnus.matches(muoto)) {
			return false;
		}

		String[] osat = yTunnus.split("-");
		String alku = osat[0];
		int tarkistus = Integer.parseInt(osat[1]);
		return tarkistus == laskeTarkistusNumero(alku);

	}

	private static int laskeTarkistusNumero(String alkuosa) {
		int[] kertoimet = { 7, 9, 10, 5, 8, 4, 2 };
		int summa = 0;

		for (int i = 0; i < kertoimet.length; i++) {
			int tulo = kertoimet[i] * Integer.parseInt(alkuosa.substring(i, i + 1));
			summa += tulo;
		}

		int jakojaannos = summa % 11;
		if (jakojaannos == 1) {
			// ei anneta tunnuksia, jotka tuottaisivat jakojäännöksen 1.
			return -1;
		} else if (jakojaannos == 0) {
			// jos jakojäännös on 0, tarkistusnumero on 0
			return 0;
		} else {
			// jos jakojäännös on 2..10, tarkistusnumero on 11 miinus jakojäännös
			return 11 - jakojaannos;
		}
	}

	public static void main(String[] args) {
		String yTunnus1 = "1572860-0";
		String yTunnus2 = "0737546-2";
		String yTunnus3 = "1572860-1";
		String yTunnus4 = "0737544-9";
		
		if (tarkistaYTunnus(yTunnus1)) {
			System.out.println("Y-tunnus 1572860-0 on validi.");
		} else {
			System.out.println("Y-tunnus 1572860-0 ei ole validi.");
		}

		if (tarkistaYTunnus(yTunnus2)) {
			System.out.println("Y-tunnus 0737546-2 on validi.");
		} else {
			System.out.println("Y-tunnus 0737546-2 ei ole validi.");
		}

		if (tarkistaYTunnus(yTunnus3)) {
			System.out.println("Y-tunnus 1572860-1 on validi.");
		} else {
			System.out.println("Y-tunnus 1572860-1 ei ole validi.");
		}

		if (tarkistaYTunnus(yTunnus4)) {
			System.out.println("Y-tunnus 0737544-9 on validi.");
		} else {
			System.out.println("Y-tunnus 0737544-9 ei ole validi.");
		}
		

		
		
		
		
	}
}
