
class Peopletext{
    //类中的属性
    String name;
    int high;
    int weig;
    boolean sex;
    //类中的方法
    void eat(){
        System.out.println("正在吃饭");
    }
    void run(){
        System.out.println("正在锻炼");
    }
    public Peopletext(String name){
        this.name=name;
    }
}

public class People {
    public static void main(String[] args) {
        //在计算机中通过new来创建一个实例
        Peopletext people=new Peopletext("atwoodTom");// people就是一个类类型的引用变量，指向了该类的对象
        //要使用对象中的（内容\方法）可以通过  对象.（成员\方法） 的形式来完成调用。
        System.out.println(people.name);
        System.out.println(people.weig);
		people.run();
		x x=new x("子类");
    }
}

class x extends Peopletext{
    @Override
    void eat() {
        System.out.println("x正在吃饭");
    }

    @Override
    void run() {
        System.out.println("x正在锻炼");
    }

    public x(String name) {
        super(name);
    }
}