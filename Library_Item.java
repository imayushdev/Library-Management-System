public class Library_Item {
  protected String  itemId;
  protected String Tittle;
  protected Boolean isAvailable;
  public Library_Item(String itemId,String Tittle){
      this.itemId=itemId;
      this.Tittle=Tittle;
      this.isAvailable=true;
  }

    public String getItemId() {
        return itemId;
    }

    public void  borrowItem() {
      if(isAvailable==true){
      System.out.println("The Book " + Tittle+"  is available!!");
      isAvailable=false;
          System.out.println("The Book " + Tittle+"  is Issued.");

  }
  else{
      System.out.println("The Book " + Tittle+" is not available");
  }

   }
   public void returnItem(){
      if(isAvailable==false){
          isAvailable=true;
          System.out.println("Item returned successfully!!");
   }

       System.out.println("The Book " + Tittle+" returned successfully!!");
   }
   Author obj ;
   public void displayDetails(){
       System.out.println("Book id is : "+itemId);
       System.out.println("Tittle of the book is : "+Tittle);
       //System.out.println("Author is : "+obj.getName());
       if(isAvailable==true){
           System.out.println("Book is available!!");
       }
       else{
           System.out.println("Book is not available");
       }

   }

}
