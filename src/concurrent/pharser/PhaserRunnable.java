package concurrent.pharser;

import java.util.concurrent.Phaser;

public class PhaserRunnable implements Runnable {

    Phaser phaser;

    PhaserRunnable(Phaser phaser,String phaserNmae){
        this.phaser=phaser;
        this.phaser.register();//Registers/Add a new unArrived party to this phaser.
        System.out.println(phaserNmae +" - New unarrived party has "
                + "been registered with phaser");
    }



    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName()+" party has arrived and working on phase "+phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        try{Thread.sleep(100000);}catch (Exception e){
            e.printStackTrace();
        }

        //------NEXT PHASE BEGINS------

        System.out.println(Thread.currentThread().getName()+" party has arrived and working on phase "+phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        phaser.arriveAndDeregister();

    }
}
