package test.osig.serializer.serializer.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

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
    context
        .registerService(Serializer.class, new SerializerImpl(context), null);
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext context) throws Exception {
  }

}
