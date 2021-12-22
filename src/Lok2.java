public class Lok2 extends Thread{
    private int speed;
    private Track track;
    private int remaining = 0;
    private Lok1 lok1;
    public boolean queued;

    public Lok2(int speed, Track track, Lok1 lok1) {
        this.speed = speed;
        this.track = track;
        this.lok1 = lok1;
    }

    public void drive() throws InterruptedException {
        if (remaining == 0){
            remaining = 1000/speed;
        }
        while (remaining != 0 && !queued){
            Thread.sleep(1);
            remaining--;
        }
    }

    public void enterLok1() throws InterruptedException {
        track.append(2);
    }

    public void exitLok1() throws InterruptedException {
        track.remove(2);
        lok1.queued = true;
    }
}