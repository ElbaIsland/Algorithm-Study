package week03;

import java.util.HashMap;
import java.util.Map;


public class BestTimetoBuyandSellStock {
	
    public int maxProfit(int[] prices) {
        
    	Map<String, Integer> priceStock = new HashMap<>();
    	int buyPrice = 0;
    	int sellPrice = 0;
    	
    	for (int i = 1; i < prices.length; i++) {
    		
    		System.out.println("i : " + i + ", sellPrice : " + sellPrice + ", prices[i] : " + prices[i]);
    				
			// 처음 buy, sell값 세팅
			if(!priceStock.containsKey("Buy")) {
				if (prices[i-1] < prices[i])  {	
					priceStock.put("Buy", prices[i-1]);	
					priceStock.put("Sell", prices[i]);	
				}
				else {
					priceStock.put("Buy", prices[i]);	
					priceStock.put("Sell", 0);
	    		}	
			}
			else {	//	기존값과 비교 후 세팅
				buyPrice = priceStock.get("Buy");
				sellPrice = priceStock.get("Sell");
				
				if (prices[i] < buyPrice) {
					priceStock.put("Buy", prices[i]);	
				}
				else if(prices[i] > sellPrice) {
					priceStock.put("Sell", prices[i]);	
				}
			}
    		
		}   	
    	
    	int returnPrice = sellPrice - buyPrice;
    	
    	if (returnPrice < 0) {
			returnPrice = 0;
		}
    	
    	System.out.println(priceStock + ", " + returnPrice);
    	return returnPrice;
    }
    
    public static void main(String[] args) {
    	
    	int[] stock = {7,1,5,3,6,4};
    	int[] stock2 = {1,2};
    	
	    BestTimetoBuyandSellStock testSell = new BestTimetoBuyandSellStock();
	    testSell.maxProfit(stock2);
		
	}
}
