import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    int size;//���������������

    ReentrantLock lock = new ReentrantLock();

    LinkedList<E> list=new LinkedList<>();//���еײ�ʵ��

    Condition notFull = lock.newCondition();//������ʱ�ĵȴ�����
    Condition notEmpty = lock.newCondition();//���п�ʱ�ĵȴ�����

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() ==size)//��������,��notFull�����ϵȴ�
                notFull.await();
            list.add(e);//���:��������ĩβ
            System.out.println("��ӣ�" +e);
            notEmpty.signal(); //֪ͨ��notEmpty�����ϵȴ����߳�
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while (list.size() == 0)//����Ϊ��,��notEmpty�����ϵȴ�
                notEmpty.await();
            e = list.removeFirst();//����:�Ƴ�������Ԫ��
            System.out.println("���ӣ�"+e);
            notFull.signal();//֪ͨ��notFull�����ϵȴ����߳�
            return e;
        } finally {
            lock.unlock();
        }
    }
}