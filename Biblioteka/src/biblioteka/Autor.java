package biblioteka;

import java.util.Objects;

public class Autor {

	//javni tekst
	private String ime;
	private String prezme;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezme() {
		return prezme;
	}
	public void setPrezme(String prezme) {
		this.prezme = prezme;
	}
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezme=" + prezme + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezme);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezme, other.prezme);
	}
	
	
	
}
