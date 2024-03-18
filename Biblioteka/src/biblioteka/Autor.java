package biblioteka;

import java.util.Objects;

/**
 * Predstavlja autora knjige.
 * 
 * Autor ima ime i prezime.
 * 
 * @author Teodora
 * @version 1.0
 *
 */
public class Autor {
	
	/**
	 * Ime autora kao String
	 */
	private String ime;
	
	/**
	 * Prezime autora kao String
	 */
	private String prezime;
	
	/**
	 * Pravi nov objekat klase Autor.
	 * 
	 * Ime i prezime ostaju neinicijalizovani.
	 */
	public Autor() {
	}
	
	
	/**
	 * Pravi novog autora i postavlja ime i prezime na unete vrednosti.
	 * 
	 * @param ime ime autora kao String
	 * @param prezime prezime autora kao String
	 */
	public Autor(String ime, String prezime) {
		this.setIme(ime);
		this.setPrezime(prezime);
	}
	
	/**
	 * Vraca ime autora
	 * 
	 * @return trenutno ime autora kao String
	 */
	public String getIme() {
		return ime;
	}
	
	/**
	 * Postavlja ime autora na unetu vrednost.
	 * 
	 * Uneto ime ne sme biti null niti prazan String.
	 * 
	 * @param ime ime autora kao String
	 * 
	 * @throws java.lang.NullPointerException ako je uneto ime null
	 * @throws java.lang.IllegalArgumentException ako je uneto ime prazan String
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null.");
		if (ime.isEmpty()) 
			throw new IllegalArgumentException("Ime ne sme biti prazno.");
		
		this.ime = ime;
	}
	
	/**
	 * Vraca prezime autora
	 * 
	 * @return trenutno prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}
	
	/**
	 * Postavlja prezime autora na unetu vrednost.
	 * 
	 * Uneto prezime ne sme biti null niti prazan String.
	 * 
	 * @param prezime prezime autora kao String
	 * 
	 * @throws java.lang.NullPointerException ako je uneto prezime null
	 * @throws java.lang.IllegalArgumentException ako je uneto prezime prazan String
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null.");
		if (prezime.isEmpty()) 
			throw new IllegalArgumentException("Prezime ne sme biti prazno.");
		
		this.prezime = prezime;
	}
	
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}
	
	/**
	 * Poredi dva autora prema imenu i prezimenu.
	 * 
	 * @param obj Drugi autor sa kojim se poredi
	 * 
	 * @return 
	 * <ul>
	 * 	<li><b>true</b> - ako su oba objekta inicijalizovana, klase su Autor
	 * i imaju isto ime i prezime</li>
	 * 	<li><b>false</b> - ako nisu klase Autor, ako je uneti autor null ili ako nije isto ime ili prezime</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}
	
	
	
}
