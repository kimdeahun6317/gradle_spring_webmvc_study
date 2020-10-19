package gradle_spring_webmvc_study.config;


import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerConfig.class })
public class ContextSqlSessionTest {
	private static final Log log = LogFactory.getLog(ContextDataSource.class);

	@Autowired
	private SqlSessionFactory sessionFactory;

	@After
	public void testDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		SqlSession session = sessionFactory.openSession();
		log.debug("session " + session);
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testSqlConnection() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		SqlSession session = sessionFactory.openSession();
		Connection con = session.getConnection();
		log.debug("con " + con);
		Assert.assertNotNull(con);
	}

}
