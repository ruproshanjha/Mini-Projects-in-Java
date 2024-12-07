import java.util.Scanner;

class Contact {
    int id;
    String name;
    String phoneNumber;

    Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

public class PhoneBook {
    private static final int MAX_CONTACTS = 10;
    private Contact[] contacts = new Contact[MAX_CONTACTS];
    private int contactCount = 0;

    // Add a new contact (ID automatically allocated)
    public void addContact(String name, String phoneNumber) {
        if (contactCount < MAX_CONTACTS) {
            contacts[contactCount] = new Contact(contactCount + 1, name, phoneNumber);
            contactCount++;
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Phone book is full. Cannot add more contacts.");
        }
    }

    // Find a contact by name
    public void find(String name) {
        boolean found = false;
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                System.out.println("Contact Found: ID=" + contacts[i].id + ", Name=" + contacts[i].name + ", Phone=" + contacts[i].phoneNumber);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Display all contacts
    public void display() {
        if (contactCount == 0) {
            System.out.println("No contacts to display.");
            return;
        }
        System.out.println("Phone Book:");
        for (int i = 0; i < contactCount; i++) {
            System.out.println("ID: " + contacts[i].id + ", Name: " + contacts[i].name + ", Phone: " + contacts[i].phoneNumber);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        // Adding 10 contacts
        System.out.println("Enter details for 10 contacts:");
        for (int i = 0; i < MAX_CONTACTS; i++) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();
            phoneBook.addContact(name, phone);
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display all contacts");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    phoneBook.display();
                    break;
                case 2:
                    System.out.print("Enter the name to find: ");
                    String nameToFind = scanner.nextLine();
                    phoneBook.find(nameToFind);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
