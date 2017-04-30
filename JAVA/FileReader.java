package spring.annotations.file.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Surreallistic on 25.03.2017.
 */
public class FileReader {

    private ArrayList<String> data = new ArrayList<>();
    private FileInputStream inputStream = null;
    private Scanner sc = null;

    /**
     * Put project path e.g. src/data/file.txt
     * @param projectFilePath
     */
    public FileReader(String projectFilePath) {

        try {
            getAbsoluteSystemPath(projectFilePath);
            inputStream = new FileInputStream(projectFilePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                data.add(line);
//                System.out.println(line);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**
     * Get system path and return full path to file. Required project path
     * e.g. src/data/file.txt
     * @param projectPath
     * @return
     */
    private String getAbsoluteSystemPath(String projectPath) {
        File systemPath = new File(projectPath);
        String fullPath = systemPath.getAbsolutePath();
        return fullPath;
    }

    public ArrayList<String> getCollectionOfLines() {
        return data;
    }
}
