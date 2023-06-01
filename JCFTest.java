import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class JCFTest {
	public static void m(Collection c) {
		c.add("one");
		c.add(2);
		c.add(true);	
		c.add(new String("one"));
		c.add(4.0F);
		// 특징 : 순차저장, 중복저장
		
		System.out.println("자료수:"+ c.size()); // int 타입 반환
		System.err.println(c); // c.toString()자동호출됨
				
//		Iterator it = c.iterator();
//		while(it.hasNext()) { // 지금 사용하는 이 반복자에서 방문할 요소가 남았는가? 
//			System.out.println(it.next());
//		}
		
//		for(Object o:c) {
//			System.out.println(o); //향상된 for문 : 차례차례 방문!
//		}
		
		Stream st = c.stream();
		st.forEach(System.out::println);		
		
	}
	
	public static void m(Map m) {
		m.put("one", "first");
		m.put(2, "second");
		m.put(true, "third");
		m.put(new String("one"), "fourth");
		m.put(4.0F, "fifth");
		
		System.out.println("자료수:" + m.size());
		System.out.println(m);
		
		Object value = m.get("one"); //object타입으로 반환
		System.out.println("key:one,value:" + value);// 맵은 중복이 안되고 끊고 새로운경 연결하니까 key:one,value:fourth 값이 나온다
		
		java.util.Date d = (java.util.Date)value; 
		//부모자식이 아닌데 다운캐스팅?을한다, 
		//특정자료형으로 저장하게 해놓고 다른 타입으로 형변환을 해서 쓰려고 하면 컴파일 오류를 발생시키는것=제네릭
		
//		Set keys = m.keySet();
//		Iterator it = keys.iterator();
//		while(it.hasNext()) {
//			Object key = it.next();
//			Object value2 = m.get(key);
//			System.out.println("key:"+key+",value:"+value2);
//		}
		
		//키의 요소 하나하나를 키타입으로 바꾼다?
//		for(Object key:m.keySet()) {
//			Object value2 = m.get(key);
//			System.out.println("key:"+key+",value:"+value2);
//		}
		
		m.keySet().stream().forEach(key->System.out.println("key:" + key+",value:" + m.get(key))); //아직은 뭕 ㅣ모름
	
	
	}
	
	
	
	public static void main(String[] args) {
		Collection c;
		//c = new Collection();
		c = new ArrayList();  // 업캐스팅
		m(c);
		
		
		c = new HashSet();
		m(c);
		// 특징 : 순차저장X, 중복저장X
		
		Map m;
		m = new HashMap();
		m(m);
		
	}

}
