package mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ע���뻺��
 * @author Administrator
 *
 */
public class TestMyBatis {

	public static void main(String[] args) throws IOException{
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		
		//һ����ѯ����
		//һ����ѯ������ÿһ�� SqlSession ���ʵ�������У�����һ�β�ѯĳһ������ʱ��SqlSession ���ʵ������Ὣ�����ݴ���һ����������
		//��û���յ��ı�����ݵ�����֮ǰ���û��ٴβ�ѯ�����ݣ�����ӻ����л�ȡ�����ݣ��������ٴ��������ݿ���в�ѯ��
		Emp emp0 = empMapper.getEmp(1);
		System.out.println(emp0.toString());
		
		Emp emp1 = empMapper.getEmp(1);
		System.out.println(emp1.toString());
		
		
		SqlSession session1 = factory.openSession();
		EmpMapper empMapper1 = session1.getMapper(EmpMapper.class);
		Emp emp2 = empMapper1.getEmp(1);
		System.out.println(emp2.toString());
		
//		Emp emp1 = new Emp("С��", 22, "��", 120000.0d);
//		empMapper.addEmp(emp1);
//		
//		Emp emp2 = new Emp();
//		emp2.setId(12);
//		emp2.setName("����");
//		empMapper.updateEmp(emp2);
//		
//		empMapper.deleteEmp(9);
//		
//		List<Emp> emps = empMapper.selectList();
//		for (Emp emp : emps) {
//			System.out.println(emp.toString());
//		}
//		
//		session.commit();
		session.close();
	}
}
