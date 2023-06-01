import com.my.product.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dao.*;

import java.util.List;
import java.util.Scanner;

//0524
public class ProductUser{
	static Scanner sc = new Scanner(System.in); 
	// static 이었던 이유는 메인 매서드가 static 타입이기 때문
	// 자기 클래스내에서는 productUser.sc~에서 productUser 생략

	private ProductRepository repository  = new ProductRepository(); // 최대 10개의 삼풍이 저장될 저장소가 된다

	public void findAll(){// 왜 리턴타입이 없어도 되지
		System.out.println(">>전체상품검색<<");

		List<Product> resultArr;
		try {
			resultArr = repository.selectAll();
			for(int i=0; i<resultArr.size(); i++){
				//			//상품번호 , 상품명, 가격을 출력하세요
				//			//System.out.println("상품번호:" + resultArr[i].getProdNo());
				System.out.println("상품번호:" + resultArr.get(i).getProdNo() + 					
								   ",상품명:" + resultArr.get(i).getProdName() + 
								   ",상품가격:"+ resultArr.get(i).getProdPrice());			
				resultArr.get(i).print();
			}
		} catch (FindException e) {
			e.printStackTrace();
		} // 스태틱매소드만 이름.

		//		//ProductRepository r = new~
		//		//r.selectAll();
		//		//ProductReposit 타입의 객체가 반복할때마다 계속 만들어진다?
		//		//반복문의 바깥에 코드를 작성해서 누적되도록 한다?

	}
	
	private Product resultArr(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectByProdNo(){
		System.out.println(">>상품검색<<");
		System.out.print("상품번호를 입력하세요:");

		String noArg1 = sc.nextLine();//키보드로 입력받기

		System.out.print(noArg1);
		//System.out.println(repository.selectByProdNo(noArg1) == null? "상품이 없습니다": "상품이 있습니다");
		//TODO
		//상품이 존재하면 상품번호, 상품명, 가경을 출력하세요
		Product p;
		try {
			p = repository.selectByProdNo(noArg1);
			if(p != null) {
				p.print();
			}
		} catch (FindException e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	public void add() {
		//		Product pArg = new Product();               
		System.out.println(">>상품추가<<");
		System.out.print("상품번호를 입력하세요:");
		//		pArg.setProdNo(sc.nextLine());//키보드로 입력받기 왜 set ?
		String prodNo = sc.nextLine();

		System.out.println("상품명을 입력하세요:");
		//		pArg.setProdName(sc.nextLine());
		String prodName = sc.nextLine();

		System.out.println("상품가격을 입력하세요");
		//		pArg.setProdPrice(Integer.parseInt(sc.nextLine()));
		int prodPrice = Integer.parseInt(sc.nextLine());

		Product pArg = new Product(prodNo, prodName, prodPrice);     //이게지금
		
		try {
			repository.insert(pArg);
		} catch (AddException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 여러 유형의 사용자의 횐경에 재사용이 가능하게 
		//~~						   // 중복된 코드를 줄여야 함
		//
		//~~
		//~~
	}

	public void findByProdName() {
		System.out.println();	
		System.out.print("단어를 입력하세요. 단어를 포함한 상품명으로 검색합니다 ");
		String word = sc.nextLine();
		List<Product> pArr;
		try {
			pArr = repository.selectByProdName(word);
			for(Product p : pArr) {
				p.print();
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	

	public static void main(String[] args) throws FindException, AddException{
		//ProductRepository repository = new ProductRepository(); // ! 왜? 무슨작업이지?
		//ProductRepository repository  = new ProductRepository(3); // 최대 10개의 삼풍이 저장될 저장소가 된다
		//반복문 이전에 객체를 생성해줘야 메모리? 자원절약을 할수 있다

		ProductUser user = new ProductUser(); // ! 만약 main 밖으로 나가면 user가 멤버변수
		String opt;
		do{
			System.out.println("작업을 선택하세요");
			System.out.print("1:상품전체검색,  2:상품번호로검색, 3: 상품추가, 4.:부분검색 9: 종료");
			opt = sc.nextLine();//키보드로 입력받기
			if(opt.equals("1")){ // * ==비교연산자 사용안함
				//0525 메인 메서드가 너무 커져 간단히 변경
				user.findAll();


				//				System.out.println(">>전체상품검색<<");
				//				Product []resultArr = repository.selectAll(); // 스태틱매소드만 이름.
				//				
				//				for(int i=0; i<resultArr.length; i++){
				//					//상품번호 , 상품명, 가격을 출력ㅎ사에ㅛ
				//					//System.out.println("상품번호:" + resultArr[i].getProdNo());
				//				System.out.println("상품번호:" + resultArr[i].getProdNo() + 
				//							",상품명:" + resultArr[i].getProdName() + ",상품가격:"+ resultArr[i].getProdPrice());
				//					resultArr[i].print();
				//				
				//				}
				//				//ProductRepository r = new~
				//				//r.selectAll();
				//				//ProductReposit 타입의 객체가 반복할때마다 계속 만들어진다?
				//				//반복문의 바깥에 코드를 작성해서 누적되도록 한다?

			}else if(opt.equals("2")){
				user.selectByProdNo();
				//				System.out.println(">>상품검색<<");
				//				System.out.print("상품번호를 입력하세요:");
				//
				//				String noArg1 = sc.nextLine();//키보드로 입력받기
				//
				//				System.out.print(noArg1);
				//				System.out.println(repository.selectByProdNo(noArg1) == null? "상품이 없습니다": "상품이 있습니다");
				//				//TODO
				//				//상품이 존재하면 상품번호, 상품명, 가경을 출력하세요
				//				Product p = repository.selectByProdNo(noArg1);
				//				if(p != null) {
				//					p.print();
			}else if(opt.equals("3")){
				user.add();
				//				Product pArg = new Product();               
				//				System.out.println(">>상품추가<<");
				//				System.out.print("상품번호를 입력하세요:");
				//				pArg.setProdNo(sc.nextLine());//키보드로 입력받기 왜 set ?
				//				String prodNo = sc.nextLine();
				//				
				//				System.out.println("상품명을 입력하세요:");
				//				pArg.setProdName(sc.nextLine());
				//				String prodName = sc.nextLine();
				//				
				//				System.out.println("상품가격을 입력하세요");
				//				pArg.setProdPrice(Integer.parseInt(sc.nextLine()));
				//				int prodPrice = Integer.parseInt(sc.nextLine());
				//				
				//				Product pArg = new Product(prodNo, prodName, prodPrice);     //이게지금
				//				repository.insert(pArg);// 여러 유형의 사용자의 횐경에 재사용이 가능하게 
				//				//~~						   // 중복된 코드를 줄여야 함
				//												//
				//				//~~
				//				//~~
			}else if(opt.equals("4")) {
				user.findByProdName();

				//					TODO
				//					4:상품이름으로 검색 :TV
				//					A:TV:10
				//					C:삼성TV:10
				//					H:TV수신기:30
				//				System.out.println("상품명을 입력하세요:");
				//				String prodName = sc.nextLine();
				//				int index = prodName.indexOf(sc.nextLine());
				//				boolean result = prodName.contains(sc.nextLine());
				//				System.out.println(prodName.contains(sc.nextLine()));
				//			System.out.println();	
				//			System.out.print("단어를 입력하세요. 단어를 포함한 상품명으로 검색합니다 ");
				//			String word = sc.nextLine();
				//			Product[]pArr = repository.selectByProdName(word);
				//			for(Product p : pArr) {
				//				p.print();


				//			Product[] pArr = repository.selectAll();
				//			for(Product p : pArr) {
				//				if(p.getProdName().contains(word)) {
				//					p.print();
				//				}
				//			}


				//			}else if(opt.equals("4")){
				//	        	   System.out.println(">>상품이름으로 검색<<");
				//	        	   System.out.print("상품이름을 입력하세요:");
				//	        	   String nameArg1=sc.nextLine();
				//	        	   Product[]resultArr = repository.selectAll();
				//	        	   boolean check=false;
				//	               for(int i=0; i<resultArr.length; i++){
				//	            	   if (resultArr[i].getProdName().contains(nameArg1)) {
				//	            		   resultArr[i].print();
				//	            		   check=true;
				//	            	   }
				//	               }
				//	        	   if (!check)
				//	        		   System.out.println("찾는 상품이름은 없습니다.");
				//	        	   
				//	        	   //상품이름으로 검색:TV 라고 하면 A:TV:10 상품이름에 TV라고 있으면 모두 출력
				//	        	   //예: A:TV:10 C:상섬TV:10 F:LGTV:20 H:TV수신기:30 X:삼성TV-QLED:40
				//	        	   
				//	           }


				//			else if (opt.equals("4")) {
				//				System.out.println("상품 이름으로 검색");
				//				String pName = sc.nextLine();
				//
				//				repository.selectByProdName(pName);
				//			}
				//
				//			public class ProductRepository {
				//				public void selectByProdName(String pName) {
				//					for (int i = 0; i < totalCnt; i++) {
				//						Product p = pArr[i];
				//						if (p.getProdName().contains(pName)) {
				//				System.out.println(p.getProdName());
				//			}
				//		}
				//	}
				//}
				//			public Product selectByProdName(String pName) {
				//				Product p = null;
				//				for (int i = 0; i < totalCnt; i++) {
				//					if (p.getProdName().contains("TV")) {
				//						p = new Product();
				//						return p;
				//					}
				//				}
				//				return null;
				//			}

				// 		--- 삭제하기	
				//				public void delete(String no) {
				//					int indexD=totalCnt;
				//					for (int i=0; i<totalCnt;i++) {
				//						if (pArr[i].getProdNo().equals(no)) {
				//							indexD=i;
				//							break;}
				//					}
				//					if(indexD==totalCnt) { //삭제할 번호 없으면
				//						System.out.println("삭제할 상품번호가 존재하지 않습니다.");
				//						return;}
				//					else if (indexD==totalCnt-1) { //끝에 요소 삭제할 경우
				//						totalCnt--;
				//						System.out.println("삭제가 완료되었습니다.");
				//					}else { //중간삭제인 경우 
				//						for (int i=indexD;i<totalCnt;i++) {
				//							pArr[i]=pArr[i+1];				
				//						}
				//						totalCnt--;
				//					}
				//					
				//
				//				}	



			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));


	}
}


