package com.code._misc;
/**
 * Copyright (c) 2016 GT Nexus. All Rights Reserved.
 */
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author oprakash
 * @created 14-Sep-2016
 * @vcsid $Id: $
 */
public class LargeFileSplitTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Path bigFile = Paths.get("C:\\Users\\oprakash\\Desktop\\BigFile\\readme.txt");
        try {
            System.out.println("-----------------start splitting---------------------");
            LargeFileSplitLogic.splitTextFiles(bigFile, 100);
            System.out.println("--------------completed-------------------------");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
