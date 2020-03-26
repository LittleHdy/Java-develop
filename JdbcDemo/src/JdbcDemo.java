import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;


//ParparedStatement�ŵ�
//1.��ߴ���Ŀɶ��ԺͿ�ά���� 
//2.�������(PreparedStatement�л���)
//3.��߰�ȫ��(SQLע��)
//select * form user wher name='xx' and pwd='xx' => select * from user where name='xx' and pwd='xx' or '1'='1'

public class JdbcDemo {

	private final static String URL="jdbc:mysql://localhost:3306/mydb";
	private final static String USERNAME="root";
	private final static String PASSWORD="root";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//insert();
		//update();
		//delete();
		//insert2();
		insert3();
		//update2();
		//transaction();
		//query();
	}

	private static void insert(){
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���ݿ�����
			Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//sql���
			String sql="insert into emp(name,gender,salary,age,gmr,dept_id) values('name7','��',1234.23,32,1,1)";
			//����Statement(��������SQL��������)
			Statement stat=conn.createStatement();
			//ִ��SQL���
			stat.execute(sql);
			//�ر�����
			stat.close();
			conn.close();
			
			System.out.println("success");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void insert2(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql="insert into emp(name,gender,salary,age,gmr,dept_id) values(?,?,?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "name10");
			ps.setString(2, "Ů");
			ps.setFloat(3, 23.33f);
			ps.setInt(4, 28);
			ps.setInt(5, 1);
			ps.setInt(6, 1);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	///���ô洢����
	private static void insert3(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql="{call insertEmp(?,?)}";
			CallableStatement cs= conn.prepareCall(sql);
			cs.setString(1, "����");
			cs.registerOutParameter(2, Types.INTEGER);
			
			boolean flag=cs.execute();//û�з���ֵ flagΪfalse����Ϊtrue
			System.out.println(flag);
			System.out.println(cs.getInt(2));
			//��ȡ�洢���̷��ؽ����
			while(flag){
				ResultSet rs=cs.getResultSet();
				while(rs.next()){
					System.out.print(rs.getInt("id"));
					System.out.print(" "+rs.getString("name"));
					System.out.print(" "+rs.getString("gender"));
					System.out.print(" "+rs.getFloat("salary"));
					System.out.print(" "+rs.getInt("age"));
					System.out.println();
				}
				//��ȡ��������
				flag=cs.getMoreResults();
			}
			cs.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void update(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="update emp set age=20 where id=3";
			Statement stat=conn.createStatement();
			stat.execute(sql);
			stat.close();
			conn.close();
			
			System.out.println("success");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private static void update2(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="update emp set age=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 22);
			ps.setInt(2, 4);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void delete(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="delete from emp where id=14";
			Statement stat=conn.createStatement();
			stat.execute(sql);
			stat.close();
			conn.close();
			
			System.out.println("success");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void query(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="select id,name,gender,salary,age from emp";
			Statement stat=conn.createStatement();
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt("id"));
				System.out.print(" "+rs.getString("name"));
				System.out.print(" "+rs.getString("gender"));
				System.out.print(" "+rs.getFloat("salary"));
				System.out.print(" "+rs.getInt("age"));
				System.out.println();
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private static void transaction(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			conn.setAutoCommit(false);
			
			String sql1="insert into emp(name,gender,salary,age,gmr,dept_id) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql1);
			ps.setString(1,	"name9");
			ps.setString(2, "Ů");
			ps.setFloat(3, 10000.4f);
			ps.setInt(4, 20);
			ps.setInt(5, 1);
			ps.setInt(6, 1);
			ps.executeUpdate();
			
			String sql2="update emp set salary=? where id=?";
			ps=conn.prepareStatement(sql2);
			ps.setFloat(1, 30000f);
			ps.setInt(2, 4);
			ps.executeUpdate();
			
			conn.commit();
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
