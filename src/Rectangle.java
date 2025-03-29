import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Rectangle {
    Float length,breadth;
    Rectangle(){
        this.length=(float)0;
        this.breadth=(float)0;
    }
    public void Setter(Float l,Float b){
        this.length=l;
        this.breadth=b;
    }
    public Float Area(){
        return this.length*this.breadth;
    }
    public void Getter(){
        System.out.println("Area of rect: "+this.Area());
    }
    public static void main(String[]args){
        Rectangle rectInstance=new Rectangle();
        BufferedReader readFromStream=new BufferedReader(new InputStreamReader(System.in));
        Boolean isPositive=false;
        Float length=(float)0,breadth=(float)0;
        try{
            System.out.println("Enter length");
            while(!isPositive){
                length=Float.parseFloat(readFromStream.readLine());
                if(length<(float)0){
                    System.out.println("Please enter valid length in positive:");
                }
                else{
                    isPositive=true;
                }
            }
            isPositive=false;//for breadth entry
            System.out.println("Enter breadth");
            while(!isPositive){
                breadth=Float.parseFloat(readFromStream.readLine());
                if(breadth<(float)0){
                    System.out.println("Please enter valid breadth in positive:");
                }
                else{
                    isPositive=true;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        rectInstance.Setter(length, breadth);
        rectInstance.Getter();

    }
}
