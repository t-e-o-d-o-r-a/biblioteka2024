package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	
	Autor a;

	//testovi treba da budu medjusobno nezavisni
	
	@BeforeEach
	void setUp() throws Exception { //ono sto se izvrsi pre svakog testa
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception { //ono sto se izvrsi posle svakog testa
		a = null; //odma kao da dereferenciramo objekat
	}

	@Test
	void testAutor() {
		assertNotNull(a); //da objekat nije null
		assertNull(a.getIme()); //da ime nije null
		assertNull(a.getPrezime()); //da prezime nije null
	}

	@Test
	void testAutorStringString() {
		//konstruktor se testira tako sto se napravi objekat te klase pomocu njega
		a = new Autor("Pera", "Peric");
		
		assertNotNull(a);
		assertEquals("Pera", a.getIme()); //ocekivana vr, stvarna vr - to prosledjujemo
		assertEquals("Peric", a.getPrezime());
	}

	@Test
	void testSetIme() {
		a.setIme("Zika");
		
		assertEquals("Zika", a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		Exception e = assertThrows(java.lang.NullPointerException.class, 
				() -> a.setIme(null) //motoda koja treba da se izvrsi inace
				);
		
		assertEquals("Ime ne sme biti null.", e.getMessage()); //provera i poruke ali ne mora
	}
	
	@Test
	void testSetImePrazanString() {
		Exception e = assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setIme("") //motoda koja treba da se izvrsi inace
				);
		
		assertEquals("Ime ne sme biti prazno.", e.getMessage()); //provera i poruke ali ne mora
	}

	@Test
	void testSetPrezime() {
		a.setPrezime("Zikic");
		
		assertEquals("Zikic", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setPrezime(null));
	}
	
	@Test
	void testSetPrezimePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setPrezime(""));
	}

	@Test
	void testToString() {
		a.setIme("Mika");
		a.setPrezime("Mikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Mika"));
		assertTrue(s.contains("Mikic"));
	}

	@Test
	void testEqualsObject() {
		Autor b = a; //da bude skroz sigurno da su iste adrese
		assertTrue(a.equals(b));  //ako je isti objekat
	}
	
	@Test
	void testEqualsObjectNull() {
		assertFalse(a.equals(null));
	}
	
	@Test
	void testEqualsObjectDrugaKlasa() {
		assertFalse(a.equals(new Knjiga())); //da li je neka druga klasa
	}
	
	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Mikic, false"
	})
	void testEqualsObjectSveOk(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
		//porede se dva autora
		//1 scenario, 4 situacije
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor a2 = new Autor(ime2, prezime2);

		assertEquals(eq, a.equals(a2));  //sta hocemo da bude, sta ce biti
	}

}
