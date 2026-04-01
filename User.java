public class User {
    protected String userId;
    protected String name;
   protected short  maxBorrowLimit=1;
   private Library_Item borrowedItem;
  public  User(String userId,String name){
      this.userId=userId;
      this.name=name;
      this.borrowedItem=null;
  }
  protected void borrow(Library_Item item){
      if(borrowedItem!=null){
          System.out.println(name + "has already borrowed it." );
      } else if (item.isAvailable) {
          borrowedItem=item;
          item.borrowItem();
      }

  }
  protected void returnItem(){
      if(borrowedItem==null){
          System.out.println(name+" has not borrowed any book.");
      }
      else {
          borrowedItem.returnItem();
          borrowedItem=null;
      }

  }
  protected void showBorrowedItems(){
      if(borrowedItem==null){
          System.out.println(name+" has not borrowed any book.");
      }
      else{
          System.out.println(name+"has borrowed: ");
          borrowedItem.displayDetails();
      }

  }
}
