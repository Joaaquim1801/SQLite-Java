# 📁SQLite Java

![SQLite](https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)


> This project aims to create a small Java system with commands from Java's SQLite library, JDBC.
  The system includes features such as: Add data, Delete, List all, and Search by ID. I specifically created a
  Person class with ID and Name attributes.

## ✨ Tecnologies

- **Java 17** - Main Language
- **SQLite** - Data Base ( Development )

## 🚀 Features

  - ⚙ Insert a new register
  - ❌Delete an exist register
  - ✏ List all the registers (Example: [ ID: 1 Name: )
  - 🔎 Search a register from his ID

## 🎯 Project Estructure
```
SQLite - Java/
├── .idea/                   
├── src/
│   └── test/
│       └── java/
│           ├── dataBase.java       # Class responsable for the conection with the data base
│           ├── fileUtils.java      # Utilities for file manipulation
│           ├── person.java         # Model (entity) which represents a person
│           ├── personDAO.java      # DAO class for acess and operation on the data base
│           └── testeDB.java        # Test class the connection and operations in the database class
├── instructions.sql          # SQL script with instructions
├── .gitignore
├── pom.xml                   
```

## ▶️ How to Run

  1. **Clone** the repository:
   ```bash
   git clone (https://github.com/Joaaquim1801/SQLite-Java)
   cd SQLite-Java
  ```

  2. **Compile** the source files:
  ```bash
  javac -d bin src/*.java
  ```

  3. **Execute** the program:
  ```bash
  java -cp bin TestDB
  ```

##  🧪 Sample Interaction

```
Choose from the options
1. Insert a new person
2. Delete an existing person
3. Search for a person by ID
4. List all people
5. EXIT the system
	 OPTION:
1
Enter the person's ID: 
1
Enter the person's name: 
Joe
Choose from the options
1. Insert a new person
2. Delete an existing person
3. Search for a person by ID
4. List all people
5. EXIT the system
	 OPTION:
4
This is the list of all registrations:
	ID: 1	Name: Joe
Choose from the options
1. Insert a new person
2. Delete an existing person
3. Search for a person by ID
4. List all people
5. EXIT the system
	 OPTION:
5
```

# 📞 Contact
* Joaquim Maia - joaquimaiafilho2018@gmail.com
* Project Link: https://github.com/Joaaquim1801/SQLite-Java

⭐ If this project helps you, consider give project a star!
