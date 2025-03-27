package DaChangBrushUpClass.class1;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//给定一个文件目录的路径，写一个函数统计这个目录下所有的文件数量并返回，隐藏文件也算，但是文件夹不算
public class CountFiles {

    public static int getFileNumberByStack(String folderPath) {
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.add(root);
        int files = 0;
        while (!stack.isEmpty()) {
            //遍历文件夹，如果是文件则计数，如果是文件夹就入栈继续遍历
            File folder = stack.pop();
            for (File next : folder.listFiles()) {
                if (next.isFile()) {
                    files++;
                }
                if (next.isDirectory()) {
                    stack.push(next);
                }
            }
        }
        return files;
    }

    public static int countFilesInDirectoryRecur(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() ||!directory.isDirectory()) {
            return 0;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            return 0;
        }
        int count = 0;
        for (File file : files) {
            if (file.isFile()) {
                count++;
            } else if (file.isDirectory()) {
                count += countFilesInDirectoryRecur(file.getAbsolutePath());
            }
        }
        return count;
    }

    public static int countFilesInDirectoryByQueue(String directoryPath) {
        File root = new File(directoryPath);
        // 若目录不存在或不是目录类型，返回 0
        if (!root.exists() ||!root.isDirectory()) {
            return 0;
        }
        Queue<File> directoryQueue = new LinkedList<>();
        directoryQueue.add(root);
        int fileCount = 0;

        while (!directoryQueue.isEmpty()) {
            File currentDir = directoryQueue.poll();
            File[] items = currentDir.listFiles();
            if (items != null) {
                for (File item : items) {
                    if (item.isFile()) {
                        fileCount++;
                    } else if (item.isDirectory()) {
                        directoryQueue.add(item);
                    }
                }
            }
        }
        return fileCount;
    }


    public static void main(String[] args) {
        String directoryPath = "E:\\新建文件夹";
        int fileCount = countFilesInDirectoryByQueue(directoryPath);
        System.out.println("该目录下的文件数量为: " + fileCount);
    }
}
