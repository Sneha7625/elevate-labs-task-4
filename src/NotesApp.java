import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class NotesApp 
{
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) 
        {
            System.out.println("\n===  Notes Manager ===");
            System.out.println("1. Write Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete Note");
            System.out.println("4. Clear All Notes");
            System.out.println("5. Search Notes");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) 
            {
                case 1 -> writeNote(scanner);
                case 2 -> readNotes();
                case 3 -> deleteNote(scanner);
                case 4 -> clearNotes(scanner);
                case 5 -> searchNotes(scanner);
                case 6 -> {
                    System.out.println(" Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void writeNote(Scanner scanner) 
    {
        System.out.print(" Enter your note: ");
        String note = scanner.nextLine();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) 
        {
            fw.write("[" + timestamp + "] " + note + System.lineSeparator());
            System.out.println(" Note saved.");
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing note.");
        }
    }

    private static void readNotes() 
    {
        System.out.println("\n --- Your Notes ---");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) 
        {
            String line;
            int index = 1;
            boolean hasNotes = false;
            while ((line = br.readLine()) != null) 
            {
                hasNotes = true;
                System.out.println(index++ + ". " + line);
            }
            if (!hasNotes)
                 System.out.println(" No notes found.");
        } 
        catch (IOException e) 
        {
            System.out.println(" Error reading notes.");
        }
    }

    private static void deleteNote(Scanner scanner) 
    {
        List<String> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) 
        {
            String line;
            while ((line = br.readLine()) != null) notes.add(line);
        } 
        catch (IOException e) 
        {
            System.out.println(" Error reading notes.");
            return;
        }

        if (notes.isEmpty()) 
        {
            System.out.println(" No notes to delete.");
            return;
        }

        for (int i = 0; i < notes.size(); i++) 
        {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.print(" Enter note number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (index < 1 || index > notes.size()) 
        {
            System.out.println("Invalid index.");
            return;
        }

        notes.remove(index - 1);

        try (FileWriter fw = new FileWriter(FILE_NAME)) 
        {
            for (String note : notes) fw.write(note + System.lineSeparator());
            System.out.println(" Note deleted.");
        } 
        catch (IOException e) 
        {
            System.out.println(" Error updating file.");
        }
    }

    private static void clearNotes(Scanner scanner)
     {
        System.out.print(" Are you sure you want to clear all notes? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) 
        {
            System.out.println("Clear canceled.");
            return;
        }

        try (FileWriter fw = new FileWriter(FILE_NAME)) 
        {
            // empty file
            System.out.println("All notes cleared.");
        } 
        catch (IOException e) 
        {
            System.out.println(" Error clearing notes.");
        }
    }

    private static void searchNotes(Scanner scanner) 
    {
        System.out.print(" Enter keyword to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) 
        {
            String line;
            boolean found = false;
            int index = 1;
            while ((line = br.readLine()) != null) 
            {
                if (line.toLowerCase().contains(keyword)) 
                {
                    System.out.println(index + ". " + line);
                    found = true;
                }
                index++;
            }
            if (!found) System.out.println("No matching notes found.");
        } 
        catch (IOException e) 
        {
            System.out.println(" Error reading notes.");
        }
    }
}
