package test.osgi.serializer.bean1.internal;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import test.osgi.serializer.bean1.Bean1;
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
    properties.put("type", Bean1.class.getName());
    context.registerService(OsgiTypeResolver.class, new TypeResolver(),
        properties);
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext context) throws Exception {
  }

  private static class TypeResolver implements OsgiTypeResolver {

    /**
     * @see test.osig.serializer.api.OsgiTypeResolver#resolve()
     */
    @Override
    public Class<?> resolve() {
      return Bean1.class;
    }
  }

}
