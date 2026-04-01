
    public class userManager implements UserOperations {

        private User[] users = new User[20];
        private int userCount = 0;

        @Override
        public void registerStudent(String userId, String name) {
            if (userCount >= users.length) {
                System.out.println("User list is full.");
                return;
            }
            if (findUser(userId) != null) {
                System.out.println("User ID '" + userId + "' already exists.");
                return;
            }
            users[userCount++] = new Student(userId, name, (short) 1);
            System.out.println("Student '" + name + "' registered successfully!");
        }

        @Override
        public void registerProfessor(String userId, String name) {
            if (userCount >= users.length) {
                System.out.println("User list is full.");
                return;
            }
            if (findUser(userId) != null) {
                System.out.println("User ID '" + userId + "' already exists.");
                return;
            }
            users[userCount++] = new Professor(userId, name);
            System.out.println("Professor '" + name + "' registered successfully!");
        }

        @Override
        public void removeUser(String userId) {
            for (int i = 0; i < userCount; i++) {
                if (users[i].userId.equals(userId)) {
                    System.out.println("User '" + users[i].name + "' removed successfully.");
                    users[i] = users[--userCount];
                    users[userCount] = null;
                    return;
                }
            }
            System.out.println("User with ID '" + userId + "' not found.");
        }

        @Override
        public void displayAllUsers() {
            if (userCount == 0) {
                System.out.println("No users registered yet.");
                return;
            }
            System.out.println("\n── Registered Users ──────────────────────────");
            for (int i = 0; i < userCount; i++) {
                String type = (users[i] instanceof Student) ? "Student" : "Professor";
                System.out.printf("  %d. ID: %-8s | Name: %-20s | Type: %s%n",
                        i + 1, users[i].userId, users[i].name, type);
            }
            System.out.println("──────────────────────────────────────────────");
        }

        @Override
        public void displayUserById(String userId) {
            User u = findUser(userId);
            if (u == null) {
                System.out.println("User with ID '" + userId + "' not found.");
                return;
            }
            System.out.println("\n── User Details ──────────────────────");
            System.out.println("  ID   : " + u.userId);
            System.out.println("  Name : " + u.name);
            System.out.println("  Type : " + (u instanceof Student ? "Student" : "Professor"));
            u.showBorrowedItems();
            System.out.println("──────────────────────────────────────");
        }

        @Override
        public User findUser(String userId) {
            for (int i = 0; i < userCount; i++) {
                if (users[i].userId.equals(userId)) return users[i];
            }
            return null;
        }

        public int getUserCount() {
            return userCount;
        }
    }

