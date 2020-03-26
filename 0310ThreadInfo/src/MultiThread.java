import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * [5] Attach Listener //����¼�
[4] Signal Dispatcher // �ַ������ JVM �źŵ��߳�
[3] Finalizer //���ö��� finalize �������߳�
[2] Reference Handler //��� reference �߳�
[1] main //main �߳�,�������
 * @author Administrator
 *
 */
public class MultiThread {
	public static void main(String[] args) {
		// ��ȡ Java �̹߳��� MXBean
		
	ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		// ����Ҫ��ȡͬ���� monitor �� synchronizer ��Ϣ������ȡ�̺߳��̶߳�ջ��Ϣ
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		// �����߳���Ϣ������ӡ�߳� ID ���߳�������Ϣ
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		}
	}
}
