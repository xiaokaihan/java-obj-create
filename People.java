package com.key.create_obj;

/**
 * java创建对象的方式。
 * @author Key.Xiao
 * @since 2016年10月21日15:00:13
 */
public class People implements Cloneable {

	private int id;

	private String name;

	public People() {
		System.out.println("default consructor.");
	}

	public People(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("second constructed.");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof People))
			return false;
		final People other = (People) obj;
		if (this.id == other.id && this.name.equals(other.name))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "id = " + id + ", name = " + name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws Exception {
		// 1.使用new语句创建对象
		People p1 = new People(); // 调用默认构造器
		// 或者
		People p2 = new People(1, "key"); // 调用第二种构造器
		System.out.println("p2:" + p2);

		// 2.运用反射创建对象
		Class<?> objClass = Class.forName("com.key.create_obj.People"); // 若该类含有包名，则要指定包名全路径
		People p3 = (People) objClass.newInstance(); // 会调用People类的m默认构造器
		System.out.println("p3:" + p3);

		// 3.运用克隆方式创建People对象
		People p4 = (People) p2.clone(); //不会调用People类的构造方法
		System.out.println("p4: " + p4);

		//比较p2和p4
		System.out.println("p2 = p4: " + (p2 == p4));
		System.out.println("p2.equals(p4): " + (p2.equals(p4))); // 结果为true，说明这是一种浅拷贝


		/* 隐含的创建对象**/
		String s1 = "hello"; //String类型的直接数对应一个 String对象，由虚拟机隐含地创建
		String s2 = "hello"; //s1和s2引用同一个 String对象

		String s3 = "key";
		String s4 = s1 + s3; //通过“+”运算 引用一个新的String对象

	}

}
