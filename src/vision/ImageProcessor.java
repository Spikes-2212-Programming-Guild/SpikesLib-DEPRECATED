/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thinkredstone
 */
public class ImageProcessor implements Closeable {

    private Process process = null;
    private final Scanner scanner;
    private double d = 0;

    public ImageProcessor(String path) {
        try {
            process = Runtime.getRuntime().exec(path);
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        scanner = new Scanner(process.getInputStream());
    }

    public double getLastMeasurement() {
        while (scanner.hasNext()) {
            d = scanner.nextDouble();
        }
        return d;
    }

    @Override
    public void close() throws IOException {
        OutputStream os = process.getOutputStream();
        os.write(3);//3 is the value of ctrl-c in ascii
        os.flush();
    }

}
