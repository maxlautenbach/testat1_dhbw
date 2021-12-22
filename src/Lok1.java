public class Lok1 extends Thread{
    private int speed;
    private Track track;
    private int remaining = 0;
    private Lok2 lok2;
    public boolean queued;

    public Lok1(int speed, Track track, Lok2 lok2) {
        this.speed = speed;
        this.track = track;
        this.lok2 = lok2;
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
        track.append(1);
    }

    public void exitLok1() throws InterruptedException {
        track.remove(1);
        lok2.queued = true;
    }
}
