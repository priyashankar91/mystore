package Model;

import java.util.ArrayList;
//import java.util.List;

public class ShoppingCart {
	static ArrayList<Product> cartList = new ArrayList<Product>();
	public static void addToCart(Product p) {
		cartList.add(p);
	}
	public static ArrayList<Product> getList() {
		return cartList;
	}
	public static void EmptyCart() {
			cartList.clear();
	}
}
