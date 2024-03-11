package biblioteka;


import java.time.LocalDateTime;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import biblioteka.interfejs.BibliotekaInterfejs;
import biblioteka.interfejs.BibliotekaInterfejsTest;
import util.VremenskiServis;

@ExtendWith(EasyMockExtension.class)
class BibliotekaTest extends BibliotekaInterfejsTest {

	@Override
	public BibliotekaInterfejs getInstance() {
		
		VremenskiServis s = EasyMock.mock(VremenskiServis.class); //mock je staticka metoda, treba da se dobije nazad lazni objekat klase
		
		EasyMock.expect(s.vratiVreme("Beograd")).andReturn(LocalDateTime.now());  //pisemo sta ocekujemo da ova metoda vrati kada se pozove
		EasyMock.expect(s.vratiVreme(null)).andReturn(null);
		
		EasyMock.replay(s);  //objekat je pripremljen
		
		return new Biblioteka(s);
	}

}
