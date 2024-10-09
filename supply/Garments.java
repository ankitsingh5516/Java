package CoreJava.supply;
import java.util.Scanner;

public class Garments {
    private String GCode;
    private  String GType;
    private  int GSize;
    private  String GFabric;
    private  float GPrice;

    public String getGCode() {
        return GCode;
    }

    public String getGType() {
        return GType;
    }

    public int getGSize() {
        return GSize;
    }

    public String getGFabric() {
        return GFabric;
    }

    public float AssignGPrice() {
        if (GType.equals("Trouser")){
            if (GFabric.equals("COTTON")){
                GPrice=1300;
            }
            else GPrice=1300-(1300*10/100);}
        else if (GType.equals("Shirt")) {
            if (GFabric.equals("COTTON")){
                GPrice=1100;
            }else GPrice=1100-(1100*10/100);

        } else System.out.println("please enter the valid GType- Trouser/Shirt");
        return GPrice;
    }
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter GCode- ");
        GCode=sc.next();
        System.out.println("Enter GType- ");
        GType=sc.next();
        System.out.println("Enter GSize- ");
        GSize=sc.nextInt();
        System.out.println("Enter GFabric- ");
        GFabric=sc.next();AssignGPrice();
        Display();
    }

    public void Display(){
        System.out.println("Garments deyails-\n\t Gcode- "+getGCode()+", GType- "+getGType()+", GSize- "+getGSize()+", GFabric- "+getGFabric()+" & GPrice- "+GPrice);
    }

    public static void main(String[] args) {
        Garments garments=new Garments();
        garments.input();
    }

}
