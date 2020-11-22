/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Klein
 */
public class MoveFile {

    public static String move(String URL) {

        File source = new File(URL);
        File target = new java.io.File("Limites.pdf");

        try {
            FileUtils.deleteQuietly(target);
            FileUtils.moveFile(source, target);

        } catch (IOException e) {
            return e.toString();
        }

        return null;
    }
}
