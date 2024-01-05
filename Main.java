import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, String> urlMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to shorten a URL, 2 to expand a URL, or 3 to quit:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (choice == 1) {
                System.out.println("Enter a long URL:");
                String longURL = scanner.nextLine();
                System.out.println("Short URL: " + shortenURL(longURL));
            } 
            else if (choice == 2) {
                System.out.println("Enter a short URL:");
                String shortURL = scanner.nextLine();
                try {
                    System.out.println("Long URL: " + expandURL(shortURL));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }

    public static String shortenURL(String longURL) {
        if (urlMap.containsValue(longURL)) {
            for (String key : urlMap.keySet()) {
                if (urlMap.get(key).equals(longURL)) {
                    return key;
                }
            }
        }

        String shortURL = generateShortURL(longURL);
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public static String expandURL(String shortURL) {
        if (!urlMap.containsKey(shortURL)) {
            throw new IllegalArgumentException("Invalid short URL");
        }
        return urlMap.get(shortURL);
    }

    private static String generateShortURL(String longURL) {
        return String.valueOf(longURL.hashCode());
    }
}
