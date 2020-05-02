import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class DiningPhilosophers {

    Map<Integer, Boolean> forkFlag ;
    Map<Integer, List<Integer>> philosopherFork;

    public DiningPhilosophers() {
        forkFlag = new ConcurrentHashMap<>();
        philosopherFork = new ConcurrentHashMap<>();
        for (int i = 0; i < 5; i++) {
            forkFlag.put(i, true);
            int left = i-1;
            int right = i+1;
            if (left<0){
                left=4;
            }
            if (right>4){
                right = 0;
            }
            philosopherFork.put(i, Arrays.asList(left, right));
        }

    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        List<Integer> forkIndex = philosopherFork.get(philosopher);

        boolean canEat = true;
        do {
            for (Integer index : forkIndex) {
                canEat &= forkFlag.get(index);
            }
            if (!canEat)wait();
        }while (!canEat);

        pickLeftFork.run();
        pickRightFork.run();
        for (Integer index : forkIndex) {
            forkFlag.put(index, false);
        }
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        for (Integer index : forkIndex) {
            forkFlag.put(index, true);
        }
        notifyAll();
    }

    public static void main(String[] args) {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                for (int j = 0; j < 4; j++) {
                    try {
                        diningPhilosophers.wantsToEat(finalI,
                                ()-> System.out.println(finalI+"拿起left"),
                                ()-> System.out.println(finalI+"拿起right"),
                                ()-> System.out.println(finalI+"eat"),
                                ()-> System.out.println(finalI+"放下left"),
                                ()-> System.out.println(finalI+"放下right")
                        );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}