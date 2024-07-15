package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public List<String> searchNames(){
		List<String> list= new ArrayList<String>();
		list.add("윤웅찬");
		list.add("김무영");
		list.add("김동섭");
		list.add("이명화");
		list.add("박시현");
		return list;
	}
	
	public String searchId() {
		String[] ids="kim,yoon,kindong,lee,park".split(",");
		
		return ids[new Random().nextInt(ids.length)];
	}
}
