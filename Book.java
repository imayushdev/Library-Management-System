public class Book extends Library_Item {
    Author author;


     public Book(String itemId,String Tittle,Author author){
         super(itemId, Tittle);
         this.author=author;

     }
     Author obj ;//= new Author("Ayush","Born in Himachal Pradesh",1);


    @Override
     public void displayDetails() {
        System.out.println("Book id is : " + itemId);
        System.out.println("Tittle of the book is : " + Tittle);
        System.out.println("The author name is : " + author);
    }

    @Override
    public String toString() {
        return itemId +","+Tittle+","+author;
    }
}
