package cc.openhome.virtual;

import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class MyClass {

	// 对象封装初始流程
	public static void exp1() {
		// 创建对象
		CashCard card1 = new CashCard();
		card1.number = "62279987563"; // 可以通过. 运算存取数据成员
		card1.balance = 500;
		card1.bonus = 0;
		
		CashCard card2 = new CashCard();
		card2.number = "62279989090";
		card2.balance = 800;
		card2.bonus = 1;
		/* 做初始化动作，上面建立对象出现很多重复的流程，可以改进
		 * 定义构造函数改进这个问题：
		 * */ 
		CashCard2 card21 = new CashCard2("6777425", 240, 0);
		CashCard2 card22 = new CashCard2("6777345", 540, 3);
		
		// 显示对象的内容
		CashCard2[] cashCard2s = {
				new CashCard2("622001", 120, 8),
				new CashCard2("622002", 3000, 1),
				new CashCard2("622003", 10000, 1)
		};
		for (CashCard2 cashCard2 : cashCard2s) {
			System.out.printf("(%s, %d, %d)	", cashCard2.number, cashCard2.balance, cashCard2.bonus);
		}
	}
	
	// 封装对象操作流程
	public static void exp2() {
		// 假设使用CashCard2建立3个对象，并要再对所有对象进行储值操作：
		
		Scanner scanner = new Scanner(System.in);
		CashCard2 card21 = new CashCard2("A001", 500, 0);
		System.out.println("输入储蓄金额:");
		int money = scanner.nextInt();
		if (money > 0) {
			card21.balance += money;
			if (money > 1000) {
				card21.bonus++;
			}
		} else {
			System.out.println("储值是负的？你是乱来的吗？");
		}
		CashCard2 card22 = new CashCard2("A002", 300, 0);
		System.out.println("输入储蓄金额:");
		money = scanner.nextInt();
		if (money > 0) {
			card22.balance += money;
			if (money > 1000) {
				card22.bonus++;
			}
		} else {
			System.out.println("储值是负的？你是乱来的吗？");
		}
		/* ......如此判断很麻烦，不可能每一个用户都这么判断一次。
		 * 解决方法如下：
		 * */ 
		CashCard2 card23 = new CashCard2("A003", 300, 0);
		System.out.println("输入储蓄金额:");
		card23.store(scanner.nextInt());
		System.out.println("card23剩余点数: " + card23.exchange());
		
		
	}
	
	// 封装对象内部数据
	public static void exp3() {
		/* Private 关键字
		 * 在上一个代码中
		 * 若用户没有调用 store 方法，而是直接赋值balance， 那么就不能进行该方法里面的一系列检查。
		 * 
		 * 问题出在那里？因为没有封装 CashCard2 中不想让用户直接存取的私有数据，用户撰写就有了自由存取类私有数据的选择
		 * 如果有些数据 是类所私有，在Java中，可以使用 Private 关键字
		 * 
		 * 1.Private 可以用在方法或 构造函数声明上，私有方法或者构造函数 通常是类内部某个共享的演算流程，外界不用知道私有方法的存在。
		 * 2.Private 也可以用在内部类的声明。
		 * */
		System.out.println("Private 关键字");
		
		CashCard3 card3 = new CashCard3("A001", 10000, 10);
		System.out.println("number: " + card3.getNumber());
		
		/* 什么是封装？
		 * 封装目的主要就是隐藏对象细节，将对象当作黑箱进行操作。
		 * 
		 * */
	}
}
/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

// +++++++++++++封装对象内部数据+++++++++++++
class CashCard3 {
	/* 使用private定义私有成员*/
	private String number; 	// 卡号
	private int balance;	// 余额
	private int bonus;		// 红利点数
	
	CashCard3(String number, int balance, int bonus) { // 构造方法
		this.number = number;
		this.balance = balance;
		this.bonus = bonus;
	}
	void store(int money) { // 要修改balance，得通过store()定义的流程
		if (money > 0) {
			this.balance += money;
			if (money > 1000) {
				this.bonus++; // 每增加1000元，就增加一点红利
			}
		} else {
			System.out.println("储值是负的？你是乱来的吗？");
		}
	}
	/* 提供取值方法成员
	 * 如果不提供 getter方法，用户一定无法取得。（Java中，取之方法一般是固定 以 get开头）
	 * */
	String getNumber() {
		return number;
	}
	int getBalance() {
		return balance;
	}
	int getBonus() {
		return bonus;
	}
}

// +++++++++++++对象封装初始流程+++++++++++++
class CashCard {
	String number; 	// 卡号
	int balance;	// 余额
	int bonus;		// 红利点数
}
class CashCard2 {
	String number; 	// 卡号
	int balance;	// 余额
	int bonus;		// 红利点数
	/* 构造函数
	 * 构造函数是与类同名的方法，不用声明返回类型。实现对对象对初始化流程的封装。
	 * */ 
	CashCard2(String number, int balance, int bonus) {
		this.number = number;
		this.balance = balance;
		this.bonus = bonus;
	}
	void store(int money) { // 储值时调用的方法
		if (money > 0) {
			this.balance += money;
			if (money > 1000) {
				this.bonus++; // 每增加1000元，就增加一点红利
			}
		} else {
			System.out.println("储值是负的？你是乱来的吗？");
		}
	}
	void charge(int money) { // 扣款时调用的方法
		if (money > 0) {
			if (money <= this.balance) {
				this.balance -= money;
			} else {
				System.out.println("钱不够啦!");
			}
		} else {
			System.out.println("扣负数？你是乱来的吗？");
		}
	}
	int exchange() { // 返回剩余点数
		return this.bonus;
	}
}


