package cc.openhome.others;

import cc.openhome.virtual.Person;
import cc.openhome.virtual.Student;
public class Student2 extends Person {
	
	public Student2(String name_public, String name_protected, String name_default, String name_private) {
		super(name_public, name_protected, name_default, name_private);
		// TODO Auto-generated constructor stub
	}
	
	/* 在外包
	 * 子类中 能够访问的方法*/
	public void myMothed() {
		this.getPublicName();
		this.getProtectedName();
	}
	
	@Override
	protected String getProtectedName() {
		// TODO Auto-generated method stub
		return super.getProtectedName();
	}
	
	/* 在外包
	 * 子类中 能够访问的实例*/
	public void setPublicName(String s) {
		this.name_public = s;
	}
	public void setProtected(String s) {
		this.name_protected = s;
		
		/* 注意:
		 * 1.在生成派生类时，派生类可以继承基类的protected成员，这个继承的protected成员在派生类内部是可以访问的，但是在派生类内部无法直接访问基类对象的protected成员
		 * */
		Person person = new Person("s", "s", "name_default", "name_private");
//		person.name_protected
		
		/* 2.一种派生类内部只能访问该种派生类的对象继承的基类protected成员，不能访问基类的其他派生类对象继承的基类protected成员*/
		Student student = new Student("s", "s", "name_default", "name_private");
//		student.name_protected
		
	}
}
