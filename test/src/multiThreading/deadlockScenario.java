package multiThreading;

public class deadlockScenario {

	public static void main(String[] arg) {

		read read1 = new read();
		write write1 = new write();

		// First thread task defined here first read the resource than write it
		Thread thread1 = new Thread() {
			public void run() {
				synchronized (read1) {
					read1.readLog();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (write1) {
						write1.writeLog();
					}

					System.out.println("thread1 task complete");
				}
			}
		};

		// Second thread task defined here first write the resource than read it
		Thread thread2 = new Thread() {
			public void run() {
				synchronized (write1) {
					write1.writeLog();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (read1) {
						read1.readLog();
					}
					System.out.println(" Thread 2 task complete");

				}
			}
		};

		// Set the name of threads
		thread2.setName("Thread2 Thread");
		thread1.setName("thread1 Thread");

		// start the threads for executing the task
		thread1.start();
		thread2.start();

		System.out.println(" Main Thread complete :" + Thread.currentThread().getName());

	}
}

/*
 * This class is used to read the data resources
 */
class read {

	void readLog() {
		System.out.println("reading via Thread :" + Thread.currentThread().getName());
	}
}

/*
 * This class is used to write the data resources
 */
class write {
	void writeLog() {
		System.out.println("write via Thread :" + Thread.currentThread().getName());
	}
}
