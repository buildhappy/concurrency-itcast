package cn.itcast.heima2;

/**
 * synchronizedw实现进程同步
 * @author Administrator
 *
 */
public class O03TraditionalThreadSynchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new O03TraditionalThreadSynchronized().init();
	}
	
	private void init(){
		final Outputer outputer = new Outputer();
		new Thread(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("zhangxiaoxiang");
				}
				
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output3("lihuoming");
				}
				
			}
		}).start();
		
	}

	static class Outputer{
		
		public void output(String name){
			int len = name.length();
			synchronized (Outputer.class) 
			{
				for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public synchronized void output2(String name){
			int len = name.length();
			for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
		public static synchronized void output3(String name){
			int len = name.length();
			for(int i=0;i<len;i++){
					System.out.print(name.charAt(i));
			}
			System.out.println();
		}	
	}
}
