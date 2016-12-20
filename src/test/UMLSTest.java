import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.csu.bio.api.umls.content.RetrieveCui;

/**
 *
 * @author kayzhao
 * @version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/root-context.xml" })
public class UMLSTest {

	@Autowired
	RetrieveCui rc;

	@Test
	public void test() throws Exception {
		rc.retrieveCui();
		fail("Not yet implemented");

	}

}
