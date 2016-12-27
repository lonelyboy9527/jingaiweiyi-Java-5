package cc.openhome.virtual;

public class Person {
	/* public：
	 * 不用多说，最开放的平台
	 * */
	public String name_public;
	/* protected：
	 * 经常需要允许子类访问定义在父类中的数据和方法，但是不允许非子类访问这些数据和方法，这种情况下就可以使用protected，它允许任何包中的子类访问父类。
	 * */
	protected String name_protected;
	
	/* default：
	 * 指默认修饰符，什么都不加，实际上它限制的范围就是一个包内可以访问。如果不在一个包内，即使继承关系仍然是不能访问的。
	 * */
	String name_default; // default
	
	/* private：
	 * 修饰完全隐藏类的成员，这样，就不能从类的外边直接访问他们，我们提供set和get方法，保证类中数据域的安全。
	 * */
	private String name_private;
	
	public Person(String name_public, String name_protected, String name_default, String name_private) {
		// TODO Auto-generated constructor stub
		this.name_public = name_public;
		this.name_protected = name_protected;
		this.name_default = name_default;
		this.name_private = name_private;
		// 只能在本类中调用
		getPrivateName();
	}
	// 在本类，同包，子类，外包调用
	public String getPublicName() {
		return "调用:" + this.name_public;
	}
	// 在本类，同包，子类调用
	protected String getProtectedName() {
		return "调用:" + this.name_protected;
	}
	// 在本类，同包调用
	String getDefaultName() {
		return "调用:" + this.name_default;
	}
	// 在本类中调用
	private String getPrivateName() {
		return "调用:" + this.name_private;
	}
}


