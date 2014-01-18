package test.osgi.serializer.bean2.internal;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import test.osgi.serializer.bean2.Bean2;
import test.osig.serializer.api.OsgiTypeResolver;

/**
 * @author markusw
 */
public class Activator implements BundleActivator {

  /**
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(final BundleContext context) throws Exception {
    final Hashtable<String, String> properties = new Hashtable<String, String>();
    properties.put("type", Bean2.class.getName());
    context.registerService(OsgiTypeResolver.class, new Factory(), properties);
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext context) throws Exception {
  }

  private static class Factory implements OsgiTypeResolver {

    /**
     * @see test.osig.serializer.api.OsgiTypeResolver#resolve()
     */
    @Override
    public Class<?> resolve() {
      return Bean2.class;
    }
  }

}
