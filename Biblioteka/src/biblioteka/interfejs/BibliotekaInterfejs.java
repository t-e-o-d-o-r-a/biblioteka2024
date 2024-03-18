package biblioteka.interfejs;

import java.time.LocalDateTime;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

/**
 * Predstavlja biblioteku sa knjigama.
 * 
 * Knjige se mogu dodavati, brisati i pretrazivati.
 * 
 * @author Teodora
 *
 */
public interface BibliotekaInterfejs {
	
	/**
	 * Dodaje knjigu u biblioteku.
	 * 
	 * Knjiga ne sme biti null i ne sme biti duplikat.
	 * 
	 * @param knjiga nova knjiga koja se dodaje
	 * 
	 * @return trenutni datum i vreme (kada je knjiga dodata)
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga vec postoji u biblioteci (duplikat)
	 */
	public LocalDateTime dodajKnjigu(Knjiga knjiga);
	
	/**
	 * Brise knjigu iz biblioteke.
	 * 
	 * Knjiga ne sme biti null i mora postojati u biblioteci.
	 * 
	 * @param knjiga knjiga koja se brise
	 * 
	 * @return trenutni datum i vreme (kada je knjiga obrisana)
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga ne postoji u biblioteci
	 */
	public LocalDateTime obrisiKnjigu(Knjiga knjiga);
	
	/**
	 * Vraca sve knjige iz biblioteke.
	 * 
	 * @return Lista sa svim knjigama, ili prazna lista ako u biblioteci nema knjiga (nije null)
	 */
	public List<Knjiga> vratiSveKnjige();
	
	/**
	 * Pretrazuje biblioteku i vraca knjige koje odgovaraju kriterijumima pretrage.
	 * 
	 * Mora da se unese bar jedan kriterijum pretrage.
	 * Pretraga se vrsi prema unetim kriterijumima, ali ne mora po svim.
	 * Ako se umesto kriterijuma unese null ili 0 (isbn), taj kriterijum se ne razmatra.
	 * 
	 * @param autor Autor knjige (ili jedan od autora)
	 * @param isbn isbn broj knjige (poredi se tacno po tom broju)
	 * @param naslov deo naslova knjige (nisu bitna velika i mala slova)
	 * @param izdavac deo naziva izdavaca (nisu bitna velika i mala slova)
	 * 
	 * @return Lista sa knjigama koje odgovaraju kriterijumima ili prazna lista ako takvih knjiga nema.
	 * 
	 * @throws java.lang.IllegalArgumentException ako nije unet ni jedan kriterijum za pretragu (svi su null ili 0 - isbn)
	 */
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac);

}
