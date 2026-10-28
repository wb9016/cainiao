package laohan.test.file_;

import org.junit.Test;

import java.io.*;

/**
 * @author wb
 * @date 2026/10/28 17:12
 */
public class homework {
    public static void main(String[] args) {

    }

    @Test
    public void homework01() throws IOException {
        String directoryPath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\mytemp";
        File mytemp = new File(directoryPath);
        if (mytemp.exists()==false){
            if (mytemp.mkdir()){
                System.out.println("文件夹"+directoryPath+"创建成功");
            }else {
                System.out.println("文件夹"+directoryPath+"创建失败");
            }
//            mytemp.createNewFile();
        }else {
            System.out.println("1.文件夹已存在");
        }

        String filePath="E:\\daima\\IDEA\\Java\\cainiao\\src\\main\\java\\laohan\\test\\file_\\mytemp\\mytemp.txt";
        File file = new File(filePath);
        if (file.exists()==false){
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        }else {
            System.out.println("2.文件已存在");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("hello world!");
        bufferedWriter.write("创建位置为："+file.getPath());
        bufferedWriter.close();
        System.out.println("文件写入成功");
    }
}
