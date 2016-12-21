import static org.junit.Assert.*;

import org.junit.Test;

import com.csu.bio.util.PropertyConfigurer;

/**
 *
 * @author kayzhao
 * @version
 */
public class UMLSTest extends SpringTest {

	@Test
	public void test() throws Exception {
		System.out.println(PropertyConfigurer.getProperty("umls.user.apikey"));
		fail("Not yet implemented");
	}
}
