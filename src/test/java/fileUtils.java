import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileUtils {
    public static String carregarArquivoTexto(String filename){
        try {
            BufferedReader br =  new BufferedReader(new FileReader(filename));
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
            br.close();
            return sb.toString();
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
