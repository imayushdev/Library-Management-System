public class Library implements itemOperations {

    int itemCount=0;
    private Library_Item [] items = new Library_Item[10];
    public void addItem(Library_Item item) {
        if (itemCount < items.length) {
            items[itemCount++] = item;
            System.out.println("Item has been added"+item);
        } else {
            System.out.println("Library is full .Can't add more items.");
        }
    }
        public void removeItem(String itemId) {
            for (int i = 0; i < itemCount; i++) {
                if (items[i].getItemId().equals(itemId)) {
                    items[i] = items[--itemCount];
                    items[itemCount] = null;
                    System.out.println("Item with id" + itemId + "has been removed");
                } else {
                    System.out.println("Item not found.");
                }

            }


    }
    public void displayItems() {
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].toString());

        }
    }
    /* private Book[] books = new Book[10];
    int bookCount = 0;
public void addItem()
    @Override
    public void addBooks(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Book has been added.");
        } else {
            System.out.println("Library is full");
        }

    }

    @Override
    public void removeBook(String itemId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getItemId().equals(itemId)) {
                books[i] = books[--bookCount];
                books[bookCount] = null;
                System.out.println("Book with id" + itemId + "has been removed");
            } else {
                System.out.println("Book not found.");
            }

        }

    }

    @Override
    public void displayBooks() {
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].toString());

        }
    }
    private Magazine [] magazines = new Magazine[10];
    int MagazineCount=0;

    public void addMagazine(Magazine magazine) {
        if (MagazineCount < magazines.length) {
            magazines[MagazineCount++] = magazine;
            System.out.println("Magazine has been added.");
        } else {
            System.out.println("Library is full");
        }

    }
    public void removeMagazine(String itemId) {
        for (int i = 0; i < MagazineCount; i++) {
            if (magazines[i].getItemId().equals(itemId)) {
                magazines[i] = magazines[--MagazineCount];
                magazines[MagazineCount] = null;
                System.out.println("Magazine with id" + itemId + "has been removed");
            } else {
                System.out.println("Magazine  not found.");
            }

        }

    }
    public void displayMagazine() {
        for (int i = 0; i < MagazineCount; i++) {
            System.out.println(magazines[i].toString());

        }
    }

    */
}