# java-obj-create
java中创建对象的方法

1.用new语句创建对象

new操作符的本意是分配内存。程序执行到new操作符时，首先去看new操作符后面的类型，因为知道了类型，才能知道要分配多大的内存空间。分配完内存之后，再调用构造函数，填充对象的各个域，这一步叫做对象的初始化，构造方法返回后，一个对象创建完毕，可以把他的引用（地址）发布到外部，在外部就可以使用这个引用操纵这个对象。
   People p1=new People();  // 调用Demo类的默认构造方法
   People p1=new People(1,“key”)；//调用第二种构造方法

2.运用反射手段

调用Java.lang.Class或者java.lang.reflect.Constructor类的newInstance()实例方法
Class objClass=Class.forName("com.key.create_obj.People");  // 若该类含有包名，则要指定包名全路径
People p3=(People)objClass.newInstance(); //调用People类的默认构造方法  

3.调用对象的clone()方法

clone在第一步是和new相似的， 都是分配内存，调用clone方法时，分配的内存和源对象（即调用clone方法的对象）相同，然后再使用原对象中对应的各个域，填充新对象的域， 填充完成之后，clone方法返回，一个新的相同的对象被创建，同样可以把这个新对象的引用发布到外部。
People p5=(People)c2.clone(); //不会调用People类的构造方法  

4.运用反序列化手段

调用java.io.ObjectInputStream对象的readObject()方法.

5.隐式创建对象

1.对于java命令中的每个命令行参数，Java虚拟机都会创建相应的String对象，并把它们组织到一个String数组中，再把该数组作为参数传给程序入口main(String args[])方法。 
2. 程序代码中的String类型的直接数对应一个String对象，由Java虚拟机隐含地创建。如：String s1=”Hello”; 
3. 字符串操作符“+”的运算结果为一个新的String对象。 
4. 当Java虚拟机加载一个类时，会隐含地创建描述这个类的Class实例

6.区别

用new语句或Class对象的newInstance()方法创建Demo对象时，都会执行Demo类的构造方法，而用对象的clone()方法创建Demo对象时，不会执行Demo类的构造方法。（区别）
