package test.mybatis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xiaoming.userLinkInfo.model.UserLinkInfo;

public class TestSelect {
	@Test
	public void test1() throws IOException{
		Object m = null;
		String t = (String)m;
		System.out.println("null".equals(t));
		InputStream inputStream = Resources.getResourceAsStream("config/test.xml");  
		
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  
        SqlSessionFactory factory = builder.build(inputStream);  
          
        //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作  
        SqlSession sqlSession = factory.openSession();  
      
        //3.使用SqlSession查询  
        Map<String,Object> params = new HashMap<String,Object>();  
          
        //a.查询数据
        List<UserLinkInfo> result = sqlSession.selectList("com.xiaoming.userLinkInfo.dao.UserLinkInfoDao.findList",params);  
        System.out.println("数据量："+result.size());  
        //~output :   查询到的数据总数：5    
	}
	@Test
	public void test2(){
		int i=1;
		i=+i++;
		System.out.println(i);
	}
}
