import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * ��ʵ����һ����ķ�ʽ
 * ��1��ͨ�����췽��ʵ����һ����
 * ��2��ͨ��Classʵ����һ����
 * ��3��ͨ������ʵ����һ����
 * ��4��ͨ����¡ʵ����һ����
 * ��5��ͨ�������л�ʵ����һ����
 * ��6��ͨ��Unsafeʵ����һ����
 *
 */
public class InstantialTest {

    private static Unsafe unsafe;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 1. ���췽��
        User user1 = new User();
        // 2. Class������ʵ��Ҳ�Ƿ���
        User user2 = User.class.newInstance();
        // 3. ����
        User user3 = User.class.getConstructor().newInstance();
        // 4. ��¡
        User user4 = (User) user1.clone();
        // 5. �����л�
        User user5 = unserialize(user1);
        // 6. Unsafe
        User user6 = (User) unsafe.allocateInstance(User.class);

        System.out.println(user1.age);
        System.out.println(user2.age);
        System.out.println(user3.age);
        System.out.println(user4.age);
        System.out.println(user5.age);
        System.out.println(user6.age);
    }

    private static User unserialize(User user1) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://object.txt"));
        oos.writeObject(user1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://object.txt"));
        // �����л�
        User user5 = (User) ois.readObject();
        ois.close();
        return user5;
    }

    static class User implements Cloneable, Serializable {
        private int age;

        public User() {
            this.age = 10;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}