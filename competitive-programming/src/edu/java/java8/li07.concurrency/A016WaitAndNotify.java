package edu.java.java8.li07.concurrency;

public class A016WaitAndNotify {

	public static void main(String[] args) {
		A016WaitAndNotify obj = new A016WaitAndNotify();
		obj.execute();
	}

	private void execute() {
		Thread t1 = new Thread(() -> {
			printNum();
		});

		Thread t2 = new Thread(() -> {
			printNum();
		});

		t1.start();
		t2.start();
	}

	int count = 0;
	synchronized void printNum() {
		while (count < 10) {
			if (count % 2 == 0) {
				System.out.println(Thread.currentThread().getName()+": "+count);
				count++;
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(count);
				count++;
			}
		}
	}

}
