package laohan.test.file_;

import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * @author wb
 * @date 2026/9/29 16:01
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    public void create01(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test1.txt";

        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void create02(){

        String file="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\";

        File fileName = new File(file);

        String file2Name="test2.txt";

        File file2 = new File(fileName, file2Name);

        try {
            file2.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void create03(){

        String file="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\";

//        File fileName = new File(file);

        String file3Name="test3.txt";

        File file3 = new File(file, file3Name);

        try {
            file3.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void fileInfo(){
        File file = new File("E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt");
        System.out.println("文件名字："+file.getName());
        System.out.println("文件绝对路径："+file.getAbsolutePath());
        System.out.println("文件路径："+file.getPath());
        System.out.println("文件父路径："+file.getParent());
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件是否是目录："+file.isDirectory());
        System.out.println("文件是否是文件："+file.isFile());
        System.out.println("文件大小"+file.length());
        System.out.println("文件最后修改时间："+file.lastModified());
    }

    @Test
    public void m1(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()) {
                System.out.println("文件删除成功。");
            } else {
                System.out.println("文件删除失败！");
            }

        }else {
            System.out.println("文件不存在.");
        }
    }

    @Test
    public void readFile01(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
        int read=0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);

            while ((read = fileInputStream.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void readFile02(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
        int read=0;
        byte[] buf=new byte[8];
        int readLen=0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readLen=fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void writeFile01(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test4.txt";
        FileOutputStream fileOutputStream = null;

        String writeStr="Hello World!";
        try {
            fileOutputStream = new FileOutputStream(filePath,true);
//            fileOutputStream.write('H');
            //字符串转换为字节数组
            fileOutputStream.write(writeStr.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void copyFile01(){
        String fileInputPath="D:\\壁纸\\1.png";
        String fileOutputPath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\1.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        String writeStr="Hello World!";

        try {
            fileInputStream=new FileInputStream(fileInputPath);
            fileOutputStream=new FileOutputStream(fileOutputPath);

            byte[] buf = new byte[1024];
            int readLen=0;

            while ((readLen=fileInputStream.read(buf))!=-1){
                fileOutputStream.write(buf,0,readLen);
            }

            System.out.println("文件复制成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void FileReader01() {
        String filePath = "E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
        FileReader fileReader = null;
        char data = ' ';
        int readLen = 0;
        char[] buf=new char[8];
        try {
            fileReader = new FileReader(filePath);
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Test
    public void FileWriter01() {
        String filePath = "E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
        FileWriter fileWriter = null;
        char[] chars={'H','e','l','l','o',' ','W','o','r','l','d'};

        try {
            fileWriter = new FileWriter(filePath,true);
//            fileWriter.write('H');
            fileWriter.write(chars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Test
    public void OutTime(){
        System.out.println(LocalDateTime.now());
    }


    @Test
    public void BufferedReader01(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";

        BufferedReader bufferedReader=null;

        try {
            bufferedReader=new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void BufferedWriter01(){
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";

        BufferedWriter bw=null;
        BufferedReader br=null;
        String writeStr="wb nb";
        String line;
        try {
            br=new BufferedReader(new FileReader(filePath));
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("修改文字内容");
            bw=new BufferedWriter(new FileWriter(filePath,true));
            bw.write(writeStr);
            bw.newLine();
            bw.write("wb is a good man");
            System.out.println("写入成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void copyFile02(){
        String infile="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
        String outfile="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test4.txt";
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br=new BufferedReader(new FileReader(infile));
            bw=new BufferedWriter(new FileWriter(outfile));
            String line;
            while ((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("文件复制成功");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void copyFile03(){
//        String infile="D:\\壁纸\\1.png";
        String infile="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
//        String outfile="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\1.png";
        String outfile="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test5.txt";
        BufferedInputStream bi=null;
        BufferedOutputStream bo=null;
        try {
            bi = new BufferedInputStream(new FileInputStream(infile));
            bo=new BufferedOutputStream(new FileOutputStream(outfile));
            byte[] buf=new byte[1024];
            int readLen=0;
            while((readLen=bi.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
                bo.write(buf,0,readLen);
            }

            System.out.println("文件复制成功");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                    if (bi != null) {
                        bi.close();
                    }
                    if (bo!=null){
                        bo.close();
                    }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void ObjectOutStream01() throws Exception{
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据
        oos.writeInt(100);
        oos.writeChar('d');
        oos.writeUTF("王博啦啦啦啦l");
        oos.writeObject(new Person("王博",18));

        oos.close();
        System.out.println("数据保存完成");


    }

    @Test
    public void ObjectInputStream01() throws Exception{
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));


        System.out.println(ois.readInt());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());
        Object person = ois.readObject();
        System.out.println(person.getClass());
        System.out.println(person.toString());
        ois.close();
    }

    @Test
    public void InputAndOutPut(){
//        System.in
    }

    @Test
    public void InputStreamReader01() throws Exception{
        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\test3.txt";
        InputStreamReader isr=null;
        isr=new InputStreamReader(new FileInputStream(filePath),"gbk");

        BufferedReader br = new BufferedReader(isr);
        String buf;
        while ((buf=br.readLine()) !=null){
            System.out.println(buf);
        }
        br.close();

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
        new PrintWriter(new FileWriter(filePath)).print(" ");
    }

    @Test
    public void Properties01() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\test01.properties"));
        properties.list(System.out);
        System.out.println(properties.getProperty("user" ));

    }


}

class Person implements Serializable{
    private String name;
    private int age;

    private static final long serialVersionUID = 1L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
