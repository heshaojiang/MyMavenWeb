package test.mock;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.xiaoming.test.TestController;
import com.xiaoming.test.dao.TestDao;

public class MockUseTest {
	@Test
	public void firstTest(){
		IMocksControl control = EasyMock.createControl();
		HttpServletRequest request = control.createMock(HttpServletRequest.class);
		request.getParameter("name");
		EasyMock.expectLastCall().andReturn("heshaojiang");
		request.getParameter("password");
		EasyMock.expectLastCall().andReturn("123");
		control.replay();
		Assert.assertEquals(true, verfication(request));
		control.verify();
	}
	public static boolean verfication(HttpServletRequest request){
		if(request.getParameter("name").equals("heshaojiang")&&request.getParameter("password").equals("123")) return true;
		return false;
	}
	@Test
	public void testDao(){
		IMocksControl control = EasyMock.createControl();
		TestDao dao = control.createMock(TestDao.class);
		dao.getUser("bfd7f1dfe46c4a0faaf59b304d23aaed");
		Map map = new HashMap();
		map.put("username", "12");
		EasyMock.expectLastCall().andReturn(map);
		control.replay();
		
		Class<?> class1;
		Object t = null;
		try {
			class1 = Class.forName("com.xiaoming.test.TestController");
			//创建实例
	        t = class1.newInstance();
	        Field idField = class1.getDeclaredField( "dao" ) ;
	        idField.setAccessible( true );
	        idField.set(t, dao);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map m = ((TestController)t).getData();
		Assert.assertEquals("12", m.get("username"));
		control.verify();
	}
	@Ignore
	@Test
	public void testController(){
		/*IMocksControl control = EasyMock.createControl();
		IndiController c = control.createMock(IndiController.class);
		//com.jfinal.core.Controller m = c; 
		c.getPara("fromCity");
		EasyMock.expectLastCall().andReturn("true");
		control.replay();
		Assert.assertEquals(true, c.fromCity());*/
	}
}
