import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class Reverser {

    private Writer writer;

    public Reverser(Writer writer) {
        this.writer = writer;
    }

    public void reverse(Reader reader)
    throws IOException {
        
        // Insert code between here ...
        List<String> tmp = new ArrayList<String>();
            do {
                ch = br.readLine();
                out.print(ch+"<br/>"); 
            } while (ch != null);
            fr.close();
        // ... and here!
        // ATTENTION: Do not use any standard library classes in your solution!
    }

    public static void main(String[] args) {
        try {
            try (StringWriter writer = new StringWriter()) {
                Reverser reverser = new Reverser(writer);
                try (Reader reader = new BufferedReader(new FileReader("sample.txt"))) {
                    reverser.reverse(reader);
                }
                writer.flush();
                String result = writer.toString();
                if (!"zyxwvutsrqponmlkjihgfedcba".equals(result)) {
                    System.out.println("FAILED!");
                    System.exit(1);
                }
            }
            try (StringWriter writer = new StringWriter()) {
                Reverser reverser = new Reverser(writer);
                reverser.reverse(new StringReader("0123456789"));
                String result = writer.toString();
                if (!"9876543210".equals(result)) {
                    System.out.println("FAILED!");
                    System.exit(1);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("OK");
    }

}
