# Project: SimpleJavaApp

## Description
A small Java console application demonstrating:
- Object-Oriented Programming
- Collections (ArrayList, HashMap)
- Exception handling
- Input/Output
- Reusable methods
- Basic console menu system

---

## Project Structure

SimpleJavaApp/
├─ README.md  
├─ .gitignore  
└─ src/  
   └─ com/example/simpleapp/  
      ├─ Main.java  
      ├─ model/User.java  
      └─ service/UserService.java  

---

## How to Run

```bash
javac -d out src/com/example/simpleapp/*.java src/com/example/simpleapp/model/*.java src/com/example/simpleapp/service/*.java
java -cp out com.example.simpleapp.Main
