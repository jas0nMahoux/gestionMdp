import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PasswordGenerator {

    private static final String ALPHABET = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz/*";

    public static void generateAndSave() {
        Random random = new Random();
        int mdpLenght = random.nextInt(10, 13);

        String mdp = "";

        while (mdp.length() != mdpLenght) {
            int position = random.nextInt(ALPHABET.length());
            mdp += ALPHABET.charAt(position);
        }

        save(mdp);
    }

    public static void save(String mdp) {
        try {
            FileWriter fw = new FileWriter("src/mdpStorage.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(mdp);
            pw.flush();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
