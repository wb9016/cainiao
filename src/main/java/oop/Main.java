package oop;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		// TODO: 用抽象类给一个有工资收入和稿费收入的小伙伴算税:
		Income[] incomes = new Income[] {  new SalaryIncome(75000), new RoyaltyIncome(12000) };
		double total = 0;
		// TODO:
		total=incomes[0].getNum()+incomes[1].getNum();

//		System.out.println(total);

		person a1=new person(23,"wb");
		person a2 = new person(24, "a2");

//		a1.num =11;
//		System.out.println(a2.num);

		String s1="hello";




	}

}
class person{
	public int age;
	public String name;
	public static int num;

	public person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
