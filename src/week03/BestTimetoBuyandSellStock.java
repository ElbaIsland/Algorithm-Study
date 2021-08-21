package week03;


public class BestTimetoBuyandSellStock {
	
    public int maxProfit(int[] prices) {
        
    //	Map<String, Integer> priceStock = new HashMap<>();
    	int BuyValue = prices[0];
    //	int sellValue = 0;
    	int returnValue = 0;
    	
    	if (prices.length > 1) {
    		
	    	for (int i = 0; i < prices.length; i++) {
	    		
	    		returnValue = Math.max(returnValue, prices[i] - BuyValue);
	    		
	    		if(prices[i] < BuyValue) {
	    			BuyValue = prices[i];
	    		}
	    		
	   // 		System.out.println(i + "¹øÂ° return : " + returnValue + ",BuyValue : " + BuyValue);
	    		
			}  			
		}
    	
    	System.out.println(returnValue);
    	return returnValue;
    }
    
    public static void main(String[] args) {
    	
    	int[] stock = {7,1,5,3,6,4};
    	int[] stock2 = {7,4,2};
    	
	    BestTimetoBuyandSellStock testSell = new BestTimetoBuyandSellStock();
	    testSell.maxProfit(stock2);
		
	}
}
