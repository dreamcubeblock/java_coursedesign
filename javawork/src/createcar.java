import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class createcar extends Thread{
    public List list=new ArrayList();
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
    public void run(){
        Random random=new Random();
        while(true){
            try{
                System.out.println("***************红绿灯路口现有车辆：******************");
                for(int i=0;i<random.nextInt(6);i++){

                    car c=new car(generateCarID(), random.nextInt(5));

                    list.add(c);
                }
                for(int i=0;i<list.size();i++){
                    car a=(car)list.get(i);
                    System.out.println(a.getName()+"  "+a.getrealdirection());
                }
                System.out.println("*****************************************************");
                //wait(5000);
                sleep(10000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
