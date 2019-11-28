package slideshow;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageModelImpl implements ImageModel {
    private final List<Image> imageList;
    private int imageIndex;

    public ImageModelImpl() {
        this.imageList = new ArrayList<>();
        imageIndex = 0;

        // fetch all our images and place in list
    }

    @Override
    public Image getNextImage() {
        Image image = imageList.get(imageIndex++);
        imageIndex %= imageList.size();
        return image;
    }
}
