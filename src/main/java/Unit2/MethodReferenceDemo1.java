package Unit2;


interface I1{
    void method1();

}

interface I2{
    void method2();
}

interface I3{
    void method3();
}


public class MethodReferenceDemo1 {
    public static void main(String[] args){

        // using static method
        I1 i1 = MethodReferenceDemo1::printMethod1;
        i1.method1();
        // using instance method
        MethodReferenceDemo1 methodReferenceDemo1 = new MethodReferenceDemo1();
        I2 i2 = methodReferenceDemo1::printMethod2;
        i2.method2();

        // using constructor
        I3 i3 = MethodReferenceDemo1::new;
        i3.method3();

    }

    public MethodReferenceDemo1() {
        System.out.println("Method Reference using Constructor");
    }

    public void printMethod2(){
        System.out.println("Method Reference using instance method");
    }

    public static void printMethod1(){
        System.out.println("Method Reference using static method ");
    }
}
