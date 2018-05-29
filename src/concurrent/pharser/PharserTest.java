package concurrent.pharser;

import java.util.concurrent.Phaser;

public class PharserTest {


    public static void main(String...args)
    {
        Phaser phaser = new Phaser(1);

        System.out.println("new phaser with 1 registered unArrived parties"
                + " created and initial phase  number is 0 ");

        PhaserRunnable phaserRunnable = new PhaserRunnable(phaser,"First Phase");
        PhaserRunnable phaserRunnable1 = new PhaserRunnable(phaser,"Second Phase");
        PhaserRunnable phaserRunnable2 = new PhaserRunnable(phaser,"Third Phase");

        new Thread(phaserRunnable,"Thread-1").start();
        new Thread(phaserRunnable,"Thread-2").start();
        new Thread(phaserRunnable,"Thread-3").start();

        //get the current phase
        int currentphase=phaser.getPhase();

        phaser.arriveAndAwaitAdvance();
        System.out.println("------Phase-"+currentphase+" has been COMPLETED----------");

        //------NEXT PHASE BEGINS------

        currentphase=phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("------Phase-"+currentphase+" has been COMPLETED----------");


        /* current thread Arrives and deRegisters from phaser.
         * DeRegistration reduces the number of parties that may
         * be required to advance in future phases.
         */
        phaser.arriveAndDeregister();

        //check whether phaser has been terminated or not.
        if(phaser.isTerminated())
            System.out.println("\nPhaser has been terminated");

    }
}
