package team;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
class Student {
	String name;
	int age;
}

@Getter
@Setter
@AllArgsConstructor
class Group {
	String groupName;
	Object[] studentArray;
}

public class taeHees {
	// 문제는 문서 하단에 있습니다.

	public static void main(String[] args) {
		prob1();
		prob2();
		prob3();
	}


	static void prob1() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("황태희", 20));
		studentList.add(new Student("김태희", 20));
		studentList.add(new Student("박태희", 20));
	
//		Object[] studentArray = studentList.toArray();
	
//		Group g1 = new Group("3조", studentArray);
	
		// 그룹의 배열에서 1번 인덱스 학생의 이름을 출력하는 코드입니다.
//		Object[] g1Arr = new Group("3조", studentList.toArray()).getStudentArray();
//		Student s1 = (Student) g1Arr[1];
//		String s1Name = s1.getName();
//	
		String s1Name = ((Student)new Group("3조", studentList.toArray()).getStudentArray()[1]).getName();
		System.out.println(s1Name);
		// 여기까지
		// 리팩토링 해주세요.
	}
	
	//예상되는 에러는?
	static void prob2() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("황태희", 20));
		studentList.add(new Student("김태희", 20));
		studentList.add(new Student(null, 20));
	
		try {
			System.out.println(studentList.get(2).getName().charAt(0));
		} catch (Exception e) {
			System.out.println(e);
		}
		//java.lang.NullPointerException
	}
	
	//예상되는 에러는?
	static void prob3() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("황태희", 20));
		studentList.add(new Student("김태희", 20));
		studentList.add(new Student(null, 20));
	
		try {
			System.out.println(studentList.get(5).getName().charAt(0));
		} catch (Exception e) {
			System.out.println(e);
		}
		//java.lang.IndexOutOfBoundsException
	}
}