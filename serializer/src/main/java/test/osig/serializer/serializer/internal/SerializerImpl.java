package test.osig.serializer.serializer.internal;

import java.io.IOException;

import org.osgi.framework.BundleContext;

import test.osig.serializer.api.OsgiSerializable;
import test.osig.serializer.serializer.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * This is the base serializer implementation which configures and handles
 * serialization and deserialization.
 * 
 * @author markusw
 */
public class SerializerImpl implements Serializer {

  private final ObjectMapper om;

  /**
   * @param bundleContext
   */
  public SerializerImpl(final BundleContext bundleContext) {
    this.om = new ObjectMapper();
    this.om.setHandlerInstantiator(new HandlerInstantiator(bundleContext));
    final SimpleModule simple = new SimpleModule("OSGi Serializable Module");
    simple.setMixInAnnotation(OsgiSerializable.class,
        OsgiSerializableMixin.class);
    this.om.registerModule(simple);
  }

  @Override
  public String serialize(final Object o) throws IOException {
    return this.om.writeValueAsString(o);
  }

  @Override
  public <T> T deserialize(final String str, final Class<T> clazz)
      throws IOException {
    return this.om.readValue(str, clazz);
  }

}
