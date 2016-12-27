package base;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.mongodb.gridfs.GridFSDBFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext-*.xml" })
public class GridfsTest {

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@Test
	public void getGridfsByFileNameTest() {
		String fileName = "MESH:C531617_genes_1481955794.173352.pyobj";
		Map fs = cFsDao.getFileByFileName(fileName).toMap();
		for (Object s : fs.keySet()) {
			System.out.println(s + ":" + fs.get(s));
		}
		System.out.println("success");
	}
}