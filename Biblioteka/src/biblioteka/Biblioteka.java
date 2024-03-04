package biblioteka;

import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private List<Knjiga> knjige = new ArrayList<Knjiga>();
	
	@Override
	public void dodajKnjigu(Knjiga k) {
		if (k == null) 
			throw new NullPointerException("Knjiga ne sme biti null.");
		if (knjige.contains(k))
			throw new IllegalArgumentException("Knjiga vec postoji u biblioteci.");
		
		knjige.add(k);
	}

	@Override
	public void obrisiKnjigu(Knjiga k) {
		if (k == null) 
			throw new NullPointerException("Knjiga ne sme biti null.");
		if (!knjige.contains(k))
			throw new IllegalArgumentException("Knjiga ne postoji u biblioteci.");
		
		knjige.remove(k);
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
