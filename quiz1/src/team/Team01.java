package team;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Team01 {

	public static void main(String[] args) {
		
		Engineer engineer1 = new Engineer("김엔진");
		Engineer engineer2 = new Engineer("정엔진");	
		
		ArrayList<Benz> benzList = new ArrayList<>();
		
		Benz benz = new Benz(200, "A-Class");
		AMG amg = new AMG(300, "G-Class 63 AMG", engineer1);

		//다음 두 줄을 한 줄로 줄여주세요
		//업캐스팅
		//AMG temp = new AMG(522, "AMG_GT", engineer1);
		//Car car = temp;
		Car car = new AMG(522, "AMG_GT", engineer1);
		
    //car의 엔지니어를 [정엔진]씨로 바꾸고, 엔지니어의 이름을 출력해주세요
		((AMG)car).engineer = engineer2;
		System.out.println("바꾼 엔지니어 이름 => " + ((AMG)car).engineer.name);
		
		benzList.add(benz);
		benzList.add(amg);

		//car를 컴파일에러 없이 benzList에 추가하고, 모델명을 출력해주세요
		//다운캐스팅
		//benzList.add(car);
		benzList.add((Benz)car);
		System.out.println("마지막으로 추가한 모델 => " + ((Benz)benzList.get(2)).model);
		
		
		Scanner sc = new Scanner(System.in);
		
		//논리적 예외 1
		System.out.print("몇 번째 차를 조회할까요? : ");
//		BufferedReader bf = new BufferedReader()
		
		try{
			int n = sc.nextInt();
			sc.nextLine();
			Benz myBenz = benzList.get(n);
			System.out.println("모델명 : " + myBenz.model);
		}catch (Exception e) {
			System.out.println("해당 차가 존재하지 않습니다.");
		}
		
		//논리적 예외 2
		try {
			System.out.print("마력을 입력하세요 : ");
			int inputHP = sc.nextInt();	
			Benz yourBenz = new Benz(inputHP, "님이 산 차");
			System.out.println(yourBenz.model + "의 마력은 " + yourBenz.HP + " 입니다.");
		}catch(RuntimeException e) {
			System.out.println("님이 산 차의 " + e.getMessage());
		}
	}

}


class Engineer{
	String name;
	Engineer(String name){
		this.name = name;
	}
}

class Car {
	int HP;
	public Car(int HP) {
		if(HP<=0) {
			throw new RuntimeException("마력은 0이나 음수가 될 수 없습니다.");
		}
		this.HP = HP;
	}
}

//상위 클래스에 매개변수가 있는 생성자 존재하기에 기본생성자 생성 불가
class Benz extends Car{
	String model;
	public Benz(int HP, String model) {
		super(HP);
		this.model = model;
	}
}

//상위 클래스에 매개변수가 있는 생성자 존재하기에 기본생성자 생성 불가
class AMG extends Benz{
	Engineer engineer;
	
	public AMG(int HP, String model, Engineer engineer) {
		super(HP, model);
		this.engineer = engineer;
	}
	
	public String getEngineerName() {
		return engineer.name;
	}
}

