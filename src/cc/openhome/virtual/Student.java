package cc.openhome.virtual;

public class Student extends Person {

	public Student(String name_public, String name_protected, String name_default, String name_private) {
		super(name_public, name_protected, name_default, name_private);
		// TODO Auto-generated constructor stub
	}

	/* 在本包
	 * 子类中 能够访问的方法*/
	public void myMothed() {
		this.getPublicName();
		this.getProtectedName();
		this.getDefaultName();
	}
	
	/* 在本包
	 * 子类中 能够访问的实例*/
	public void setPublicName(String s) {
		this.name_public = s;
	}
	public void setProtected(String s) {
		this.name_protected = s;
	}
	public void setDefaultName(String s) {
		this.name_default = s;
	}
}
