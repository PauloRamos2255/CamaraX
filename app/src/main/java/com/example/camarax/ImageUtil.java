package com.example.camarax;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.media.Image;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;
import java.util.Objects;

public class ImageUtil {

    public static Bitmap imageProxyToBitmap(ImageProxy imageProxy) {
        Objects.requireNonNull(imageProxy);

        ImageProxy.PlaneProxy[] planes = imageProxy.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);

        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int format = imageProxy.getFormat();

        Bitmap bitmap = null;

        switch (format) {
            case ImageFormat.YUV_420_888:
                // Implementa la conversión para el formato YUV_420_888 según tus necesidades
                // Puedes utilizar la función yuv420888ToRgb aquí
                break;
            case ImageFormat.JPEG:
            case ImageFormat.NV21:
                // Ajusta el tamaño del búfer según el formato
                ByteBuffer yuv420888ToRgb = yuv420888ToRgb(bytes, width, height);
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                bitmap.copyPixelsFromBuffer(yuv420888ToRgb);
                break;
            default:
                // Maneja otros formatos si es necesario
                break;
        }

        imageProxy.close();

        return bitmap;
    }

    // Método para convertir YUV_420_888 a RGB (debes implementar esto según tus necesidades)
    private static ByteBuffer yuv420888ToRgb(byte[] yuv420888, int width, int height) {
        // Implementa la conversión de YUV_420_888 a RGB
        // Aquí debes utilizar la información de width, height y los bytes de la imagen
        // Retorna un ByteBuffer con los datos RGB
        // Ten en cuenta que este método es específico y debería adaptarse a tus requisitos
        return ByteBuffer.allocateDirect(width * height * 4); // Tamaño arbitrario para este ejemplo
    }
}
