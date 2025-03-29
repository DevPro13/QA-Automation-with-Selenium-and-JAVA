import java.io.BufferedReader;;
import java.io.IOException;
import java.io.InputStreamReader;
public class TemperatureConverter {
    Float tempInDegreeC;
    Float tempInDegreeF;
    char Unit;
    TemperatureConverter(){
        this.tempInDegreeC=(float)0;
        this.tempInDegreeF=(float)32;
    }
    public void Setter(){
        BufferedReader readFromStream=new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Enter temperature unit");
            this.Unit=(char)readFromStream.read();
            readFromStream.readLine();
            System.out.println("Enter temperature");
            switch (this.Unit) {
                case 'C'|'c':
                    this.tempInDegreeC=Float.parseFloat(readFromStream.readLine());
                    break;
                case 'F'|'f':
                    this.tempInDegreeF=Float.parseFloat(readFromStream.readLine());
                    break;
                default:
                    break;
            }
            convertTemp(this.Unit);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
public void convertTemp(char Unit){
    switch (Unit) {
        case 'C'|'c':
        this.tempInDegreeF=((float)1.8*this.tempInDegreeC)+(float)32;
            break;
        case 'F'|'f':
        this.tempInDegreeC=5*(this.tempInDegreeF-(float)32)/9;
            break;
        default:
            break;
    }
}
public void Getter(){
    System.out.println("Temperature in celsius: "+this.tempInDegreeC+"\n"+"Temperature in Fahrenheit: "+this.tempInDegreeF);
}
    
public static void main(String []args){
    TemperatureConverter tempInstance=new TemperatureConverter();
    tempInstance.Getter();
    tempInstance.Setter();
    tempInstance.Getter();
}
}
