public class GoodDeal {

  public static boolean goodDeal(double originalPrice, double salePrice) {
    if(salePrice < (0.75*originalPrice)) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testGoodDeal(double originalPrice, double salePrice, boolean expected) {
    boolean result = goodDeal(originalPrice, salePrice);

    System.out.println("original price: " + originalPrice +
                      " salePrice: " + salePrice +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("yay!");
    }
    else {
      System.out.println("... try again");
    }
  }

  public static void main(String[] args) {
    testGoodDeal(100, 35, true);
    System.out.println("");

    testGoodDeal(100, 95, false);
    System.out.println("");
  }
}
