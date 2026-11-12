package dal;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public void saveExpense(LocalDate date, String item, double price)
    {
        try (FileWriter fw = new FileWriter("expenses.txt", true)) {
            fw.write(date + ";" + item + ";" + price + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getExpenses() {
        List<String> answer = new ArrayList<>();
        try (FileReader fr = new FileReader("expenses.txt")) {
            answer = fr.readAllLines();
        }
        catch (FileNotFoundException fn){
            System.out.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return answer;
    }

}
