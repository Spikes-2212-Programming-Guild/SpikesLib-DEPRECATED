/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author thinkredstone
 */
public class ImageProcessor implements Closeable {

    private Process process = null;
    private double d;
    private BufferedReader reader;

    public ImageProcessor(String path) {
        try {
            process = new ProcessBuilder("python", path).start();
        } catch (IOException ex) {
            SmartDashboard.putBoolean("NoProcess", true);
        }
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    double i = 0;

    public double getLastMeasurement() {
        try {
            return Double.valueOf(reader.readLine());
        } catch (IOException ex) {
            return -1;
        }
    }

    @Override
    public void close() throws IOException {
        OutputStream os = process.getOutputStream();
        os.write(3);// 3 is the value of ctrl-c in ascii
        os.flush();
    }

}
