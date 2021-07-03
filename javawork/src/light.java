public class light extends Thread{
    //private int direction;
    //private int color;
    private int car_direction;
    private int seconds;
    String leftstate1="red";
    String forwardstate1="red";
    String leftstate2="red";
    String forwardstate2="red";
    public void run(){
        while(true){
            try{
                forwardstate1 = "green";
                System.out.println();
                System.out.println("lighter:现在南北直向是绿灯，前行车辆通行");
                Thread.sleep(20*1000);
                //10s后灯变绿，设绿灯时间位5秒
                forwardstate1 = "red";
                leftstate1="green";
                System.out.println();
                System.out.println("lighter:现在南北左转是绿灯，左转车辆可以通行。");
                Thread.sleep(20*1000);
                forwardstate1 = "red";
                leftstate1="red";
                forwardstate2="green";
                System.out.println();
                System.out.println("lighter:现在东西前行是绿灯，前行车辆可以通行。");
                Thread.sleep(20*1000);
                forwardstate2="red";
                leftstate2="green";
                System.out.println();
                System.out.println("lighter:现在东西左转是绿灯，左转车辆可以通行。");
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
