import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> phoneBook = new HashMap<>();

        while (true) {
            System.out.println("Enter a name (or 'quit' to exit):");
            String name = scanner.nextLine();
            if (name.equals("quit")) {
                scanner.close();
                break;
            }
            System.out.println("Enter a phone number:");
            String phoneNumber = scanner.nextLine();
            
            if (phoneBook.containsKey(name)) {
                Set<String> phoneNumbers = phoneBook.get(name);
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            } else {
                Set<String> phoneNumbers = new HashSet<>();
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            }
        }

        List<Map.Entry<String, Set<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        System.out.println("Phone Book:");
        for (Map.Entry<String, Set<String>> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + " phone(s)");
            for (String phoneNumber : entry.getValue()) {
                System.out.println("  " + phoneNumber);
            }
        }
    }
}