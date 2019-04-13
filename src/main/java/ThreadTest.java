public class ThreadTest {


    //deadlock
    static class Friend{

        private String name;
        public Friend(String name){
            this.name = name;
        }
        public synchronized void bow(Friend friend){
               friend.bowBack(this);
        }
        public synchronized void bowBack(Friend friend){
            System.out.println(name+" bowBack"+" "+friend.name);
        }

        public static void main(String[] args){
            Friend f1 = new Friend("f1");
            Friend f2 = new Friend("f2");
            new Thread(
                    new Runnable(){

                        public void run(){
                            f1.bow(f2);
                        }
                    }
            ).start();

            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            f2.bow(f1);
                        }
                    }
            ).start();
        }

    }


    private Object lock1 = new Object();
    private Object lock2 = new Object();




    class OneThread extends Thread{


        public OneThread(String name){
            super(name);
        }

        @Override
        public void run(){
            synchronized (lock1){
                System.out.println(this.getName()+" get lock1");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(lock2){
                    System.out.println(this.getName()+"  try to get lock2");
                }
            }
        }

    }

    class TwoThread extends Thread{

        public TwoThread(String name){
            super(name);
        }

        public void ran(){
            synchronized (lock2){
                System.out.println(this.getName()+" get lock2");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(lock1){
                    System.out.println(this.getName()+"  try to get lock1");
                }
            }
        }

    }

}
