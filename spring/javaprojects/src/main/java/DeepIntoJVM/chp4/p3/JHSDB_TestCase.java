package DeepIntoJVM.chp4.p3;



public class JHSDB_TestCase {
    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里是一个断点
        }
    }

    private static class ObjectHolder{}

    public static void main(String[] args) {
        Test test = new Test();
        test.foo();

    }


}
