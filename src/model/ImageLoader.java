package model;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

public class ImageLoader {

	public ImageIcon getImageFrom(String path) {
		ImageIcon image;
		try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path)) {
            if (inputStream != null) {
                
                image = new ImageIcon(javax.imageio.ImageIO.read(inputStream));
                
                return image;
            } else {
                System.out.println("Error : Image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
		return null;
	}
}
