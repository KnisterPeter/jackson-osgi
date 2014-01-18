package test.osig.serializer.serializer;

import java.io.IOException;

/**
 * @author markusw
 */
@SuppressWarnings("javadoc")
public interface Serializer {

  public String serialize(Object o) throws IOException;

  public <T> T deserialize(String str, Class<T> clazz) throws IOException;

}
