package test.osgi.serializer.controller.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import test.osgi.serializer.bean1.Bean1;
import test.osgi.serializer.bean2.Bean2;
import test.osig.serializer.serializer.Serializer;

/**
 * @author markusw
 */
public class Activator implements BundleActivator {

  /**
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(final BundleContext context) throws Exception {
    final ServiceReference<Serializer> serializerRef = context
        .getServiceReference(Serializer.class);
    try {
      final Serializer serializer = context.getService(serializerRef);

      final String serialized = serializer.serialize("Hello World!");
      final String deserialized = serializer.deserialize(serialized,
          String.class);

      System.out.println("Deserilized: " + deserialized);

      final String bean2Str = serializer.serialize(new Bean2(new Bean1(
          "bean1-value")));
      System.out.println("Bean2-String: " + bean2Str);
      final Bean2 bean2Deserialized = serializer.deserialize(bean2Str,
          Bean2.class);
      System.out.println("Bean2: " + bean2Deserialized);

    } finally {
      context.ungetService(serializerRef);
    }
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext context) throws Exception {
  }

}
