// Write a program that defines a class called "Employee" with attributes such as name+ age+ and salary. Include appropriate getters and setters for these attributes.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Employees {
    String Name;
    Integer Age;
    Float Salary;
    public void Setter(){
        //Set values for the attributes.
        BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
    try{
        System.out.println("Enter name:\n");
        this.Name=inputReader.readLine();
        System.out.println("Enter Age:\n");
        this.Age=Integer.parseInt(inputReader.readLine());
        System.out.println("Enter Salary:\n");
        this.Salary=Float.parseFloat(inputReader.readLine());
    }
    catch(IOException e){
            e.printStackTrace();
    }

    }
    public void Getter(){
        //print the data into output stream.
        System.out.println("Name: "+this.Name+"\nAge: "+this.Age+"\nSalary: "+this.Salary);
    }
    public static void main(String[] args){
        Employees empInstance=new Employees();
        empInstance.Setter();
        empInstance.Getter();
    }
}
