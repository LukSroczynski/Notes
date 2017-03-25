public class FileReader {
    
    FileInputStream inputStream = null;
    Scanner sc = null;

    public FileReader(String projectFilePath) {
        
        try {
            getAbsoluteSystemPath(projectFilePath);
            inputStream = new FileInputStream(projectFilePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                 System.out.println(line);
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
}
