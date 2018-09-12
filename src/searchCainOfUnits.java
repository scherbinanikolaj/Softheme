import java.io.*;

public class searchCainOfUnits {
    public static void main(String[] args) {
        if(args.length != 0 ) {
            // get path
            String path = args[0];

            try(BufferedReader br = new BufferedReader(new FileReader(path))) {
                String str;
                String s = "";
                while((str = br.readLine()) != null) {
                    if(str != "") { // if first line is empty line (mistake user)
                        s += str;
                    }
                }
                int l = s.length();
                int k = 0;
                int max = 0;
                String res = "";
                for(int i = 0; i < l; i++) {
                    if(s.charAt(i) == '1') {
                        k++;
                        if (k > max) {
                            res += s.charAt(i);
                            max = k;
                        }
                    } else {
                        k = 0;
                    }
                }
                String pathout = path.substring(0, path.toUpperCase().indexOf("INPUT.TXT")) + "OUTPUT.TXT";
                try(BufferedWriter bwr = new BufferedWriter(new FileWriter(pathout))) {
                    bwr.write(res + "\n");
                } catch (IOException e) {
                    System.out.println("couldn't write file");
                }
            } catch (IOException e){
                System.out.println("couldn't read file");
            }
        } else
            System.out.println("Enter path for input.txt");
    }
}
