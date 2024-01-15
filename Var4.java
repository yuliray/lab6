import java.io.*;
import java.util.Scanner;

/*4 вариант
Переписать в результирующий файл слова
короче первого слова строки*/

public class Var4 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try{
            in= new FileInputStream("D:\\Java\\in.txt");
            file = new InputStreamReader(in, "utf-8");
            buf = new BufferedReader(file);

            File f2 = new File("D:\\Java\\out.txt");
            f2.createNewFile();
            out = new FileOutputStream(f2);
            wr = new OutputStreamWriter(out, "utf-8");
            if (f2.exists()){
                String line = " ";
                String [] words;
                while((line=buf.readLine())!=null){
                    words = line.split(" ");
                    int n = words[0].length();
                    System.out.println("Первое слово = "+ words[0] + " length = "+ words[0].length());
                    for (int i=1;i<words.length;i++){
                        if(words[i].length()<n){
                            wr.append(words[i]+ " ");
                            System.out.print(words[i] + " ");
                        }
                    }
                    System.out.println("");
                    wr.append("\n");
                }
            }
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}
