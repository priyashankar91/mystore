package Model;

public class Product {
	public static int count = 0;
	int pid;
	String pname;
	int pcost;
	String pspec;
	String category;
	String dateadded;
	String imgpath;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public String getPspec() {
		return pspec;
	}
	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDateadded() {
		return dateadded;
	}
	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}
		
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public void printProduct()
	{
		System.out.println(this.pid);
		if(this.pname!=null) {
		System.out.println(this.pname);
		}else
		{
			System.out.println("EMpty");
		}
		System.out.println(this.pcost);
		System.out.println(this.pspec);
		System.out.println(this.dateadded);
		
	
	}
	
}
