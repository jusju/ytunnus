package ohjelmat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class YTunnusTesteri {
	/*
	@BeforeEach
	void setUp() throws Exception {
	}
	*/

	@Test
	void testYTunnus1() {
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus("1572860-0"));
	}
	@Test
	void testYTunnus2() {
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus("0737546-2"));
	}

	@Test
	void testYTunnus3() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}
	@Test
	void testYTunnus4() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}
	@Test
	void testYTunnus5() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}
	@Test
	void testYTunnus6() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}
	@Test
	void testYTunnus7() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}
	@Test
	void testYTunnus8() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}
	@Test
	void testYTunnus9() {
		String yTunnus = YTunnusGeneraattori.generoiYTunnus();
		assertTrue(YTunnusGeneraattori.tarkistaYTunnus(yTunnus));
	}	
	
}
