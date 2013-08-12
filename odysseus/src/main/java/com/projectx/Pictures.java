package com.projectx;

/**
 * @author steve
 * @since 8/12/13
 */
public class Pictures {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String path) {
        this.filePath = path;
    }

    private String fileName;
    private String filePath;
}