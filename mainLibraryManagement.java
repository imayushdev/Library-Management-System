/*

 */

import java.util.Scanner;

public class mainLibraryManagement {

    static userManager userManager = new userManager();

    static Library_Item[] items     = new Library_Item[20];
    static int            itemCount = 0;

    static Library library = new Library();
    static Scanner sc      = new Scanner(System.in);

    public static void main(String[] args) {

        // Demo seed data
        Author a1 = new Author("J.K. Rowling", "Born in England", 7);
        Author a2 = new Author("George Orwell", "Born in India", 2);
        addItemToLibrary(new Book("B001", "Harry Potter", a1));
        addItemToLibrary(new Book("B002", "1984", a2));
        addItemToLibrary(new Magazine("M001", "National Geographic", 101));

        int choice;
        do {
            printMainMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> userMenu();
                case 2 -> bookMenu();
                case 3 -> magazineMenu();
                case 4 -> borrowReturnMenu();
                case 0 -> System.out.println("\nExiting Library Management System. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    // ── MENUS ────────────────────────────────────────────────────

    static void printMainMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║    LIBRARY MANAGEMENT SYSTEM         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. User Management                  ║");
        System.out.println("║  2. Book Management                  ║");
        System.out.println("║  3. Magazine Management              ║");
        System.out.println("║  4. Borrow / Return                  ║");
        System.out.println("║  0. Exit                             ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    static void userMenu() {
        int ch;
        do {
            System.out.println("\n--- USER MANAGEMENT ---");
            System.out.println("  1. Register Student");
            System.out.println("  2. Register Professor");
            System.out.println("  3. Remove User");
            System.out.println("  4. Display All Users");
            System.out.println("  5. Display User Details by ID");
            System.out.println("  0. Back to Main Menu");
            ch = readInt("Enter choice: ");
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter Student ID   : "); String id   = sc.nextLine().trim();
                    System.out.print("Enter Student Name : "); String name = sc.nextLine().trim();
                    userManager.registerStudent(id, name);
                }
                case 2 -> {
                    System.out.print("Enter Professor ID   : "); String id   = sc.nextLine().trim();
                    System.out.print("Enter Professor Name : "); String name = sc.nextLine().trim();
                    userManager.registerProfessor(id, name);
                }
                case 3 -> {
                    System.out.print("Enter User ID to remove: "); String id = sc.nextLine().trim();
                    userManager.removeUser(id);
                }
                case 4 -> userManager.displayAllUsers();
                case 5 -> {
                    System.out.print("Enter User ID: "); String id = sc.nextLine().trim();
                    userManager.displayUserById(id);
                }
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (ch != 0);
    }

    static void bookMenu() {
        int ch;
        do {
            System.out.println("\n--- BOOK MANAGEMENT ---");
            System.out.println("  1. Add Book");
            System.out.println("  2. Remove Book by ID");
            System.out.println("  3. Display All Items");
            System.out.println("  0. Back to Main Menu");
            ch = readInt("Enter choice: ");
            switch (ch) {
                case 1 -> addBook();
                case 2 -> removeLibraryItem();
                case 3 -> library.displayItems();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (ch != 0);
    }

    static void magazineMenu() {
        int ch;
        do {
            System.out.println("\n--- MAGAZINE MANAGEMENT ---");
            System.out.println("  1. Add Magazine");
            System.out.println("  2. Remove Magazine by ID");
            System.out.println("  3. Display All Items");
            System.out.println("  0. Back to Main Menu");
            ch = readInt("Enter choice: ");
            switch (ch) {
                case 1 -> addMagazine();
                case 2 -> removeLibraryItem();
                case 3 -> library.displayItems();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (ch != 0);
    }

    static void borrowReturnMenu() {
        int ch;
        do {
            System.out.println("\n--- BORROW / RETURN ---");
            System.out.println("  1. Borrow an Item");
            System.out.println("  2. Return an Item");
            System.out.println("  3. Show My Borrowed Item");
            System.out.println("  0. Back to Main Menu");
            ch = readInt("Enter choice: ");
            switch (ch) {
                case 1 -> borrowItem();
                case 2 -> returnItem();
                case 3 -> showBorrowed();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (ch != 0);
    }

    // ── BOOK / MAGAZINE OPERATIONS ───────────────────────────────

    static void addBook() {
        System.out.print("Enter Book ID     : "); String id    = sc.nextLine().trim();
        System.out.print("Enter Book Title  : "); String title = sc.nextLine().trim();
        System.out.print("Enter Author Name : "); String aName = sc.nextLine().trim();
        System.out.print("Enter Author Bio  : "); String aBio  = sc.nextLine().trim();
        int total = readInt("Total books by author: ");
        Author author = new Author(aName, aBio, total);
        addItemToLibrary(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void addMagazine() {
        System.out.print("Enter Magazine ID    : "); String id    = sc.nextLine().trim();
        System.out.print("Enter Magazine Title : "); String title = sc.nextLine().trim();
        int issue = readInt("Enter Issue Number   : ");
        addItemToLibrary(new Magazine(id, title, issue));
        System.out.println("Magazine added successfully!");
    }

    static void removeLibraryItem() {
        System.out.print("Enter Item ID to remove: ");
        String id = sc.nextLine().trim();
        library.removeItem(id);
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getItemId().equals(id)) {
                items[i] = items[--itemCount];
                items[itemCount] = null;
                break;
            }
        }
    }

    // ── BORROW / RETURN OPERATIONS ───────────────────────────────

    static void borrowItem() {
        System.out.print("Enter your User ID: "); String uid = sc.nextLine().trim();
        User u = userManager.findUser(uid);
        if (u == null) { System.out.println("User not found."); return; }

        System.out.println("\n── Available Items ───────────────────────────");
        int[] availableIndexes = new int[itemCount];
        int availCount = 0;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].isAvailable) {
                availableIndexes[availCount++] = i;
                String type = (items[i] instanceof Book) ? "Book" : "Magazine";
                System.out.printf("  %d. [%s] ID: %-6s | Title: %s%n",
                        availCount, type, items[i].getItemId(), items[i].Tittle);
            }
        }
        System.out.println("──────────────────────────────────────────────");

        if (availCount == 0) { System.out.println("No items currently available."); return; }

        int pick = readInt("Enter item number to borrow (0 to cancel): ");
        if (pick == 0) return;
        if (pick < 1 || pick > availCount) { System.out.println("Invalid selection."); return; }

        u.borrow(items[availableIndexes[pick - 1]]);
    }

    static void returnItem() {
        System.out.print("Enter your User ID: "); String uid = sc.nextLine().trim();
        User u = userManager.findUser(uid);
        if (u == null) { System.out.println("User not found."); return; }
        u.returnItem();
    }

    static void showBorrowed() {
        System.out.print("Enter your User ID: "); String uid = sc.nextLine().trim();
        User u = userManager.findUser(uid);
        if (u == null) { System.out.println("User not found."); return; }
        u.showBorrowedItems();
    }

    // ── HELPERS ──────────────────────────────────────────────────

    static void addItemToLibrary(Library_Item item) {
        library.addItem(item);
        if (itemCount < items.length) items[itemCount++] = item;
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.next();
            System.out.print(prompt);
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }
}