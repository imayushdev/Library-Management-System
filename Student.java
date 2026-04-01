public class Student extends User{


    Student(String userId,String name,short maxBorrowLimit){
        super(userId,name);
    }
    public void borrow(Library_Item item){
        if(item instanceof Book){
            super.borrow(item);
        }
        else{
            System.out.println("Student only can access to books only");
        }

    }
}
