
import java.io.*;

public class ChangeStreamDemo1 {
    public static void main(String[] args) throws IOException {
        method1();
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("G:\\Javatest2\\stream\\test.txt",true),"gbk");
        osw.write("中国");
        osw.close();
        method1();
    }

    private static void method1() throws IOException {
        //        InputStreamReader可以不指定编码，默认是utf-8
        InputStreamReader isr =new InputStreamReader(new FileInputStream("G:\\Javatest2\\stream\\test.txt"),"gbk");
        int i;
        while((i=isr.read())!=-1){
            System.out.println((char)i);
        }
        isr.close();
    }
}