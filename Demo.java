public class Demo {
    static class Property{
        int a = 5;
        String name = "Anurag";
        public void greetings(){
            System.out.println(name+ " hello ji!");
        }
    }
    public static void main(String[] args){
        Property py = new Property();
        System.out.println(py.a);
        System.out.println(py.name);
        py.greetings();
    }
}
