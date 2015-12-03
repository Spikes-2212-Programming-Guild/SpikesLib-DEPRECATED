/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author thinkredstone
 */
public class ImageProcessor implements Closeable {

    private Process process = null;
    private double d;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;

    public ImageProcessor(String path) {
        try {
            process = new ProcessBuilder("python", path).start();
            Thread.sleep(2000);
            socket = new Socket("localhost", 2212);
        } catch (IOException ex) {
            SmartDashboard.putBoolean("NoProcess", true);
        } catch (InterruptedException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public double getLastMeasurement() {
        try {
            writer.print("\n");
            d = Double.valueOf(reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public void close() throws IOException {
        process.destroy();
    }

}
