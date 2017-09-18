package java7;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class NewIO {

  public static void main(String[] args) throws IOException {
    SeekableByteChannel newByteChannel =
        Files.newByteChannel(new File("file.txt").toPath(), StandardOpenOption.READ);
    ByteBuffer bb = ByteBuffer.allocate(10);
    String encoding = System.getProperty("file.encoding");
    
  }

}
