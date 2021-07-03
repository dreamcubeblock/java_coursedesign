import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

public class main {
    private static final int northsouth=0;
    private static final int eastwest=1;
    private static final int red=10;
    private static final int green=11;
    private static final int left=20;
    private static final int forward=21;
    private static final int carnumber=20;
    private static final int timeRange=60;
    private static final String[] cardirection={"left","right","forward"};
    private static String generateCarID() {
        char[] provinceAbbr = { // 省份简称 4+22+5+3
                '京', '津', '沪', '渝',
                '冀', '豫', '云', '辽', '黑', '湘', '皖', '鲁', '苏', '浙', '赣',
                '鄂', '甘', '晋', '陕', '吉', '闽', '贵', '粤', '青', '川', '琼',
                '宁', '新', '藏', '桂', '蒙',
                '港', '澳', '台'
        };
        String alphas = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890"; // 26个字母 + 10个数字
        Random random = new Random();
        String carID = "";

        // 省份+地区代码+·  如 湘A·
        carID += provinceAbbr[random.nextInt(34)]; // 注意：分开加，因为加的是2个char
        carID += alphas.charAt(random.nextInt(26)) + "·";

        // 5位数字/字母
        for (int i = 0; i < 5; i++) {
            carID += alphas.charAt(random.nextInt(36));
        }
        return carID;
    }
    public static void main(String args[]) {
        //Random random = new Random();
        light l = new light();
        createcar cars=new createcar();
        //List list =new ArrayList();
        // list.add(new car(generateCarID(), random.nextInt(5)));
        //car[] c = new car[20];

        //  for (int i = 0; i < 20; i++) { // foreach不行，因为是数组初始化
        //      c[i] = new car(generateCarID(), random.nextInt(5));
        //      System.out.println(c[i].getName()+"  "+c[i].getrealdirection());

        // new Car(int direction, int showTime) 随机生成车辆朝向和出现时间，时间范围[1, timeRange]
        // 在Car构造函数内部随机生成了车辆ID，即车牌号
        //   }
        System.out.println("网络工程4班高子淇3119005369");
        System.out.println("模拟红绿灯信号开始");
        System.out.println();
        l.start();
        cars.start();
        while (true) {
            try {

                for (int i=0;i<cars.list.size();i++) {
                    car c =(car)cars.list.get(i);
                    if(c.getFinish()){
                        continue;
                    }
                    switch (c.getDirection()) {
                        case 0:
                            if (l.forwardstate1.equals("red")) {
                                break;
                            } else {
                                sleep(1000);
                                System.out.println(c.getName() + ":通过了红绿灯");
                                cars.list.remove(i);
                                //   i=i-1;
                                c.setFinish();
                                break;
                            }
                        case 1:
                            if (l.leftstate1.equals("red")) {
                                break;
                            } else {
                                sleep(1000);
                                System.out.println(c.getName() + ":通过了红绿灯");
                                cars.list.remove(i);
                                //   i=i-1;
                                c.setFinish();
                                break;
                            }
                        case 2:
                            if (l.forwardstate2.equals("red")) {
                                break;
                            } else {
                                sleep(1000);
                                System.out.println(c.getName() + ":通过了红绿灯");
                                cars.list.remove(i);
                                //   i=i-1;
                                c.setFinish();
                                break;
                            }
                        case 3:
                            if (l.leftstate2.equals("red")) {
                                break;
                            } else {
                                sleep(1000);
                                System.out.println(c.getName() + ":通过了红绿灯");
                                cars.list.remove(i);

                                c.setFinish();
                                break;

                            }
                        case 4:
                            sleep(1000);
                            System.out.println(c.getName()+"右转无需考虑信号灯");
                            cars.list.remove(i);
                            //   i=i-1;
                            c.setFinish();
                            break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
