#  Enhanced Java File I/O – Notes App

## Task Overview

**Task 4:** Create a text-based notes manager with file read/write operations and advanced features using Java File I/O.

---

## Objective

To build a command-line Notes App that allows users to:
- Save notes to a file
- View saved notes
- Delete individual notes
- Clear all notes with confirmation
- Search for notes by keyword

---

## 🛠 Tools Used

- Java 17 (JDK)
- VS Code or IntelliJ
- Terminal or Command Prompt

---

##  Folder Structure
EnhancedNotesApp/
├── src/
│ └── NotesApp.java
└── README.md

---

##  What I Did

1. Built `NotesApp.java` using FileWriter and FileReader/BufferedReader.
2. Enhanced the app with:
   -  Timestamped notes
   -  Deletion of individual notes by number
   -  File clearing with user confirmation
   -  Search by keyword
   -  Improved CLI user experience
3. Applied exception handling with `try-catch` and `try-with-resources`.
4. Persisted all notes in a local file `notes.txt`.

---

##  Features

| Feature             | Description                                                 |
|---------------------|-------------------------------------------------------------|
|  Write Note        | Saves user input as a timestamped note in `notes.txt`.      |
|  View Notes        | Lists all saved notes with numbering.                       |
|  Delete Note       | Removes a specific note by entering its number.             |
|  Clear All Notes   | Deletes the entire file content after user confirmation.    |
|  Search Notes      | Finds and displays notes that contain a given keyword.      |
|  Enhanced UI       | CLI outputs are cleaner and easier to read.                 |

---

## Sample Menu Output

=== 📚 Notes Manager ===

1.Write Note
2.View Notes
3.Delete Note
4.Clear All Notes
5.Search Notes
6.Exit
Choose an option:


---

## Concepts Practiced

- File I/O (`FileWriter`, `FileReader`, `BufferedReader`)
- Data persistence in flat files
- Looping and switch-based CLI
- Exception handling (FileNotFound, IO)
- Java date/time formatting
- List manipulation with ArrayList

---

## Outcome

- Gained confidence working with file systems in Java.
- Understood how to persist, modify, and search data on disk.
- Applied best practices in CLI and modular method design.
- Reinforced use of `ArrayList`, `Scanner`, `try-catch`, and logic flow.

---
##  Deliverable

- Java source: `NotesApp.java`
- Output file: `notes.txt`
- A clean, fully functional notes CLI app

---