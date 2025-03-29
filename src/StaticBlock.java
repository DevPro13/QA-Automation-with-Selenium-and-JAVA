public class StaticBlock {
    StaticBlock(){
        System.out.println("This is constructor");
    }
    static{
        System.out.println("This is static block!!");
    }
    public static void main(String[] args) {
        StaticBlock obj1=new StaticBlock();
        StaticBlock obj2=new StaticBlock();
    }
}