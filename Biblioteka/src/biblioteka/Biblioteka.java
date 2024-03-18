package biblioteka;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;
import util.VremenskiServis;

/**
 * Implementira BibliotekaInterfejs preko liste sa knjigama (ArrayList)
 * 
 * @author Teodora
 *
 */
public class Biblioteka implements BibliotekaInterfejs {

	/**
	 * Lista svih knjiga, sa ArrayList kao implementacijom
	 */
	private List<Knjiga> knjige = new ArrayList<Knjiga>();
	
	/**
	 * Vremenski servis koji se poziva za trenutno vreme.
	 */
	private VremenskiServis s;
	
	/**
	 * Inicijalizuje biblioteku i postavlja vremenski servis.
	 * 
	 * @param s vremenski servis koji ce biblioteka da koristi.
	 */
	public Biblioteka(VremenskiServis s) {
		this.s = s;
	}
	
	@Override
	public LocalDateTime dodajKnjigu(Knjiga k) {
		if (k == null) 
			throw new NullPointerException("Knjiga ne sme biti null.");
		if (knjige.contains(k))
			throw new IllegalArgumentException("Knjiga vec postoji u biblioteci.");
		
		knjige.add(k);

		return s.vratiVreme("Beograd");
	}

	@Override
	public LocalDateTime obrisiKnjigu(Knjiga k) {
		if (k == null) 
			throw new NullPointerException("Knjiga ne sme biti null.");
		if (!knjige.contains(k))
			throw new IllegalArgumentException("Knjiga ne postoji u biblioteci.");
		
		knjige.remove(k);
		
		return s.vratiVreme("Beograd");
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn == 0 && naslov == null && izdavac == null) 
			throw new IllegalArgumentException("Morate uneti bar jedan kriterijum.");
		
		List<Knjiga> rezultati = new ArrayList<Knjiga>();
		for (Knjiga k : knjige) {
			if (k.getNaslov().toUpperCase().contains(naslov.toUpperCase())) {
				rezultati.add(k);
			}
		}
		
		return rezultati;
	}

}
