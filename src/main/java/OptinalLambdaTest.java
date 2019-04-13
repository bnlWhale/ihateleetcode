import java.util.Optional;

public class OptinalLambdaTest {





    public static void main(String[] args){

        Optional<String> name = Optional.of("Matt");
        System.out.println(name.get());
        System.out.println(name.map( s->  "hello "+s
                                    ));



        Thread oneThread = new Thread(()->{
            int total = 10;
            while(total>0){
                total--;
                System.out.println("oneThread on thread");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }


        });

        Thread twoThread = new Thread(()->{
            int amount=10;
            while(amount>0){
                amount--;
                System.out.println("twoThread on thread");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        });





        try{
            oneThread.start();
            oneThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        twoThread.start();
    }


}
