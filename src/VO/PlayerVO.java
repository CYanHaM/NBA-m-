package VO;

public class PlayerVO {
	public String name;            //姓名
	public int uniformNum;      //球衣号码
	public String position;        //位置
	public String height;          //身高（英尺-英寸）
	public double weight;          //体重（磅）
	public String birth;           //生日（月 日，年）
	public int age;                //年龄
	public int exp;             //球龄
	public String school;          //毕业学校
	
	public boolean equals(PlayerVO pvo){
		if(!this.name.equals(pvo.name)){
			System.out.println("name");
			return false;
		}
		if(this.uniformNum!=pvo.uniformNum){
			System.out.println("uniformNum");
			return false;
		}
		if(!this.position.equals(pvo.position)){
			System.out.println("position");
			return false;
		}
		if(!this.height.equals(pvo.height)){
			System.out.println("height");
			return false;
		}
		if(this.weight!=pvo.weight){
			System.out.println("weight");
			return false;
		}
		if(!this.birth.equals(pvo.birth)){
			System.out.println("birth");
			return false;
		}
		if(this.age!=pvo.age){
			System.out.println("age");
			return false;
		}
		if(this.exp!=pvo.exp){
			System.out.println("exp");
			return false;
		}
		if(!this.school.equals(pvo.school)){
			System.out.println("school");
			return false;
		}
		return true;
	}
}
