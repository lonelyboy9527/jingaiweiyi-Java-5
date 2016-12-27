package cc.openhome.virtual;

import cc.openhome.others.MyClass2_1;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

/* MyClass2是公开类
 * 
 * 可以声明类为public，这表示它是个公开类，可以在其他包的类中使用这个类。
 * 可以在构造函数上声明public，这表示其他包中的类可以直接调用这个构造函数。
 * 可以在方法上声明为public，这表示其他包的方法中可以直接调用这个方法。
 * 
 *“ 包管理” 其实有权限上的管理的概念，没有定义任何权限关键字时，就是包权限。
 *
 * Java中有private、public、protected三个权限概念。protected在下一章介绍。
 *
 * 如果类上没有声明public关键字，类中的方法声明就算是public，也等于是包权限了，因为类本身是包权限，其他包根本就无法使用类，更别说当中的方法。
 * 
 * */  
public class MyClass2 {

	String number; 	// 如果没有声明权限修饰的成员，只有在相同包的类程序代码中，才可以直接存取。也就是“包范围权限”。
	int balance;	// 
	int bonus;		// 
	public MyClass2() {
		
	}
	/* 这些都是公开的方法
	 * 
	 * 
	 * */
	public void store(int money) {
		
	}
	public void charge(int money) {
		
	}
	public int exchange(int bonus) {
		return this.bonus;
	}
	
	public String getNumber() {
		return this.number;
	}
	public int getBalance() {
		return this.balance;
	}
	public int getBonus() {
		return this.bonus;
	}
	
	// public 权限修饰
	public static void exp1() {
		/* 前一节看到private权限修饰，声明为private的成员表示为类私有，用户无法在其他类的代码中直接存取。
		 * 
		 * 什么是 “包范围权限”？(default)
		 * 如果没有声明权限修饰的成员，只有在相同包的类程序代码中，才可以直接存取。也就是“包范围权限”。
		 * 如果想在其他包的类程序代码中存取包的类或对象成员，则该类或对象成员必须的公开成员，在Java中使用public声明。
		 * 
		 * 
		 * （1）对于public修饰符，它具有最大的访问权限，可以访问任何一个在CLASSPATH下的类、接口、异常等。它往往用于对外的情况，也就是对象或类对外的一种接口的形式。
		 * （2）对于protected修饰符，它主要的作用就是用来保护子类的。它的含义在于子类可以用它修饰的成员，其他的不可以，它相当于传递给子类的一种继承的东西。
		 * （3）对于default来说，有点的时候也成为friendly（友员），它是针对本包访问而设计的，任何处于本包下的类、接口、异常等，都可以相互访问，即使是父类没有用protected修饰的成员也可以。
		 * （4）对于private来说，它的访问权限仅限于类的内部，是一种封装的体现，例如，大多数的成员变量都是修饰符为private的，它们不希望被其他任何外部的类访问。
		 * 
		 *  				类内部	 本包(类的实例)	 子类(类中和子类的实例)	  外部包(类中和类的实例) 
			public 	  		  √	 	  	  √	      	  √	      				√
			protected 		  √	 	  	  √	 	  	  √	      				×
			default(friendly) √	 	  	  √	 	  	  ×	      				×
 			private   		  √	 	  	  ×	 	  	  ×	      				×
		 * 
		 * 注意：
		 * 1.Java的访问控制是停留在编译层的，也就是它不会在.class文件中留下任何的痕迹，只在编译的时候进行访问控制的检查。其实，通过反射的手段，是可以访问任何包下任何类中的成员，例如，访问类的私有成员也是可能的。
		 * 
		 * 区别：
		 * （1）public：可以被所有其他类任何地方所访问。
		 * （2）protected：自身(类内部)，子类及同一个包中类可以访问
		 * 	   (protected对于子女、朋友来说，就是public的，可以自由使用，没有任何限制，而对于其他的外部class，protected就变成private。)。
		 * （3）default（默认）：同一包中的类实例可以访问，声明时没有加修饰符，认为是friendly。
		 * （4）private：只能被自己(类内部)访问和修改。
		 * 	   (private表示私有，私有的意思就是除了class自己内部之外，任何人都不可以直接使用，私有财产神圣不可侵犯嘛，即便是子女，朋友，都不可以使用。)
		 * 
		 * 总结:
		 * 1.public: 	一句话:任何地方都能用。
		 * 2.protected 	一句话:子类都能用。 	注意：在外部包中，子类是也可以访问的(任何包，子类都可以访问)。	
		 * 3.default 	一句话:只能在本包用。	注意：在本包中的 子类是可以访问的 (本包中的子类可以访问)。 	
		 * 4.private:	一句话:只能在类自己内部用
		 * 
		 * 
		 * 
		 * */
		
		/* 在本包
		 * 能访问的属性 和 方法
		 * */
		System.out.println("(1)在本包->能访问的属性 和 方法:");
		Person p1 = new Person("name_public", "name_protected", "name_default", "name_private");
		p1.name_public = "修改name_public";	     	// 符合在本包的条件
		p1.name_protected = "修改name_protected"; 	// 本包
		p1.name_default = "修改name_Default";	 	// 本包
		System.out.println(p1.getPublicName());  	// 本包
		System.out.println(p1.getProtectedName()); 	// 本包
		System.out.println(p1.getDefaultName());	// 本包
		
		/* 在外包
		 * 能访问的属性 和 方法
		 * */
		System.out.println("(2)在外包->能访问的属性 和 方法:");
		MyClass2_1.exp1();
		
		/* 在本包
		 * 子类能访问的属性 和 方法
		 * */
		System.out.println("(3)在本包->子类能访问的属性 和 方法:");
		Student s1 = new Student("student_public", "student_protected", "student_default", "student_private");
		s1.name_public = "修改student_public"; 		// 本包
		s1.name_protected = "修改student_protected"; // 本包
		s1.name_default = "修改student_default"; 	// 本包
		// 子类实例调用
		System.out.println(s1.getPublicName());     // 本包
		System.out.println(s1.getProtectedName());	// 本包
		System.out.println(s1.getDefaultName());	// 本包
		// 子类中调用
		s1.myMothed();
	
		/* 在外包
		 * 子类能访问的属性 和 方法
		 * */
		System.out.println("(4)在外包->子类能访问的属性 和 方法:");
		MyClass2_1.exp2();
	}
	
	// 关于构造函数
	public static void exp2() {
		/* 在定义类时，可以使用构造函数定义对象建立的初始化流程。
		 * 构造函数是与类名称同名，无须声明返回值类型的方法。
		 * 
		 * 如果没有提供构造函数，那么编译程序会自动加入一个无参数、内容为空的构造函数。
		 * 反编译可看到:
		 * public Some() {
		 * 
		 * }
		 * */
	}
	// 构造函数与方法重载
	public static void exp3() {
		/* 可以定义多个构造函数，只要参数类型或个数不同，这称为重载构造函数。
		 * */
		Some some = new Some(100);
		Some some2 = new Some(100, "some text");
		
		/* 定义方法时也可以重载，提供统一方法名称，但根据参数类型或个数不同调用对应方法
		 * 
		 * 注意，不可根据返回值类型不同而当作方法重载
		 * */
		some.someMethod();
		some.someMethod(100);
		
		/* 在JDK5 之后使用方法重载时，要注意自动装箱和拆箱问题
		 * 
		 * 例如
		 * */
		some.myMethod(1);
		some.myMethod(new Integer(1)); // 要明确指定
	}
	// 使用this
	public static void exp4() {
		/* 除了被声明为static 的地方外，this关键字可以出现在类中的任何地方，在对象建立后为“这个对象”的参考名称。
		 * 
		 * 看Some 类中this、this()。
		 * */ 
		
		/* 在创建对象之后，调用构造函数之前，若有想执行的流程，可以使用 {} 定义。
		 * 例子:
		 * */
		new Other(1);
		
		/* 在前面 3.1.2介绍过 final关键字
		 * 
		 * 如果局部变量声明了final，表示设值后就不能再变动(只能设置一次)，对象数据成员也可以声明final
		 * 
		 * 例如：
		 * */
		Something something = new Something();
		// 程序中不能在赋值操作，会编译错误。
//		something.x = 10;
	}
	
	// static 成员
	public static void exp5() {
		/* 声明了static，表示它属于类.
		 * 1.被声明为static的成员，不会让个别对象拥有。属于这个类。
		 * 2.被声明为static的成员，是将类名称作为名称空间。 Ball.PI
		 * 3.也可以声明方法为static，也是将类名称作为名称空间。通过类名加 .调用 
		 * 4.static方法中，可以使用static数据成员或方法成员
		 * */
		
		System.out.println(Ball.PI);
		System.out.println(Ball.toRadians(90));
		// 4.
		/* 提示：
		 * 即使在同一类中，也明确使用类名称 加上. 运算符来调用static成员。
		 * */
		Ball.method();
		
		// 5. 如果有些动作想在位码加载后执行，则可以定义static区块
		Ball2 ball2 = new Ball2();
		
		/* 6.第14章会谈到JDBC，加载JDBC驱动程序的方式之一就是运用 Class.forName() 动态加载Driver操作类的位码。
		 * 
		 * Class.forName("com.mysql.jdbc.Driver"); 
		 * 这个代码段，会将Driver.class载入JVM，而com.mysql.jdbc.Driver的原始码中，就是在static区块中进行驱动程序实例注册的操作。
		 * 
		 * */ 
		
		/* 在JDK5之后，新增了 import static语法，可以在使用静态成员时少打几个字。
		 * 
		 * import static java.lang.System.in;
		 * import static java.lang.System.out;
		 * 或者改为一行：import static java.lang.System.*;
		 * 
		 * 与import一样，import static语法是为了偷懒，但别偷懒过头，要注意各种名称冲突问题。
		 * 
		 * 有些名称冲突编译程序可通过以下顺序来解析：
		 * 1.局部变量覆盖：选用方法中同名变量、参数、方法名称；
		 * 2.成员覆盖：选用类中定义的同名数据成员、方法名称。
		 * 3.重载方法比较：使用 import static 的各个静态成员，若有同名冲突，尝试通过重载判断。
		 * 
		 * 如果无法判断，则会回报错误。
		 * 
		 * */
		Scanner scanner = new Scanner(in);
		out.print("请输入姓名: ");
		out.printf("%s 你好!\n",	scanner.nextLine());
		
	}
	// 不定长度自变量
	public static void exp6() {
		/* 在调用方法时，若方法的自变量个数事先无法决定该如何处理
		 * 
		 * 例如System.out.printf()方法就无法事先决定自变量个数：
		 * System.out.printf("%d", 10);
		 * System.out.printf("%d %d", 10 ,20);
		 * ...
		 * 在JDK5之后支持不定长度自变量，可以轻松地解决这个问题。
		 * */
		// 注意1.要使用不定长自变量， 声明参数列表时要在类型关键字后面加上...，通过增强式for循环来取得不定长度自变量中的每个元素。
		System.out.println(MathTool.sum(100, 100, 300));
		System.out.println(MathTool.sum(25, 37));
		
		/* 实际上不定长自变量是编译程序蜜糖，反编译后就可以一窥究竟。
		 * (int... numbers) -> (int ai[]);
		 * 实际展开为数组，而调用不定长度自变量的客户端展开后:
		 * MathTool.sum(100, 200, 300) -> sum(new int[] {100, 200, 300});
		 * 
		 * 因此，在JDK1.4之前，也可以使用数组来解决自变量个数无法确认的情况。
		 * 
		 * */
		// 注意2.使用不定长自变量时，方法声明的不定长参数必须放在最后。
		MathTool.some(100, 200, 100, 2000);
		
		// 注意3.使用两个以上不定长度自变量也是不合法的
	}
	// 内部类
	public static void exp7() {
		/* 可以在类中， 再定义类，这称为内部类。（这里先简单介绍语法）*/
		
		/* 1.内部类可以定义在类区块之中。
		 * 
		 * 不过要使用 MySome中的Other类，必须先建立MySome 实例
		 * */
		MySome s = new MySome();
		MySome.Other o = s.new Other();
		
		// 2. 内部类也可以使用 public、pritected、private声明
		
		// 3. 内部类也可以声明为static，通常是将外部类当作命名空间
		MySome.Other3 o3 = new MySome.Other3();
		
		// 4.方法中也能够声明类
		MySome s4 = new MySome();
		s4.doSome();
	}
	
	// 传值调用
	public static void exp8() {
		/* 在一些程序中，像C++之类的程序语言，调用方法传递自变量给参数时，可以有 
		 * 
		 * 传值调用，或 传参考调用，在Java中，只有传值调用（也称 传值(其实 就可以理解为传指针)）。
		 * 
		 * 例子：
		 * */
		Customer c1 = new Customer("Justin");
		// 传值, 注意引用参考
		CallByValue.some(c1);
		System.out.println(c1.name); // John
		
		Customer c2 = new Customer("Justin");
		CallByValue.other(c2);
		System.out.println(c2.name); //	Justin
		
		// 如果由方法中返回对象，并指定给变量，也是传值。
		Customer s3 = CallByValue.create("嘻嘻");
		System.out.println(s3.name);
	}
	
}
//+++++++++++++传值调用+++++++++++++
class Customer {
	String name;
	Customer(String name) {
		// TODO Auto-generated constructor stub
		this.name = name; 
	}
}
class CallByValue {
	public static void some(Customer c) {
		c.name = "John"; 
		/* 改变了哪个对象？
		 * 
		 * 将c参考对象对name成员指定为John，该方法执行结束后，c变量不存在了
		 * */
	}
	public static void other(Customer c) {
		c = new Customer("Bill"); 	
		/* c 参考了哪个对象？
		 * 
		 * c 参数又重新指向了一个新对参考。
		 * 此方法结束后，c参考的对象会被JVM清除
		 * */
	}
	
	// 由方法中返回对象
	public static Customer create(String name) {
		Customer customer = new Customer(name);
		return customer;
	}
}

//+++++++++++++内部类+++++++++++++
class MySome {
	/* 1.内部类可以定义在类区块之中。
	 * 
	 * 例如以下程序片段建立了非静态的内部类。
	 * 编译会产生MySome.class 和 MySome%Other.class 文件
	 * 
	 * */
	class Other {
		
	}
	/* 2. 内部类也可以使用 public、pritected、private声明
	 * 
	 * 内部类本身可以存取外部类的成员，通常非静态内部类会声明为private，这类内部类是辅助类中的某些操作而设计，外部不用知道内部类的存在
	 * */
	private class Other2 {
		
	}
	/* 3. 内部类也可以声明为static，通常是将外部类当作命名空间
	 * 
	 * 被声明为static的内部类，虽然将外部类当作命名空间，但算个独立类。
	 * 它可以存取外部类Static成员， 但不可存取外部类但非 static成员。
	 * */ 
	static class Other3 {
		
	}
	
	/* 4.方法中也能够声明类 
	 * 
	 * 这通常是辅助方法中演算之用，方法之外无法使用。
	 * */
	public void doSome() {
	
		/* 1.具名的内部类
		 * 编译会产生MySome.class 和 MySome$1Other.class 文件
		 * 1 这个数字，表示它是位于方法中的第一个内部类
		 * */
		class Other {
			
		}
		/* 2.实际上，在方法中倒是很少见定义具名的内部类
		 * 
		 * 倒是很常见方法中定义的匿名内部类，并直接实例化，这与类继承或接口操作有关。
		 * 
		 * 语法如下:
		 * new 表示实例化这个没有名称的类。并且为这个类定义了  toString 方法
		 * 编译会产生MySome.class 和 MySome$1.class 文件
		 * 1 这个数字，表示它是位于方法中的第一个匿名内部类，类没有名称
		 * */ 
		Object object = new Object() {
			public String toString() {
				return "匿名内部类 无聊的语法示范而已";
			}
		};
		System.out.println(object.toString());
	}
	
}


//+++++++++++++不定长度自变量+++++++++++++
class MathTool {
	
	/* 1.要使用不定长自变量， 声明参数列表时要在类型关键字后面加上...，通过增强式for循环来取得不定长度自变量中的每个元素。
	 * */
	public static int sum(int... numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum = sum + number;
		}
		// 使用普通for也可以
//		for (int i = 0; i < numbers.length; i++) {
//			
//		}
		return sum;
	}
	/* 2.使用不定长自变量时，方法声明的不定长参数必须放在最后。*/
	public static void some(int arg1, int arg2, int... varargs) {
		
	}
	/* 3.使用两个以上不定长度自变量也是不合法的*/
	
}


//+++++++++++++static成员+++++++++++++
class Ball2 {
	static {
		// Ball2.class加载JVM后，默认就会执行static区块。
		System.out.println("位码加载后就会执行");
	}
	
}

class Ball {
	double radius;
	/* 每一个Ball对象都会有PI这个值，但是我们知道，PI是一个固定的常数，不用每个对象各自拥有，可以在PI上声明static
	 * 
	 * 声明了static，表示它属于类.
	 * 

	 * */
	static final double PI = 3.14159;
	
	static double toRadians(double angdeg) { // 角度转弧度
		return angdeg * (Ball.PI / 180);
	}
	
	public static void method() {
		System.out.println("static 修饰的方法");
		System.out.println(Ball.PI);;
		Ball.toRadians(100); 
	}
}
//+++++++++++++使用this+++++++++++++
class Something
{
	final int x = 10;
	/* 用 final， 但是没有指定 = ，表示延迟对象成员值的设定。
	 * 但是构造函数代码中，一定要有对该数据成员对设定，否则编译错误
	 * */
	final int y;
	Something() {
		// TODO Auto-generated constructor stub
		// 
		this(10); // y一定要有设置，所以当用户使用这个构造方法时，y给默认值10；
	}
	
	Something(int y) {
		// TODO Auto-generated constructor stub
		this.y = y;
	}

}

class Other {
	{
		System.out.println("对象初始区块");
	}
	Other() {
		// TODO Auto-generated constructor stub
		System.out.println("Other() 构造函数");
	}
	Other(int o) {
		this();
		System.out.println("(int o) 构造函数");
	}
	
}
//+++++++++++++构造函数与方法重载+++++++++++++
class Some {
	private int a = 10;
	private String text = "n.a.";
	public Some(int a) {
		if (a > 0) {
			this.a = a;
		}
	}
	public Some(int a, String text) {
		// 这段代码是重复的，可以在构造函数中调用另一个已定义的构造函数
//		if (a > 0) {
//			this.a = a; 
//		}
		this(a); 
		/* 在Java中，this() 代表了调用一个构造函数，根据自变量类型与个数而定 是哪一个
		 * 注意：
		 * 
		 * this() 只能出现在构造函数的第一行。
		 * */
		
		if (text != null) {
			this.text = text;
		}
		
	}
	public void someMethod() {
		System.out.println("无参");
	}
	public void someMethod(int i) {
		System.out.println("i: "+ i);
	}
	public void someMethod(int i, float f) {
		System.out.println("i: "+ i + "f: " + f);
	}
	
	public void myMethod(int i) {
		System.out.println("int 版本被调用");
	}
	public void myMethod(Integer i) {
		System.out.println("Integer 版本被调用");
	}
}

