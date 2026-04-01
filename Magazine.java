public class Magazine extends Library_Item {
    private int issueNumber;
    public Magazine(String itemId,String Tittle ,int issueNumber) {
        super(itemId, Tittle);
        this.issueNumber = issueNumber;
    }

        public void displayDetails() {
        System.out.println("Magazine id is : " + itemId);
        System.out.println("Tittle of the magazine is : " + Tittle);
        System.out.println("The issueNumber is  "+ issueNumber);

    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber=" + issueNumber +
                ", itemId='" + itemId + '\'' +
                ", Tittle='" + Tittle + '\'' +
                '}';
    }
}
