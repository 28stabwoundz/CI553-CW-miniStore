package catalogue;

import static org.junit.jupiter.api.Assertions.*;
import catalogue.SortByNum;

import org.junit.jupiter.api.Test;

class SortByNumTest {

	@Test
	void testSorting() {
		BetterBasket br = new BetterBasket();
		Product p1 = new Product("0001","Toaster",12.3,1);
		Product p2 = new Product("0002","Microwave",100.99,1);
		
        br.sort(new SortByNum());{
			br.add(p2);
			br.add(p1);
		}
        
        BetterBasket expected = new BetterBasket();
 
        expected.add(p1);
        expected.add(p2);
        
        
		
		assertEquals(2, br.size(), "The size of sorted list should match");
		for (int i = 0; i < br.size(); i++) {
			assertEquals(expected.get(i).getProductNum(), br.get(i).getProductNum(),
					"Numbers should match after sorting");
		}
		
	}

}
