import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Collections;

/**
 * Files example. List the images in the resource image directory
 */
public class FilesExample {

    private static final String ImageDirectory = "images";

    public static void main(String args[]) {
        Path imagePath;

        try {
            // find the URI to our image directory
            URI imageResource = FilesExample.class.getResource(ImageDirectory).toURI();

            if (imageResource.getScheme().equals("jar")) {
                // if we are running from a jar then construct a file system of the images resources
                FileSystem fileSystem = FileSystems.newFileSystem(imageResource, Collections.emptyMap());
                imagePath = fileSystem.getPath(ImageDirectory);
            } else {
                // else we are running from a non-jar application
                imagePath = Paths.get(imageResource);
            }

            // create a directory stream glob that contains only image files and display the file name
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(imagePath, "*.{jpeg, jpg, png}")) {
                for (Path file : stream) {
                    System.out.println(file.getFileName());
                }
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}

