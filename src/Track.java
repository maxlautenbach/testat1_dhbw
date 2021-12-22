import java.util.concurrent.Semaphore;

public class Track{
    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore empty = new Semaphore(1, true);
    private Semaphore full = new Semaphore(0, true);

    public Track() {
    }

    public void append(int id) throws InterruptedException {
        empty.acquire();
        full.release();
    }

    public void remove(int id) throws InterruptedException {
        full.acquire();
        empty.release();
    }
}
