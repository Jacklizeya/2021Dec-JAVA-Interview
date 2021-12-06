import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;

public class ImageProcessing {
	public static void main(String[] args) {
    // The provided images are apple.jpg, flower.jpg, and kitten.jpg
		int[][] imageData = imgToTwoD("./apple.jpg");
    // Or load your own image using a URL!
		//int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
		// viewImageData(imageData);
		// int[][] trimmed = trimBorders(imageData, 60);
		
		// int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
		// Painting with pixels

        // Task #1 for negative
        // int[][] allFilters = negativeColor(imageData);
        // twoDToImage(allFilters, "./negative_apple.jpg");

        // Task #2 for stretch
        // int[][] allFilters = stretchHorizontally(imageData);
        // twoDToImage(allFilters, "./stretched_apple.jpg");

        // Task #3 for shrink
        // int[][] allFilters = shrinkVertically(imageData);
        // twoDToImage(allFilters, "./shrinked_apple.jpg");

        // Task #4 for Invert
        // int[][] allFilters = invertImage(imageData);
        // twoDToImage(allFilters, "./inverted_apple.jpg");

        // Task #5 for Reduced
        // int[][] allFilters = colorFilter(imageData, -75, 30, -30);
        // twoDToImage(allFilters, "./reducedColor_apple.jpg");

        // Task #6 for Random
        // int[][] randomPicture = paintRandomImage(new int[500][500]);
        // twoDToImage(randomPicture, "./random_canvas.jpg");

        // Task #7 for Rectanglar
        // int[] desiredColorInArray = {255, 255, 0, 255};
        // int desiredColor = getColorIntValFromRGBA(desiredColorInArray); 
        // int[][] rectanglarPicture = paintRectangle(imageData, 100, 100, 100, 100, desiredColor);
        // twoDToImage(rectanglarPicture, "./rect_canvas.jpg");

        // Task #8 Multiple rects
        int[][] originalRawPicture = new int[1000][1000];
        int[][] multipleRandomRects = generateRectangles(originalRawPicture, 5);
        twoDToImage(multipleRandomRects, "./copyPhoto.jpg");


        // generateRectangles(originalRawPicture, 5);
        // twoDToImage(originalRawPicture, "./directModify.jpg");
	}
	// Image Processing Methods
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}
	public static int[][] negativeColor(int[][] imageTwoD) {
		int[][] negativeColorImage = new int[imageTwoD.length][imageTwoD[0].length];
        for (int row = 0; row < imageTwoD.length; row++) {
            for (int col =0; col < imageTwoD[0].length; col++) {
                int[] rgba = getRGBAFromPixel(imageTwoD[row][col]);
                int[] negativergba = {255 - rgba[0], 255 - rgba[1], 255 - rgba[2], rgba[3]};
                negativeColorImage[row][col] = getColorIntValFromRGBA(negativergba);
            }
        }
		return negativeColorImage;
	}
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
        int[][] stretchedImage = new int[imageTwoD.length][imageTwoD[0].length * 2];

        for (int row = 0; row < imageTwoD.length; row++) {
            for (int col =0; col < imageTwoD[0].length; col++) {
                stretchedImage[row][col * 2] = imageTwoD[row][col] ;
                stretchedImage[row][col * 2 + 1] = imageTwoD[row][col] ;
            }
        }
		return stretchedImage;
	}
	public static int[][] shrinkVertically(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
		int[][] shirnkedImage = new int[imageTwoD.length/2][imageTwoD[0].length];

        for (int col = 0; col < imageTwoD[0].length; col++) {
            for (int row =0; row < imageTwoD.length/2; row++) {
                shirnkedImage[row][col] = imageTwoD[row * 2][col];
            }
        }
		return shirnkedImage;
	}
	public static int[][] invertImage(int[][] imageTwoD) {
		int[][] invertedImage = new int[imageTwoD.length][imageTwoD[0].length];
        for (int row = 0; row < imageTwoD.length; row++) {
            for (int col =0; col < imageTwoD[0].length; col++) {
                invertedImage[row][col] = imageTwoD[imageTwoD.length -1 - row][imageTwoD[0].length -1 - col];
            }
        }
		return invertedImage;
	}
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
		int[][] changeColor = new int[imageTwoD.length][imageTwoD[0].length];
        for (int row = 0; row < imageTwoD.length; row++) {
            for (int col =0; col < imageTwoD[0].length; col++) {
                int[] rgba = getRGBAFromPixel(imageTwoD[row][col]);
                int newRed = rgba[0] + redChangeValue;
                if (newRed < 0) {newRed = 0;} else if (newRed > 255) {newRed = 255;}

                int newGreen = rgba[1] + greenChangeValue;
                if (newGreen < 0) {newGreen = 0;} else if (newGreen > 255) {newGreen = 255;}

                int newBlue = rgba[2] + blueChangeValue;
                if (newBlue < 0) {newBlue = 0;} else if (newBlue > 255) {newBlue = 255;}

                int[] negativergba = {newRed, newGreen, newBlue, rgba[3]};
                changeColor[row][col] = getColorIntValFromRGBA(negativergba);

                // changeColor[row][col] = getColorIntValFromRGBA({newRed, newGreen, newBlue, rgba[3]});
            }
        }
		return changeColor;
	}
	// Painting Methods
	public static int[][] paintRandomImage(int[][] canvas) {
        Random rand = new Random();  
        int[][] randomImage = new int[canvas.length][canvas[0].length];
        for (int row = 0; row < 500; row++) {
            for (int col =0; col < 500; col++) {
                int randomRed = rand.nextInt(256);
                int randomGreen = rand.nextInt(256);
                int randomBlue = rand.nextInt(256);
                int[] randomRGB = {randomRed, randomGreen, randomBlue, 255};
                randomImage[row][col] = getColorIntValFromRGBA(randomRGB);
            }
        }
		return randomImage;
	}
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
		// TODO: Fill in the code for this method
        // int[][] rectImage = new int[canvas.length][canvas[0].length];
        for (int row = 0; row < canvas.length; row++) {
            for (int col =0; col < canvas[0].length; col++) {
                if (
                    row >= rowPosition && row <= rowPosition + width && col >= colPosition && col <= colPosition + height
                ) {
                    canvas[row][col] = color;
                }
            }
        }
		return canvas;
	}
	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
		// TODO: Fill in the code for this method
        Random rand = new Random();  
        for (int noRectangles = 0; noRectangles < numRectangles; noRectangles++) {
            int randomHeight = rand.nextInt(canvas.length);
            int randomWidth = rand.nextInt(canvas[0].length);
            int startingHeight = canvas.length - randomHeight;
            int startingWidth = canvas[0].length - randomWidth;

            int randomRed = rand.nextInt(256);
            int randomGreen = rand.nextInt(256);
            int randomBlue = rand.nextInt(256);
            int[] randomRGB = {randomRed, randomGreen, randomBlue, 255};
            int randomColor = getColorIntValFromRGBA(randomRGB);

            paintRectangle(canvas, randomWidth, randomHeight, startingHeight, startingWidth, randomColor);

        }
		return canvas;
	}
	// Utility Methods
	public static int[][] imgToTwoD(String inputFileOrLink) {
		try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}
