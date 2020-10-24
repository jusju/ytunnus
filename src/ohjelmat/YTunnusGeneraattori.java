package ohjelmat;

import java.util.Random;

/**
 * Lähde: https://tarkistusmerkit.teppovuori.fi/tarkmerk.htm#y-tunnus2
 * 
 * @author Jukka Juslin
 *
 */

public class YTunnusGeneraattori {

	public static String generoiYTunnus() {
		Random random = new Random();
		String yTunnuksenAlkuOsa = "";
		for (int i = 0; i < 7; i++) {
			int yksiLuku = random.nextInt(10);
			yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + yksiLuku;
		}

		int[] kertoimet = { 7, 9, 10, 5, 8, 4, 2 };
		int tulojenSumma = 0;
		for (int i = 0; i < kertoimet.length; i++) {
			int kertolasku = kertoimet[i] * Integer.parseInt(yTunnuksenAlkuOsa.charAt(i) + "");
			tulojenSumma = tulojenSumma + kertolasku;
		}
		int jakojaannos = tulojenSumma % 11;
		int tarkistusNumero = 1;
		if (jakojaannos == 0) {
			yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + "-0";
			return yTunnuksenAlkuOsa;
		} else if (jakojaannos >= 2 && jakojaannos <= 10) {
			tarkistusNumero = 11 - jakojaannos;
		} else {
			tarkistusNumero = 1;
		}
		while (tarkistusNumero == 1) {
			yTunnuksenAlkuOsa = "";
			for (int i = 0; i < 7; i++) {
				int yksiLuku = random.nextInt(10);
				yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + yksiLuku;
			}

			tulojenSumma = 0;
			for (int i = 0; i < kertoimet.length; i++) {
				int kertolasku = kertoimet[i] * Integer.parseInt(yTunnuksenAlkuOsa.charAt(i) + "");
				tulojenSumma = tulojenSumma + kertolasku;
			}
			jakojaannos = tulojenSumma % 11;
			tarkistusNumero = 1;
			if (jakojaannos == 0) {
				yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + "-0";
				return yTunnuksenAlkuOsa;				

			} else if (jakojaannos >= 2 && jakojaannos <= 10) {
				tarkistusNumero = 11 - jakojaannos;
			} else {
				tarkistusNumero = 1;
			}
		}

		yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + "-" + tarkistusNumero;
		// System.out.println(yTunnuksenAlkuOsa);
		return yTunnuksenAlkuOsa;
	}

	public static boolean tarkistaYTunnus(String yTunnus) {
		int[] kertoimet = { 7, 9, 10, 5, 8, 4, 2 };
		int tulojenSumma = 0;
		for (int i = 0; i < kertoimet.length; i++) {
			int kertolasku = kertoimet[i] * Integer.parseInt(yTunnus.charAt(i) + "");
			tulojenSumma = tulojenSumma + kertolasku;
		}
		int jakojaannos = tulojenSumma % 11;
		int tarkistusNumero = Integer.parseInt((yTunnus.charAt(8) + ""));
		if (jakojaannos == 0) {
			if (tarkistusNumero == 0) {
				return true;
			}
		} else if (tarkistusNumero >= 2 && tarkistusNumero <= 9) {
			if (tarkistusNumero == (11 - jakojaannos)) {
				return true;
			}
		} else {
			return false;
		}
		return false;
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

	}
}
