/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author thinkredstone
 */
public class ImageProcessor implements Closeable {

	private Process process = null;

	public ImageProcessor(String path) {
		try {
			process = Runtime.getRuntime().exec(path);
		} catch (IOException ex) {
			Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	double i = 0;

	public double getLastMeasurement() {
		Scanner s = null;
		try {
			File f = new File("/home/admin/result");
			if (f.exists()) {
				s = new Scanner(f);
				i++;
				SmartDashboard.putNumber("index", i);
				return s.nextDouble();
			}
		} catch (FileNotFoundException ex) {
			return -1;
		}
		return -1;
	}

	@Override
	public void close() throws IOException {
		OutputStream os = process.getOutputStream();
		os.write(3);// 3 is the value of ctrl-c in ascii
		os.flush();
	}

}
