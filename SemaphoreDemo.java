package tcp;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo
{
    public static void main(String args[]) throws InterruptedException
    {
        // creating a Semaphore objects
        Semaphore semA = new Semaphore(1000);
        Semaphore semB = new Semaphore(1);
        Semaphore semC = new Semaphore(1);
        Semaphore semD1 = new Semaphore(1);
        Semaphore semD2 = new Semaphore(2);
        Semaphore semE = new Semaphore(1);
        Semaphore semF = new Semaphore(1);
        Semaphore semG = new Semaphore(2);
        Semaphore semH = new Semaphore(2);


        Semaphore[] semaphores = new Semaphore[]{
               semA, semB, semC, semD1, semD2, semE, semF, semG, semH
        };

        // Note that thread A will increment the count
        // and thread B will decrement the count
        MyThread mt1 = new MyThread(semaphores, "1");
        MyThread mt2 = new MyThread(semaphores, "2");
        MyThread mt3 = new MyThread(semaphores, "3");

        // starting threads 1, 2, 3
        mt1.start();
        mt2.start();
        mt3.start();

        // waiting for threads 1, 2, 3
        mt1.join();
        mt2.join();
        mt3.join();
    }
}

class MyThread extends Thread
{
    Semaphore[] sems;
    String threadName;
    public MyThread(Semaphore[] sems, String threadName)
    {
        super(threadName);
        this.sems = sems;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // run by thread 1
        if(this.getName().equals("1"))
        {
            System.out.println("Starting " + threadName);
            try
            {
                System.out.println(threadName + " wants to pass A");
                this.sems[0].acquire();
                Thread.sleep(100);
                System.out.println(threadName + " passed A!");
                this.sems[0].release();
                System.out.println(threadName + " released A");

                System.out.println(threadName + " wants to pass B");
                this.sems[1].acquire();
                Thread.sleep(100);
                System.out.println(threadName + " passed B!");
                this.sems[1].release();
                System.out.println(threadName + " released B");

                System.out.println(threadName + " wants to pass D2");
                this.sems[3].acquire();
                Thread.sleep(5000);
                System.out.println(threadName + " passed D2!");
                this.sems[3].release();
                System.out.println(threadName + " released D2");

                System.out.println(threadName + " wants to pass G");
                this.sems[7].acquire();
                Thread.sleep(5000);
                System.out.println(threadName + " passed G!");
                this.sems[7].release();
                System.out.println(threadName + " released G");

                System.out.println(threadName + " wants to pass H");
                this.sems[8].acquire();
                Thread.sleep(5000);
                System.out.println(threadName + " passed H!");
                this.sems[8].release();
                System.out.println(threadName + " released H");

                System.out.println(threadName + " DONE");

            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }

        if(this.getName().equals("2"))
        {
            System.out.println("Starting " + threadName);
            try
            {
                System.out.println(threadName + " wants to pass A");
                this.sems[0].acquire();
                Thread.sleep(100);
                System.out.println(threadName + " passed A!");
                this.sems[0].release();
                System.out.println(threadName + " released A");

                System.out.println(threadName + " wants to pass C");
                this.sems[1].acquire();
                Thread.sleep(100);
                System.out.println(threadName + " passed C!");
                this.sems[1].release();
                System.out.println(threadName + " released C");

                if((int)(Math.random() * 10) == 0) {
                    System.out.println(threadName + " wants to pass E");
                    this.sems[5].acquire();
                    Thread.sleep(1000);
                    System.out.println(threadName + " passed E");
                    this.sems[5].release();
                    System.out.println(threadName + " released E");


                    System.out.println(threadName + " wants to pass G");
                    this.sems[7].acquire();
                    Thread.sleep(5000);
                    System.out.println(threadName + " passed G!");
                    this.sems[7].release();
                    System.out.println(threadName + " released G");

                }

                else {
                    System.out.println(threadName + " wants to pass F");
                    this.sems[6].acquire();
                    Thread.sleep(1000);
                    System.out.println(threadName + " passed F");
                    this.sems[6].release();
                    System.out.println(threadName + " released F");

                    System.out.println(threadName + " wants to pass H");
                    this.sems[8].acquire();
                    Thread.sleep(5000);
                    System.out.println(threadName + " passed H!");
                    this.sems[8].release();
                    System.out.println(threadName + " released H");


                }

                System.out.println(threadName + " DONE");


            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }

        if(this.getName().equals("3"))
        {
            System.out.println("Starting " + threadName);
            try
            {
                System.out.println(threadName + " wants to pass A");
                this.sems[0].acquire();
                Thread.sleep(100);
                System.out.println(threadName + " passed A!");
                this.sems[0].release();
                System.out.println(threadName + " released A");

                System.out.println(threadName + " wants to pass D1");
                this.sems[3].acquire();
                Thread.sleep(100);
                System.out.println(threadName + " passed D1!");
                this.sems[3].release();
                System.out.println(threadName + " released D1");

                System.out.println(threadName + " wants to pass D2");
                this.sems[4].acquire();
                Thread.sleep(1000);
                System.out.println(threadName + " passed D2");
                this.sems[4].release();
                System.out.println(threadName + " released D2");

                System.out.println(threadName + " wants to pass G");
                this.sems[7].acquire();
                Thread.sleep(5000);
                System.out.println(threadName + " passed G!");
                this.sems[7].release();
                System.out.println(threadName + " released G");

                System.out.println(threadName + " wants to pass H");
                this.sems[8].acquire();
                Thread.sleep(5000);
                System.out.println(threadName + " passed H!");
                this.sems[8].release();
                System.out.println(threadName + " released H");

                System.out.println(threadName + " DONE");

            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }


    }
}
