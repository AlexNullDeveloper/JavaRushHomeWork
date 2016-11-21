package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by talismanov on 15.11.16.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes type) {
        if (!(type instanceof ImageTypes)) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        ImageReader imageReader = null;
        if (type == ImageTypes.BMP) {
            imageReader = new BmpReader();
        } else if (type == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (type == ImageTypes.PNG) {
            imageReader = new PngReader();
        }

        return imageReader;
    }
}
