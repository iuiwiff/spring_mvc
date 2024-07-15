package kr.co.sist.vo;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ParamVO {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
//	public void setName(@RequestParam(required= false, defaultValue="윤웅찬") String name) {
//		System.out.println("name-----------"+name);
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		System.out.println("age-----------"+age);
//		this.age = age;
//		
//	}
	
	
}
