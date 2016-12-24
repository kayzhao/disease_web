package umls;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import base.SpringTest;

import com.csu.bio.common.constants.PropertyConfigurer;
import com.csu.bio.util.UMLSProps;
import com.csu.bio.util.web.MyApplicationContext;

/**
 *
 * @author kayzhao
 * @version
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext-props.xml" })
public class UMLSTest {

	@Test
	public void test() throws Exception {
		UMLSProps umlsProps = (UMLSProps) MyApplicationContext.getBean(UMLSProps.class);

		System.out.println("--- load property ----");
		System.out.println(umlsProps.toString());
		// fail("Not yet implemented");
	}
}
