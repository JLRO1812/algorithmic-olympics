package thread;

public class AddCasesThread extends Thread{

	private ArrayListThread arrayListThread;
	private LinkedListThread linkedListThread;
	private ABBThread abbThread;
	
	public AddCasesThread(ArrayListThread arrayListThread, LinkedListThread linkedListThread, ABBThread abbThread) {
		this.arrayListThread = arrayListThread;
		this.linkedListThread = linkedListThread;
		this.abbThread = abbThread;
	}
	
	public void run() {
		arrayListThread.add();
		linkedListThread.add();
		//abbThread.add();
	}
	
}
