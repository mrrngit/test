
public class Test{
public static void main(String[] args){
Person taro = new Person();
taro.name="山田太郎";
taro.age=20;
System.out.println(taro.name);
System.out.println(taro.age);
taro.talk();

Person jiro=new Person();
jiro.name="木村次郎";
jiro.age=18;
System.out.println(jiro.name);
System.out.println(jiro.age);
jiro.walk();

Person hanako=new Person();
hanako.name="鈴木花子";
hanako.age=16;
System.out.println(hanako.name);
System.out.println(hanako.age);
hanako.run();


Person aibo=new Person();
aibo.name="aibo";
System.out.println(aibo.name);
aibo.talk();

Person asimo=new Person();
asimo.name="asimo";
System.out.println(asimo.name);
asimo.walk();
}
}