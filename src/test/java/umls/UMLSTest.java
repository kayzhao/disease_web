package umls;

import static org.junit.Assert.*;

import org.junit.Test;

import base.SpringTest;

import com.csu.bio.util.PropertyConfigurer;
import com.csu.bio.util.UMLSProps;

/**
 *
 * @author kayzhao
 * @version
 */
public class UMLSTest extends SpringTest {

	
	@Test
	public void test() throws Exception {
		UMLSProps umlsProps = (UMLSProps) getBean("umlsProps");

		System.out.println("--- load property ----");
		System.out.println(umlsProps.toString());
		// fail("Not yet implemented");
	}
}
