import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;


public class ImageEditor {
    public static BufferedImage rotateAntiClockwise(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j < width ; j++){
                outputImage.setRGB(i, width - j - 1, img.getRGB(j,i));
            }
        }
        return outputImage;
    }
    public static BufferedImage blurr(BufferedImage img){
        BufferedImage outputImage = new BufferedImage(img.getWidth() , img.getHeight(), BufferedImage.TYPE_INT_RGB);
return img;
    }

    public static BufferedImage rotateClockwise(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j < width ; j++){
                outputImage.setRGB(height - i - 1, j, img.getRGB(j,i));
            }
        }
        return outputImage;
    }
    public static void printRGBValues (BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j < width ; j++){
                Color pixel  = new Color(img.getRGB(j,i));
                System.out.print("The red color value is : " + pixel.getRed());
                System.out.print(" The blue color value is : " + pixel.getBlue());
                System.out.print(" The green color value is : " + pixel.getGreen());
            }
        }
    }
    public static BufferedImage Verticalinvert(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0 ; i<height ; i++){
            for (int j = 0 ; j<width ; j++){
                outputImage.setRGB(j, height - i -1, img.getRGB(j,i));
            }
        }
        return outputImage;
    }
    public static BufferedImage Horizontalinvert(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j<width ; j++){
                outputImage.setRGB(width - j - 1, i, img.getRGB(j,i));
            }
        }
        return outputImage;
    }
    public static BufferedImage convertToGrayScale(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height,BufferedImage.TYPE_BYTE_GRAY);
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                outputImage.setRGB(j,i,img.getRGB(j,i));
            }
        }
        return outputImage;
    }
    public static void printPixelValues(BufferedImage img){
        int height = img.getHeight(); // height == number of rows
        int width = img.getWidth(); // width == number of columns
        // iterates over row and column to get the elements of the 2d array
        for (int i = 0 ; i < height ; i++ ){// i is the y coordinate
            for (int j = 0 ; j < width ; j++){// j is the x coordinate
                System.out.print(img.getRGB(j,i) + " ");// prints the coordinates of the pixel of the image
            }
            System.out.println();
        }
    }
    public static BufferedImage changeBrightness(BufferedImage img, int increasePercent){
        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0 ; i<height ; i++){
            for(int j = 0 ; j < width ; j++){
                Color pixel = new Color(img.getRGB(j,i));
                int red = pixel.getRed();
                int blue = pixel.getBlue();
                int green = pixel.getGreen();
                red = red + (increasePercent*red)/100;
                blue = blue + (increasePercent*blue)/100;
                green = green + (increasePercent*green)/100;
                if (red >= 255) red = 255;
                if (green >= 255) green = 255;
                if (blue >= 255) blue = 255;
                if (red <= 0) red = 0;
                if (green <= 0) green = 0;
                if (blue <= 0) blue = 0;
                Color newPixel = new Color(red,blue,green);
                outputImage.setRGB(j, i, newPixel.getRGB());
            }
        }
        return outputImage;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
        System.out.println("Welcome to the Image editor:- ");
        System.out.println("Type any one of the following options to perform the functions:- ");
        System.out.println("1)Convert to gray scale\n2) Rotating image clockwise 90 degrees\n3) Horizontally inverting the image\n4) Vertically inverting the image\n5) Changing the brightness of the image\n6) Print pixel Values\n7) Rotating the image Anticlocwise\n0) to quit from the editor");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        File inputFile = new File("C:\\Users\\HEMKESH\\IdeaProjects\\scaler Java practice\\src\\image.jpg");
        BufferedImage inputImage = ImageIO.read(inputFile);

            if (num == 1) {
                try {
                    BufferedImage grayScale = convertToGrayScale(inputImage);
                    File getFile = new File("grayscaleImage.jpg");
                    ImageIO.write(grayScale, "jpg", getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The image has been converted to gray scale please check in the project file.\n\n\n\n\n\n\n\n\n");
            }
            if (num == 2) {
                try {
                    BufferedImage rotateImage = rotateClockwise(inputImage);
                    File getFile = new File("rotatedClockImage.jpg");
                    ImageIO.write(rotateImage, "jpg", getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The image has been rotated 90 degrees clockwise please check in the project file.\n\n\n\n\n\n\n\n\n");
            }
            if (num == 3) {
                try {
                    BufferedImage HorizontalrotatedImage = Horizontalinvert(inputImage);
                    File getFile = new File("HorizontallyrotatedImage.jpg");
                    ImageIO.write(HorizontalrotatedImage, "jpg", getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The image has been Horizontally rotated please check in the project file.\n\n\n\n\n\n\n\n\n");
            }
            if (num == 4) {
                try {
                    BufferedImage VerticallyrotatedImage = Verticalinvert(inputImage);
                    File getFile = new File("VerticallyrotatedImage.jpg");
                    ImageIO.write(VerticallyrotatedImage, "jpg", getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The image has been Vertically rotated please check in the project file.\n\n\n\n\n\n\n\n\n");
            }
            if (num == 5) {
                System.out.print("ENTER THE PERCENT OF INCREASE OR DECREASE IN BRIGHTNESS : ");
                int increasepercent = sc.nextInt();

                try {
                    BufferedImage chgbrightness = changeBrightness(inputImage, increasepercent);
                    File getFile = new File("changebright.jpg");
                    ImageIO.write(chgbrightness, "jpg", getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The brightness of the image has been increased by "+increasepercent+"% please check in the project file.\n\n\n\n\n\n\n\n\n");
            }
            if (num == 6) {
                System.out.println("The pixel Values are as follows\n\n\n\n\n\n\n\n\n");
                printPixelValues(inputImage);
            }
            if (num == 7){
                try {
                    BufferedImage rotateImage = rotateAntiClockwise(inputImage);
                    File getFile = new File("rotatedAntiImage.jpg");
                    ImageIO.write(rotateImage, "jpg", getFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The image has been rotated 90 degrees anticlockwise please check in the project file.\n\n\n\n\n\n\n\n\n");

            }
            if (num == 0) break;
            else continue;
        }
    }
}
