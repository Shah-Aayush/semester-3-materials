class Book {
//		Scanner sc = new Scanner(System.in);
		String Book_title;
		float Book_price;
		
		void setTitle(String bookTitle){
			Book_title = bookTitle;
		}
		void setPrice(Float bookPrice){
			Book_price = bookPrice;
		}
		String getTitle(){
			return Book_title;
		}
		Float getPrice(){
			return Book_price;
		}
}