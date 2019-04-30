package Bean;

public class Student {
	private String id;
	private String name;
	private String cla;
	private String mathgrade;
	private String chinesegrade;
	private String englishgrade;
	private String password;
	
	public Student() 
	{
		
	}
	
	public Student(String id, String name, String cla, String mathgrade, String chinesegrade, String englishgrade,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.cla = cla;
		this.mathgrade = mathgrade;
		this.chinesegrade = chinesegrade;
		this.englishgrade = englishgrade;
		this.password = password;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCla() {
		return cla;
	}
	public void setCla(String cla) {
		this.cla = cla;
	}
	public String getMathgrade() {
		return mathgrade;
	}
	public void setMathgrade(String mathgrade) {
		this.mathgrade = mathgrade;
	}
	public String getChinesegrade() {
		return chinesegrade;
	}
	public void setChinesegrade(String chinesegrade) {
		this.chinesegrade = chinesegrade;
	}
	public String getEnglishgrade() {
		return englishgrade;
	}
	public void setEnglishgrade(String englishgrade) {
		this.englishgrade = englishgrade;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cla=" + cla + ", mathgrade=" + mathgrade + ", chinesegrade="
				+ chinesegrade + ", englishgrade=" + englishgrade + "]";
	}
	

	
	
}
