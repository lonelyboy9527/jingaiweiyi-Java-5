package cc.openhome.others;
import cc.openhome.virtual.Person;
public class MyClass2_1 {
	
	// 不同包
	public static void exp1() {
		Person p1 = new Person("name_public", "name_protected", "name_default", "name_private");
		p1.name_public = "修改name_public"; 		// 外包
		System.out.println(p1.getPublicName()); // 外包
	}
	// 不同包，子类
	public static void exp2() {
		Student2 s2 = new Student2("student_public", "student_protected", "student_default", "student_private");
		s2.name_public = "修改student_public";
		s2.setProtected("修改student_protected");   // 重新写个setter
		// 子类实例调用
		System.out.println(s2.getPublicName());
		System.out.println(s2.getProtectedName()); // 重写方法，能够访问
		// 子类中调用
		s2.myMothed();
	}
}
