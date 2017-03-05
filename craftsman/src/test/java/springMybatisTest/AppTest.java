package springMybatisTest;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;

import junit.framework.TestCase;


public class AppTest extends TestCase{
	@Test
    public void testApp() throws SQLException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminBiz ab = (AdminBiz) ac.getBean("adminBizImpl");
		Admin admin = new Admin();
		admin.setAdmintbName("admin");
		admin.setAdmintbPassword("admin");
		System.out.println(ab.getAdmin(admin));
    }
	
}
