public class xiecheng {
    public static void main(String[] args) {
        Animal a=new Dog("狗");
        //a.call();向上转型不能调用父类没有的方法
        //a.run();
        //向下转型
        Dog b=(Dog) a;
        //b.run();
        //Fish c=(Fish) a;向下转型要注意，狗不能变成鱼
        //a.run();
        Animal c=new Fish("鱼");
        eat(a);
        eat(c);
    }
    public static void eat(Animal a){
        if(a instanceof Dog){
            Dog d = (Dog)a;
            d.eat();
            d.run();
        }
        if(a instanceof Fish){
            Fish c = (Fish) a;
            c.eat();
            c.run();
        }
    }
}


class Animal{
    protected String name;
    private int age;
    public Animal(String name){
        this.name=name;
    }
    public void eat(){
        System.out.println(name+"正在吃饭");
    }

    public void run(){
        System.out.println(name+"正在跑");
    }
}
class Dog extends Animal{
    public String name;
    public Dog(String name) {
        super("");
        this.name=name;
    }
    public void call(){
        System.out.println("狗再叫");
    }
    @Override
    public void eat() {
        System.out.println("狗正在跑");
    }

    @Override
    public void run() {
        System.out.println("狗正在跑");
    }
}
class Fish extends Animal{
    public String name;
    public Fish(String name) {
        super("");
        this.name=name;
    }

    @Override
    public void eat() {
        System.out.println("吃鱼食");
    }

    @Override
    public void run() {
        System.out.println("我会游");
    }
}