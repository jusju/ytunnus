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
			if (tarkistusNumero == 0) {
				yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + "-0";
			}
		} else {
			tarkistusNumero = 11 - jakojaannos;
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
				if (tarkistusNumero == 0) {
					yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + "-0";
				}
			} else {
				tarkistusNumero = 11 - jakojaannos;
			}
		}

		yTunnuksenAlkuOsa = yTunnuksenAlkuOsa + "-" + tarkistusNumero; 
		System.out.println(yTunnuksenAlkuOsa);
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

		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();
		generoiYTunnus();

		/*
		 * if(tarkistaYTunnus(yTunnus1)) { System.out.println("Y-tunnus on validi."); }
		 * else { System.out.println("Y-tunnus ei ole validi."); }
		 * 
		 * if(tarkistaYTunnus(yTunnus2)) { System.out.println("Y-tunnus on validi."); }
		 * else { System.out.println("Y-tunnus ei ole validi."); }
		 */
	}
}
