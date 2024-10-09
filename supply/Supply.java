package CoreJava.supply;

import java.util.Scanner;

public class Supply {
     private int code;
     private String foodName;
     private String sticker;
     private String foodType;

    public int getCode() {
        return code;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getSticker() {
        return sticker;
    }

    public String getFoodType() {
         if (sticker.equals("Green")){
             foodType="vegetable";
         } else if (sticker.equals("Yellow")) {
             foodType="Contain Egg";
         } else if (sticker.equals("Red")) {
             foodType="Non Vegetarian";

         }else {
             System.out.println("Please enter valid Sticker given below-\n\t Green/Yellow/Red ");

         }

        return foodType;
    }

    public  void  foodIn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter Food Code- ");
        code= sc.nextInt();
        System.out.println("Enter food name-");
        foodName= sc.next();
        System.out.println("Enter Sticker- ");
        sticker= sc.next();
        getFoodType();
        foodOut();
    }

    public  void foodOut(){
        System.out.println("Food Details- \n\t Food Code- "+getCode()+", Food name-"+getFoodName()+", Sticker- "
                +getSticker()+" & Food Type- "+foodType);
    }

    public static void main(String[] args) {
     Supply supply=new Supply();
     supply.foodIn();
    }
}

