package laohan.test.file_;

import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;

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
}
