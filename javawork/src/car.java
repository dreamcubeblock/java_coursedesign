import java.util.Random;

public class car{
    private int direction;
    private  String name;
    private boolean finish=false;
    car(String name,int direction){
        this.direction=direction;
        this.name=name;


    }
    void setFinish(){
        this.finish=true;
    }
    boolean getFinish(){
        return this.finish;
    }
    String getName() {
        return this.name;
    }
    int getDirection(){
        return this.direction;
    }
    String getrealdirection(){
        if(this.direction==0){
            return "南北方向直行";
        }
        else if(this.direction==1){
            return "南北方向左转";
        }
        else if(this.direction==2){
            return "东西方向直行";
        }
        else if(this.direction==3){
            return "东西方向左转";
        }
        else{
            return "右转";
        }
    }
}
