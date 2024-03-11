package biblioteka;


import biblioteka.interfejs.BibliotekaInterfejs;
import biblioteka.interfejs.BibliotekaInterfejsTest;

class BibliotekaTest extends BibliotekaInterfejsTest {

	@Override
	public BibliotekaInterfejs getInstance() {
		return new Biblioteka();
	}

}
