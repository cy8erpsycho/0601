package com.my.product.dao;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.RemoveException;
import com.my.product.dto.Product;

public class ProductRepository{
//	private Product[] pArr;
//	private int totalCnt = 0;
	private List<Product> pList;
	public ProductRepository() {
		pList = new ArrayList<>();
	}
    
    /**
     * 상품을 저장소에 추가한다
     * @param p 저장할 상품
     * @throws AddException 
     *   상품번호가 존재할 경우 "이미존재하는 상품입니다"메시지를 갖는 예외가 발생한다
     *   
     */
    public void insert(Product p) throws AddException{
    	for(int i=0; i<pList.size();  i++) {
    		Product p1 = pList.get(i);   //저장소의 상품
    		String p1ProdNo = p1.getProdNo(); //저장소의 상품의 상품번호
    		String pProdNo = p.getProdNo(); //저장하려는 상품의 상품번호
    		if(pProdNo.equals(p1ProdNo)) {
//    			System.out.println("이미 존재하는 상품입니다");
//    			return;
    			throw new AddException("이미 존재하는 상품입니다");
    		}
    	}pList.add(p);
    	
//    	try {
//    		pArr[totalCnt] = p; //GOOD CODE
//    		totalCnt++;   
//    	}catch(ArrayIndexOutOfBoundsException e) {
//    		//System.out.println("저장소가 꽉찼습니다. 현재상품수는" + totalCnt+"입니다");
//    		throw new AddException("저장소가 꽉찼습니다. 현재상품수는" + totalCnt+"입니다");
//    	}
    	
//    	try {
//    		pArr[totalCnt++] = p; //BAD CODE
//    	}catch(ArrayIndexOutOfBoundsException e) {
//    		System.out.println("저장소가 꽉찼습니다. 현재상품수는" + totalCnt+"입니다");
//    	}
    }
	
    private List<Product> ArrayList(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다
     * @param no 상품번호
     * @return 상품
     * @throws com.my.exception.FindException 
     *    번호에 해당상품이 없으면 "상품이 없습니다"메시지를 갖는 예외가 발생한다
     */
    public Product selectByProdNo(String no) throws FindException{
        //상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
        for(int i=0; i<pList.size(); i++){
                 Product p = pList.get(i);
            if(p.getProdNo().equals(no)){ 
            	return p;
            }
        }
        //return null; //상품이 없는 경우 null을 반환한다
        throw new FindException("상품이 없습니다");
    }
    
    /**
     * 모든상품을 검색하여 반환한다
     * @return 상품들
     * @throws FindException
     */
    public List<Product> selectAll() throws FindException{
       List<Product> all = new ArrayList<>();
       for(int i=0; i<pList.size(); i++){
           
           all.add(pList.get(i));
       }
       return all;
    }
    
    /**
     * 단어를 포함한 이름을 갖는 상품들을 반환한다
     * @param word 단어
     * @return 상품들
     * @throws FindException
     */
    public List<Product> selectByProdName(String word) throws FindException{
    	List<Product> all = new ArrayList<>();
    	int cnt = 0; //단어를 포함한 상품수
    	for(int i=0; i<pList.size(); i++) {
    		if(pList.get(i).getProdName().contains(word)) {
    			cnt++;
    		}
    	}
    	
    	int index = 0;
    	for(int i=0; i<pList.size(); i++) {
    		Product p = pList.get(i);    	
    		if(p.getProdName().contains(word)) {
    			all = (List<Product>) p;
    			index++;
    		}
    	}
    	return all;
    }
    /**
     * 상품번호에 해당 상품을 저장소에서 찾아 삭제한다
     * @param prodNo 상품번호
     * @throws com.my.exception.RemoveException 상품번호에 해당 상품이 없을 경우 예외가 발생한다
     */
//    public void delete(String prodNo) throws RemoveException{
////    	try {
////    		selectByProdNo(prodNo);
////    	}catch(FindException e) {
////    		throw new RemoveException(e.getMessage());
////    	}
//    	
//    	int indexOfProdNo = 0; //  상품번호에 해당 상품의 위치
//    	for(int i=0; i<pList.size(); i++) {
//    		if(prodNo.equals(pList.get(i).getProdNo())){
//    			indexOfProdNo = i;
//    			break;
//    		}
//    	}
//    	if(indexOfProdNo == 0) {
//    		throw new RemoveException("상품이 없습니다");
//    	}
//    	//상품위치부터 다음상품을 앞으로 땡겨넣기
//    	for(int i=indexOfProdNo; i<pList.size()-1; i++) {
//    		pList(i) = pList(i+1);
//    	}
//    	//상품번호에 해당 상품이 있으면 
//    	if(indexOfProdNo > 0) { 
//    		pList.size()--;
//    	}
//    }    
} 