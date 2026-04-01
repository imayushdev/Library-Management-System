public class Author {
    public Author(String name ,String Biography,int totalBooks){
        this.name=name;
        this.Biography=Biography;
        this.totalBooks=totalBooks;
    }

   private String name ;
  private   String Biography;
   private int totalBooks;
   public void showDetails(){
       System.out.println("Author name is "+name);
       System.out.println(name + Biography);
       System.out.println("Total Books Published = "+totalBooks);

   }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
       Author obj = new Author("Ayush sharma","Very good boy",3);
       obj.showDetails();
    }
}
