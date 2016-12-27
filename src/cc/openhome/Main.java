package cc.openhome;
import cc.openhome.*; // 导入openhome下的所有包
import cc.openhome.virtual.MyClass;
import cc.openhome.virtual.MyClass2;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exp2();
	}
	/* ********************5.2 类语法细节******************** */
	public static void exp2() {
//		MyClass2.exp1(); // 5.2.1 public 权限修饰
//		MyClass2.exp2(); // 5.2.2 关于构造函数
//		MyClass2.exp3(); // 5.2.3 构造函数与方法重载
//		MyClass2.exp4(); // 5.2.4 使用this/final
//		MyClass2.exp5(); // 5.2.5 static成员
//		MyClass2.exp6(); // 5.2.6 不定长度自变量
//		MyClass2.exp7(); // 5.2.7 内部类
		MyClass2.exp8(); // 5.2.8 传值调用
	}
	
	/* ********************5.1 何谓封装******************** */
	public static void exp1() {
//		MyClass.exp1(); // 5.1.1 对象封装初始流程
//		MyClass.exp2(); // 5.1.2 封装对象操作流程
		MyClass.exp3(); // 5.1.3 封装对象内部数据
	}
}

