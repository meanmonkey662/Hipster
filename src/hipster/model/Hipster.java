package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
	public Book[] getHipsterBooks() {
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks) 
	{
		this.hipsterBooks = hipsterBooks;
	}

	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I could tell you but, you probably wouldnt get it..";
		hipsterPhrases[2] = "I could tell..";
		hipsterPhrases[3] = "Your so mainstream!";
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		
		firstBook = new Book();
		firstBook.setAuthor("Joe Nordson");
		firstBook.setSubject("Computers in the future");
		firstBook.setPageCount(1456);
		firstBook.setPrice(43);
		
		secondBook = new Book();
		secondBook.setAuthor("Hip Hipstonian");
		secondBook.setSubject("How to be hip.");
		secondBook.setPageCount(23356);
		secondBook.setPrice(12);
		
		thirdBook = new Book(855, "Philip Moorley", "Computers in the future", "Computers are cool", 124.99);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}
}
