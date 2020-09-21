package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.dao.AddressDao;
import com.dao.BrandDao;
import com.dao.CartDao;
import com.dao.CategoryDao;
import com.dao.CustomerDao;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.dao.ProductDao;
import com.dao.WishlistDao;
import com.dao.connection.MySqlConnection;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.BrandDaoImpl;
import com.dao.impl.CartDaoImpl;
import com.dao.impl.CategoryDaoImpl;
import com.dao.impl.CustomerDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderDetailDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.WishlistDaoImpl;
import com.entity.Address;
import com.entity.Brand;
import com.entity.Cart;
import com.entity.Category;
import com.entity.Customer;
import com.entity.Order;
import com.entity.OrderDetail;
import com.entity.Product;
import com.entity.Wishlist;

public class MainApp {

	static Customer globalCustomer = null;
	static CustomerDao customerDao = new CustomerDaoImpl(MySqlConnection.getConnection());
	static AddressDao addressDao = new AddressDaoImpl(MySqlConnection.getConnection());
	static ProductDao productDao = new ProductDaoImpl(MySqlConnection.getConnection());
	static BrandDao brandDao = new BrandDaoImpl(MySqlConnection.getConnection());
	static CategoryDao categoryDao = new CategoryDaoImpl(MySqlConnection.getConnection());
	static CartDao cartDao = new CartDaoImpl(MySqlConnection.getConnection());
	static WishlistDao wishlistDao = new WishlistDaoImpl(MySqlConnection.getConnection());
	static OrderDao orderDao = new OrderDaoImpl(MySqlConnection.getConnection());
	static OrderDetailDao orderDetailDao = new OrderDetailDaoImpl(MySqlConnection.getConnection());

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int choice = 0;
		do {
			if (globalCustomer != null) {
				renderMenu();
				choice = Integer.parseInt(input.readLine());
				switch (choice) {
				case 1:
					listCustomers();
					break;
				case 2:
					inputNewCustomer(input);
					break;
				case 3:
					deleteCustomer(input);
					break;
				case 4:
					updateCustomer(input);
					break;
				case 5:
					listAddresses();
					break;
				case 6:
					inputNewAddress(input);
					break;
				case 7:
					deleteAddress(input);
					break;
				case 8:
					listProducts();
					break;
				case 9:
					inputNewProduct(input);
					break;
				case 10:
					updateProduct(input);
					break;
				case 11:
					deleteProduct(input);
					break;
				case 12:
					listCategory();
					break;
				case 13:
					inputNewCategory(input);
					break;
				case 14:
//					updateCategory(input);
					break;
				case 15:
					deleteCategory(input);
					break;
				case 16:
					listBrand();
					break;
				case 17:
					inputNewBrand(input);
					break;
				case 18:
//					updateBrand(input);
					break;
				case 19:
					deleteBrand(input);
					break;
				case 20:
					deleteBrand(input);
					break;
				case 21:
					listCart();
					break;
				case 22:
					addToCart(input);
					break;
				case 23:
					removeCart(input);
					break;
				case 24:
					showWishlist();
					break;
				case 25:
					addWishlist(input);
					break;
				case 26:
					removeWishlist(input);
					break;
				case 27:
					checkoutCart(input);
					break;
				case 98:
					globalCustomer = null;
					System.out.println("Logged Out...");
					break;
				case 99:
					System.out.println("Bye bye...");
					break;
				}
			} else {
				renderAuth();
				choice = Integer.parseInt(input.readLine());
				switch (choice) {
				case 1:
					login(input);
					break;
				case 2:
					inputNewCustomer(input);
					break;
				case 99:
					System.out.println("Bye..bye....");
					break;
				}
			}
			
		} while (choice != 99);
	}
	
	static void renderMenu() {
		System.out.println();
		System.out.println("---------------------");
		System.out.println("A R K C O M M E R C E");
		System.out.println("WELCOME BACK " + globalCustomer.getName() + "! Please choose a menu:");
		System.out.println("---------------------");
		System.out.println("[1]Customer List");
		System.out.println("[2]Create New Customer");
		System.out.println("[3]Delete Customer");
		System.out.println("[4]Update Customer");
		System.out.println("[5]Address List");
		System.out.println("[6]New Address");
		System.out.println("[7]Delete Address");
		System.out.println("[8]New Product");
		System.out.println("[9]Update Product");
		System.out.println("[10]Delete Product");
		System.out.println("[11]New Category");
		System.out.println("[12]Update Category");
		System.out.println("[13]Delete Category");
		System.out.println("[14]New Brand");
		System.out.println("[15]Update Brand");
		System.out.println("[16]Delete Brand");
		System.out.println("[98]Logout");
		System.out.println("[99]Quit");
		System.out.println("----------------------");
		System.out.print("Pilihan: ");
	}
	
	static void renderMenuAdmin() {
		System.out.println();
		System.out.println("---------------------");
		System.out.println("A R K C O M M E R C E");
		System.out.println("WELCOME BACK " + globalCustomer.getName() + "! Please choose a menu:");
		System.out.println("---------------------");
		System.out.println("[1]Customer List");
		System.out.println("[2]Create New Customer");
		System.out.println("[3]Delete Customer");
		System.out.println("[4]Update Customer");
		System.out.println("[5]Address List");
		System.out.println("[6]New Address");
		System.out.println("[7]Delete Address");
		System.out.println("[9]Logout");
		System.out.println("[99]Quit");
		System.out.println("----------------------");
		System.out.print("Pilihan: ");
	}
	
	static void renderAuth() {
		System.out.println();
		System.out.println("---------------------");
		System.out.println("-L O G I N   P A G E-");
		System.out.println("---------------------");
		System.out.println("[1]Login");
		System.out.println("[2]Register");
		System.out.println("[99]Quit");
		System.out.println("----------------------");
		System.out.print("Pilihan: ");
	}
	
	static void login(BufferedReader input) throws IOException {
		System.out.println("--------------------------------------");
		System.out.println("CUSTOMER LOGIN");
		System.out.println("--------------------------------------");
		
		System.out.print("Email : ");
		String email = input.readLine();
		System.out.print("Password : ");
		String password = input.readLine();
		
		Customer temp = null;
		
		try {
			temp = customerDao.getCustomerByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (temp.getPassword().equals(password)) {
			globalCustomer = temp;
			System.out.println("Login Success");
		}
	}

	static void logout() {
		globalCustomer = null;
	}
	
	static void listCustomers() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("CUSTOMER LIST");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("ID Customer" + "\t\t\t" + "Name" + "\t\t\t" + "Email" + "\t\t\t" + "Phone Number");
		try {
			for (int x = 0; x < customerDao.getAllCustomers().size(); x++) {
				System.out.println(((Customer) customerDao.getAllCustomers().get(x)).getId() + "\t\t\t"
						+ ((Customer) customerDao.getAllCustomers().get(x)).getName() + "\t\t\t"
						+ ((Customer) customerDao.getAllCustomers().get(x)).getEmail() + "\t\t\t"
						+ ((Customer) customerDao.getAllCustomers().get(x)).getPhoneNumber());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void inputNewCustomer(BufferedReader input) throws IOException {
		System.out.println("--------------------------------------");
		System.out.println("NEW CUSTOMER");
		System.out.println("--------------------------------------");
		
		Customer customer = new Customer();
		
		System.out.print("Customer Name: ");
		customer.setName(input.readLine());
		System.out.print("Email: ");
		customer.setEmail(input.readLine());
		System.out.print("Password: ");
		customer.setPassword(input.readLine());
		System.out.print("Phone Number: ");
		customer.setPhoneNumber(input.readLine());
		customer.setBalance(0);
		
		try {
			customerDao.addCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Customer Saved...");
	}
	
	static void updateCustomer(BufferedReader input) throws IOException {
//		listCustomers();
//		System.out.println("--------------------------------------");
//		System.out.println("DELETE CUSTOMER");
//		System.out.println("--------------------------------------");
//		System.out.print("Input Customer ID: ");
//		String id = input.readLine();
//		
//		Customer customer = null;
//		
//		try {
//			customer = customerDao.getCustomerById(Integer.parseInt(id));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.print("Customer Name (" + customer.getName() +") :");
//		customer.setName(input.readLine());
//		System.out.print("Email: (" + customer.getEmail() +") :");
//		customer.setEmail(input.readLine());
//		System.out.print("Balance: (" + customer.getBalance() +") :");
//		customer.setBalance(Double.parseDouble(input.readLine()));
//		System.out.print("Phone Number: (" + customer.getPhoneNumber() +") :");
//		customer.setPhoneNumber(input.readLine());
		
		System.out.println("Customer Updated...");
	}
	
	static void deleteCustomer(BufferedReader input) throws IOException {
		listCustomers();
		System.out.println("--------------------------------------");
		System.out.println("DELETE CUSTOMER");
		System.out.println("--------------------------------------");
		System.out.print("Input Customer ID: ");
		String id = input.readLine();

		int x = 0;
		try {
			x = customerDao.deleteCustomer(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (x == 1)
			System.out.println("Data terhapus...");
		else
			System.out.println("Data gagal dihapus...");
	}
	
	static void listAddresses() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("CUSTOMER'S ADDRESS LIST");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("ID Address" + "\t\t\t" + "Customer Name" + "\t\t\t" + "Recipient Name" + "\t\t\t" + "Address" + "\t\t\t" + "Postal Code");
		try {
			for (int x = 0; x < addressDao.getAddressesByCustomer(globalCustomer).size(); x++) {
				System.out.println(((Address) addressDao.getAddressesByCustomer(globalCustomer).get(x)).getId() + "\t\t\t\t"
						+ ((Address) addressDao.getAddressesByCustomer(globalCustomer).get(x)).getCustomer().getName() + "\t\t\t"
						+ ((Address) addressDao.getAddressesByCustomer(globalCustomer).get(x)).getRecipientName() + "\t\t\t"
						+ ((Address) addressDao.getAddressesByCustomer(globalCustomer).get(x)).getAddress() + "\t\t\t"
						+ ((Address) addressDao.getAddressesByCustomer(globalCustomer).get(x)).getPostalCode());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void inputNewAddress(BufferedReader input) throws IOException {
		System.out.println("--------------------------------------");
		System.out.println("NEW ADDRESS (User: " + globalCustomer.getName() + ")");
		System.out.println("--------------------------------------");
		
		Address address = new Address();
		
		address.setCustomer(globalCustomer);
		System.out.print("Recipient Name: ");
		address.setRecipientName(input.readLine());
		System.out.print("Address: ");
		address.setAddress(input.readLine());
		System.out.print("CityId (1/2/3): ");
		address.setCityId(Integer.parseInt(input.readLine()));
		System.out.print("Postal Code: ");
		address.setPostalCode(input.readLine());
		
		try {
			addressDao.addAddress(address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Address Saved...");
	}
	
	static void deleteAddress(BufferedReader input) throws IOException {
		listAddresses();
		System.out.println("--------------------------------------");
		System.out.println("DELETE CUSTOMER");
		System.out.println("--------------------------------------");
		System.out.print("Input Address ID: ");
		String id = input.readLine();
		int x = 0;
		try {
			x = addressDao.deleteAddress(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (x == 1)
			System.out.println("Address Deleted...");
		else
			System.out.println("Failed to Delete Address...");
	}
	
	static void listProducts() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("PRODUCT LIST");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("ID Product" + "\t\t" + "Product Name" + "\t\t\t" + "Color" + "\t\t\t" + "Price" + "\t\t\t" + "Description");
		try {
			for (int x = 0; x < productDao.getAllProducts().size(); x++) {
				System.out.println(((Product) productDao.getAllProducts().get(x)).getId() + "\t\t\t"
						+ ((Product) productDao.getAllProducts().get(x)).getName() + "\t\t\t"
						+ ((Product) productDao.getAllProducts().get(x)).getColor() + "\t\t\t"
						+ "Rp. " + ((Product) productDao.getAllProducts().get(x)).getPrice() + "\t\t\t"
						+ ((Product) productDao.getAllProducts().get(x)).getDescription());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void inputNewProduct(BufferedReader input) throws IOException {
		System.out.println("--------------------------------------");
		System.out.println(" -- A D D   N E W   P R O D U C T --");
		System.out.println("--------------------------------------");
		
		Product product = new Product();
		
		System.out.print("Product Name: ");
		product.setName(input.readLine());
		System.out.print("Product Price: ");
		product.setPrice(Double.parseDouble(input.readLine()));
		System.out.print("Description: ");
		product.setDescription(input.readLine());
		System.out.print("Color: ");
		product.setColor(input.readLine());
		System.out.print("Slug: ");
		product.setSlug(input.readLine());
		System.out.print("Weight: ");
		product.setWeight(Byte.parseByte(input.readLine()));
		listBrand();
		System.out.print("Brand: ");
		int brand_id = Integer.parseInt(input.readLine());
		System.out.print("Category: ");
		int category_id = Integer.parseInt(input.readLine());

		Category category = null;
		Brand brand = null;
		try {
			category = categoryDao.getCategoryById(category_id);
			brand = brandDao.getBrandById(brand_id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		product.setBrand(brand);
		product.setCategory(category);
		
		try {
			productDao.addProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Product Added...");
	}
	
	static void updateProduct(BufferedReader input) throws IOException {
//		Customer customer = null;
//		
//		try {
//			customer = customerDao.getCustomerById(Integer.parseInt(id));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.print("Customer Name (" + customer.getName() +") :");
//		customer.setName(input.readLine());
//		System.out.print("Email: (" + customer.getEmail() +") :");
//		customer.setEmail(input.readLine());
//		System.out.print("Balance: (" + customer.getBalance() +") :");
//		customer.setBalance(Double.parseDouble(input.readLine()));
//		System.out.print("Phone Number: (" + customer.getPhoneNumber() +") :");
//		customer.setPhoneNumber(input.readLine());
		
		System.out.println("Product Updated...");
	}
	
	static void deleteProduct(BufferedReader input) throws IOException {
		listProducts();
		System.out.println("--------------------------------------");
		System.out.println(" -- D E L E T E     P R O D U C T --");
		System.out.println("--------------------------------------");
		System.out.print("Input Product ID: ");
		String id = input.readLine();
		int x = 0;
		try {
			x = addressDao.deleteAddress(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (x == 1)
			System.out.println("Address Deleted...");
		else
			System.out.println("Failed to Delete Address...");
	}
	
	static void listCategory() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("  -- C A T E G O R Y     L I S T --");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("ID Category" + "\t\t" + "Category" + "\t\t\t" + "Color" + "\t\t\t" + "Price" + "\t\t\t" + "Description");
		try {
			for (int x = 0; x < addressDao.getAddressesByCustomer(globalCustomer).size(); x++) {
				System.out.println(((Product) productDao.getAllProducts().get(x)).getId() + "\t\t\t"
						+ ((Product) productDao.getAllProducts().get(x)).getName() + "\t\t\t"
						+ ((Product) productDao.getAllProducts().get(x)).getColor() + "\t\t\t"
						+ "Rp. " + ((Product) productDao.getAllProducts().get(x)).getPrice() + "\t\t\t"
						+ ((Product) productDao.getAllProducts().get(x)).getDescription());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void inputNewCategory(BufferedReader input) throws IOException {
		System.out.println("---------------------------------------");
		System.out.println("--I N P U T   N E W   C A T E G O R Y--");
		System.out.println("---------------------------------------");
		
		Category category = new Category();
		
		System.out.print("Category Name: ");
		category.setName(input.readLine());
		System.out.print("Slug: ");
		category.setSlug(input.readLine());
		
		try {
			categoryDao.addCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Category Saved...");
	}
	
	static void deleteCategory(BufferedReader input) throws IOException {
		listCategory();
		System.out.println("--------------------------------------");
		System.out.println("DELETE CATEGORY");
		System.out.println("--------------------------------------");
		System.out.print("Input Category ID: ");
		String id = input.readLine();
		int x = 0;
		try {
			x = categoryDao.deleteCategory(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (x == 1)
			System.out.println("Category Deleted...");
		else
			System.out.println("Failed to Delete Category...");
	}
	
	static void listBrand() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("  -- B R A N D     L I S T --");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("ID Brand" + "\t\t" + "Brand Name");
		try {
			for (int x = 0; x < brandDao.getAllBrands().size(); x++) {
				System.out.println(((Brand) brandDao.getAllBrands().get(x)).getId() + "\t\t\t"
						+ ((Brand) brandDao.getAllBrands().get(x)).getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void inputNewBrand(BufferedReader input) throws IOException {
		System.out.println("---------------------------------------");
		System.out.println("--I N P U T   N E W   B R A N D--");
		System.out.println("---------------------------------------");
		
		Brand brand = new Brand();
		
		System.out.print("Brand Name: ");
		brand.setName(input.readLine());
		
		try {
			brandDao.addBrand(brand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Brand Saved...");
	}
	
	static void deleteBrand(BufferedReader input) throws IOException {
		listBrand();
		System.out.println("--------------------------------------");
		System.out.println("DELETE BRAND");
		System.out.println("--------------------------------------");
		System.out.print("Input Brand ID: ");
		String id = input.readLine();
		
		int x = 0;
		try {
			x = brandDao.deleteBrand(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (x == 1)
			System.out.println("Brand Deleted...");
		else
			System.out.println("Failed to Delete Brand...");
	}

	static void listCart() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("  -- C A R T    L I S T --");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Product ID" + "\t\t" + "Product Name" + "\t\t" + "Quantity");
		try {
			for (int x = 0; x < cartDao.getCartByCustomer(globalCustomer).size(); x++) {
				System.out.println(((Cart) cartDao.getCartByCustomer(globalCustomer).get(x)).getProduct().getId() + "\t\t\t"
						+ ((Cart) cartDao.getCartByCustomer(globalCustomer).get(x)).getProduct().getName() + "\t\t\t"
						+ ((Cart) cartDao.getCartByCustomer(globalCustomer).get(x)).getQuantity());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void addToCart(BufferedReader input) throws IOException {
		System.out.println("---------------------------------------");
		System.out.println("--ADD TO CART--");
		System.out.println("---------------------------------------");
		
		Cart cart = new Cart();
		
		System.out.print("Input Product ID: ");
		int productId = Integer.parseInt(input.readLine());
		System.out.print("Input Quantity: ");
		cart.setQuantity(Byte.parseByte(input.readLine()));
		
		Product product = null;
		try {
			product = productDao.getProductById(productId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cart.setCustomer(globalCustomer);
		cart.setProduct(product);

		/*
		 * 
		 * Try catch below is used for checking if the inserted cart is alredy 
		 *
		 * 
		 * 
		 */
//		Cart tempCart = null;
//		try {
//			tempCart = cartDao.getCartByCustomerProduct(globalCustomer, product);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		if (tempCart.getQuantity() > 1) {
//			
//		} else {
//
//		}
		
		try {
			cartDao.addCart(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Cart Saved...");
	}
	
	static void removeCart(BufferedReader input) throws IOException {
		listCart();
		System.out.println("--------------------------------------");
		System.out.println("DELETE CART");
		System.out.println("--------------------------------------");
		System.out.print("Input Product ID: ");
		String id = input.readLine();
		
		int x = 0;
		try {
			x = cartDao.removeCart(globalCustomer.getId(), Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (x == 1)
			System.out.println("Cart Deleted...");
		else
			System.out.println("Failed to Remove Cart...");
	}
	
	static void showWishlist() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("  -- W I S H L I S T --");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Product ID" + "\t\t" + "Product Name");
		try {
			for (int x = 0; x < wishlistDao.getWishlistByCustomer(globalCustomer).size(); x++) {
				System.out.println(((Wishlist) wishlistDao.getWishlistByCustomer(globalCustomer).get(x)).getProduct().getId() + "\t\t\t"
						+ ((Wishlist) wishlistDao.getWishlistByCustomer(globalCustomer).get(x)).getProduct().getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	static void addWishlist(BufferedReader input) throws IOException {
		listProducts();
		System.out.println("---------------------------------------");
		System.out.println("--ADD TO WISHLIST--");
		System.out.println("---------------------------------------");
		
		
		System.out.print("Input Product ID: ");
		int productId = Integer.parseInt(input.readLine());
		
		Product product = null;
		try {
			product = productDao.getProductById(productId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Wishlist tempWishlist = null;
		try {
			tempWishlist = wishlistDao.getWishlistByCustomerProduct(globalCustomer, product);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (tempWishlist != null && tempWishlist.getProduct().getId() == productId) {
			System.out.println("Product Already Exists...");
		} else {
			Wishlist wishlist = new Wishlist(globalCustomer, product);
			try {
				wishlistDao.addWishlist(wishlist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("New Cart Saved...");
		}
		
	}
	
	static void removeWishlist(BufferedReader input) throws IOException {
		showWishlist();
		System.out.println("--------------------------------------");
		System.out.println("DELETE PRODUCT FROM WISHLIST");
		System.out.println("--------------------------------------");
		System.out.print("Input Product ID: ");
		String id = input.readLine();
		
		int x = 0;
		try {
			x = wishlistDao.removeWishlist(globalCustomer.getId(), Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (x == 1)
			System.out.println("Product Removed From Wishlist...");
		else
			System.out.println("Failed to Remove Product...");
	}
	
	static void checkoutCart(BufferedReader input) throws IOException {
		Date date = new Date();
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		listCart();
		System.out.println("--------------------------------------");
		System.out.println("CHECKOUT ORDER");
		System.out.println("--------------------------------------");
		System.out.print("Are You Sure Want To Checkout? (yes/no): ");
		String choice = input.readLine();
		
		if (choice.equalsIgnoreCase("yes")) {
			double totalPayment = 0;
			
			List<Cart> listOfCart = null;
			try {
				listOfCart = cartDao.getCartByCustomer(globalCustomer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int x = 0; x < listOfCart.size(); x++) {
				totalPayment += ((Cart) listOfCart.get(x)).getProduct().getPrice() * ((Cart) listOfCart.get(x)).getQuantity();
			}
			
			if (globalCustomer.getBalance() < totalPayment) {
				System.out.println("Sorry you don't have sufficient balance!");
			} else {
				System.out.print("Choose your courier (jne/jnt): ");
				String courier = input.readLine();
				Order order = new Order();
				order.setCustomer(globalCustomer);
				order.setCourier(courier);
				order.setStatus((byte) 1);
				
				try {
					int lastId = orderDao.addOrder(order);
					order.setId(lastId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (int x = 0; x < listOfCart.size(); x++) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setOrder(order);
					orderDetail.setProduct(listOfCart.get(x).getProduct());
					orderDetail.setProductPrice(listOfCart.get(x).getProduct().getPrice());
					orderDetail.setQuantity(listOfCart.get(x).getQuantity());
					try {
						orderDetailDao.addOrderDetail(orderDetail);						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Order Saved...");
			}
			
		} else {
			System.out.println("Okay...");
		}
	}
}
