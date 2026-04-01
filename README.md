# Library-Management-System
# 📚 Library Management System

A Java-based console application for managing library resources — including books, magazines, and users (students and professors). Built using core Object-Oriented Programming principles: **Inheritance**, **Polymorphism**, **Abstraction**, and **Interfaces**.

---

## 🗂️ Table of Contents

- [Features](#-features)
- [Project Structure](#-project-structure)
- [Class Overview](#-class-overview)
- [How to Run](#-how-to-run)
- [Usage Guide](#-usage-guide)
- [OOP Concepts Used](#-oop-concepts-used)
- [Known Limitations](#-known-limitations)

---

## ✅ Features

- 📖 Add and remove **Books** and **Magazines**
- 👤 Register and manage **Students** and **Professors**
- 🔄 **Borrow and return** library items
- 🔍 View **all items** or **user details** by ID
- 🧱 Clean, menu-driven **console interface**
- 🌱 Pre-loaded **demo data** on startup

---

## 📁 Project Structure

```
LibraryManagementSystem/
│
├── mainLibraryManagement.java   # Entry point — main menu & program flow
│
├── Models/
│   ├── Library_Item.java        # Base class for all library items
│   ├── Book.java                # Extends Library_Item
│   ├── Magazine.java            # Extends Library_Item
│   └── Author.java              # Represents a book's author
│
├── Users/
│   ├── User.java                # Base class for all users
│   ├── Student.java             # Extends User (books only)
│   └── Professor.java           # Extends User (books & magazines)
│
├── Library/
│   └── Library.java             # Manages the collection of items
│
├── Managers/
│   └── userManager.java         # Handles all user registration & lookup
│
└── Interfaces/
    ├── itemOperations.java      # Interface for item operations
    ├── UserOperations.java      # Interface for user operations
    ├── BooksOperation.java      # Interface for book operations (reserved)
    └── MagazineOperations.java  # Interface for magazine operations (reserved)
```

---

## 🧩 Class Overview

### `Library_Item` *(Base Class)*
The parent class for all items in the library.

| Field | Type | Description |
|-------|------|-------------|
| `itemId` | `String` | Unique identifier |
| `Tittle` | `String` | Title of the item |
| `isAvailable` | `Boolean` | Whether the item can be borrowed |

**Key Methods:**
- `borrowItem()` — Marks item as borrowed
- `returnItem()` — Marks item as returned
- `displayDetails()` — Prints item info

---

### `Book` *(extends Library_Item)*
Represents a book with an associated `Author`.

### `Magazine` *(extends Library_Item)*
Represents a magazine with an `issueNumber`.

### `Author`
Stores author details: name, biography, and total books published.

---

### `User` *(Base Class)*
The parent class for library users. Each user can borrow **one item at a time**.

| Field | Type | Description |
|-------|------|-------------|
| `userId` | `String` | Unique user ID |
| `name` | `String` | User's name |
| `maxBorrowLimit` | `short` | Max items allowed (default: 1) |

**Key Methods:**
- `borrow(Library_Item)` — Borrows an item
- `returnItem()` — Returns the currently borrowed item
- `showBorrowedItems()` — Displays what the user has borrowed

---

### `Student` *(extends User)*
- Can only borrow **Books** (not magazines)

### `Professor` *(extends User)*
- Can borrow both **Books and Magazines**

---

### `Library` *(implements itemOperations)*
Maintains an array of up to **10 library items**.

| Method | Description |
|--------|-------------|
| `addItem(item)` | Adds a new item |
| `removeItem(itemId)` | Removes item by ID |
| `displayItems()` | Lists all items |

---

### `userManager` *(implements UserOperations)*
Manages up to **20 users**.

| Method | Description |
|--------|-------------|
| `registerStudent(id, name)` | Registers a new student |
| `registerProfessor(id, name)` | Registers a new professor |
| `removeUser(id)` | Removes a user by ID |
| `displayAllUsers()` | Lists all users |
| `displayUserById(id)` | Shows details for one user |
| `findUser(id)` | Returns a User object by ID |

---

## ▶️ How to Run

### Prerequisites
- **Java JDK 11 or higher** installed
- A terminal or IDE (IntelliJ, Eclipse, VS Code)

### Steps

**1. Clone or download all `.java` files into one folder.**

**2. Compile all files:**
```bash
javac *.java
```

**3. Run the main class:**
```bash
java mainLibraryManagement
```

> 💡 The system loads 2 demo books and 1 demo magazine automatically on startup.

---

## 🖥️ Usage Guide

Once running, you'll see the main menu:

```
╔══════════════════════════════════════╗
║    LIBRARY MANAGEMENT SYSTEM         ║
╠══════════════════════════════════════╣
║  1. User Management                  ║
║  2. Book Management                  ║
║  3. Magazine Management              ║
║  4. Borrow / Return                  ║
║  0. Exit                             ║
╚══════════════════════════════════════╝
```

### 👤 User Management (Option 1)
- Register a new Student or Professor with an ID and name
- Remove a user by their ID
- View all registered users or look up one by ID

### 📖 Book Management (Option 2)
- Add a new book by entering ID, title, and author details
- Remove a book by its ID
- View all items in the library

### 📰 Magazine Management (Option 3)
- Add a new magazine with an ID, title, and issue number
- Remove a magazine by ID
- View all items

### 🔄 Borrow / Return (Option 4)
1. Enter your **User ID**
2. A list of available items is shown
3. Pick an item number to borrow
4. To return, enter your User ID and your item is returned automatically

> ⚠️ Students can only borrow **Books**. Professors can borrow both Books and Magazines.

---

## 🧠 OOP Concepts Used

| Concept | Where Applied |
|---------|--------------|
| **Inheritance** | `Book`, `Magazine` extend `Library_Item`; `Student`, `Professor` extend `User` |
| **Polymorphism** | `displayDetails()` overridden in `Book` and `Magazine`; `borrow()` overridden in `Student` |
| **Abstraction** | `Library_Item` and `User` act as abstract base classes |
| **Interfaces** | `itemOperations`, `UserOperations` define contracts for `Library` and `userManager` |
| **Encapsulation** | Private fields with controlled access via methods across all classes |

---

## ⚠️ Known Limitations

- The library can hold a **maximum of 10 items** and 20 users (fixed array size)
- Each user can only borrow **one item at a time**
- Data is **not persisted** — everything resets when the program exits
- The `BooksOperation` and `MagazineOperations` interfaces are defined but not yet fully implemented
- The `removeItem()` method in `Library.java` has a minor bug where "Item not found" prints for every non-matching entry during a loop (not just when the item is truly absent)

---

## 🚀 Future Improvements

- [ ] Add file or database persistence (save/load data)
- [ ] Increase borrow limit per user type
- [ ] Add search functionality by title or author
- [ ] Implement due dates and late fee tracking
- [ ] Build a GUI using Java Swing or JavaFX

---

## 👨‍💻 Author: Ayush Sharma

Built as a Java OOP learning project demonstrating real-world class design, interface-driven development, and clean menu-based console interaction.
