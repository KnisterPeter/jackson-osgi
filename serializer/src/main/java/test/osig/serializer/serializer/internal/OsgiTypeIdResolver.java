package test.osig.serializer.serializer.internal;

import java.util.Collection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import test.osig.serializer.api.OsgiTypeResolver;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

/**
 * The {@link TypeIdResolver} searches the OSGi registry for
 * {@link OsgiTypeResolver} services which could resolve a specific type for
 * deserilization.<br>
 * <br>
 * <b>Note: It would be wise to implementent a refactoring-save id-mapping. This
 * default implementation is based on full qualified class names.</b>
 * 
 * @author markusw
 */
class OsgiTypeIdResolver extends TypeIdResolverBase {

  private final BundleContext bundleContext;

  /**
   * @param bundleContext
   */
  public OsgiTypeIdResolver(final BundleContext bundleContext) {
    this.bundleContext = bundleContext;
  }

  /**
   * @see com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver#typeFromId(com.fasterxml.jackson.databind.DatabindContext,
   *      java.lang.String)
   */
  @Override
  public JavaType typeFromId(final DatabindContext context, final String id) {
    try {
      final Collection<ServiceReference<OsgiTypeResolver>> refs = this.bundleContext
          .getServiceReferences(OsgiTypeResolver.class, "(type=" + id + ")");
      if (!refs.isEmpty()) {
        final ServiceReference<OsgiTypeResolver> ref = refs.iterator().next();
        try {
          return context.constructType(this.bundleContext.getService(ref)
              .resolve());
        } finally {
          this.bundleContext.ungetService(ref);
        }
      }
    } catch (final InvalidSyntaxException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @see com.fasterxml.jackson.databind.jsontype.TypeIdResolver#idFromValue(java.lang.Object)
   */
  @Override
  public String idFromValue(final Object value) {
    return value.getClass().getName();
  }

  /**
   * @see com.fasterxml.jackson.databind.jsontype.TypeIdResolver#idFromValueAndType(java.lang.Object,
   *      java.lang.Class)
   */
  @Override
  public String idFromValueAndType(final Object value,
      final Class<?> suggestedType) {
    return suggestedType.getName();
  }

  /**
   * @see com.fasterxml.jackson.databind.jsontype.TypeIdResolver#getMechanism()
   */
  @Override
  public Id getMechanism() {
    return JsonTypeInfo.Id.CLASS;
  }

  /**
   * @see com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase#typeFromId(java.lang.String)
   */
  @Override
  public JavaType typeFromId(final String id) {
    throw new UnsupportedOperationException();
  }

}