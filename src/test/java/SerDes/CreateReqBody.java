package SerDes;

public class CreateReqBody {
private String name;
private String description;
private boolean ispublic;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isIspublic() {
	return ispublic;
}
public void setIspublic(boolean ispublic) {
	this.ispublic = ispublic;
}
}
