
    public interface UserOperations {
        void registerStudent(String userId, String name);
        void registerProfessor(String userId, String name);
        void removeUser(String userId);
        void displayAllUsers();
        void displayUserById(String userId);
        User findUser(String userId);
    }

