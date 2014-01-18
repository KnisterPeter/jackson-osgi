package test.osig.serializer.serializer.internal;

import org.osgi.framework.BundleContext;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;

/**
 * The whole purpopse of this
 * {@link com.fasterxml.jackson.databind.cfg.HandlerInstantiator} is to give the
 * {@link TypeIdResolver} the {@link BundleContext}.
 * 
 * @author markusw
 */
class HandlerInstantiator extends
    com.fasterxml.jackson.databind.cfg.HandlerInstantiator {

  private final BundleContext bundleContext;

  /**
   * @param bundleContext
   */
  public HandlerInstantiator(final BundleContext bundleContext) {
    this.bundleContext = bundleContext;
  }

  /**
   * @see com.fasterxml.jackson.databind.cfg.HandlerInstantiator#deserializerInstance(com.fasterxml.jackson.databind.DeserializationConfig,
   *      com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Class)
   */
  @Override
  public JsonDeserializer<?> deserializerInstance(
      final DeserializationConfig config, final Annotated annotated,
      final Class<?> deserClass) {
    return null;
  }

  /**
   * @see com.fasterxml.jackson.databind.cfg.HandlerInstantiator#keyDeserializerInstance(com.fasterxml.jackson.databind.DeserializationConfig,
   *      com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Class)
   */
  @Override
  public KeyDeserializer keyDeserializerInstance(
      final DeserializationConfig config, final Annotated annotated,
      final Class<?> keyDeserClass) {
    return null;
  }

  /**
   * @see com.fasterxml.jackson.databind.cfg.HandlerInstantiator#serializerInstance(com.fasterxml.jackson.databind.SerializationConfig,
   *      com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Class)
   */
  @Override
  public JsonSerializer<?> serializerInstance(final SerializationConfig config,
      final Annotated annotated, final Class<?> serClass) {
    return null;
  }

  /**
   * @see com.fasterxml.jackson.databind.cfg.HandlerInstantiator#typeResolverBuilderInstance(com.fasterxml.jackson.databind.cfg.MapperConfig,
   *      com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Class)
   */
  @Override
  public TypeResolverBuilder<?> typeResolverBuilderInstance(
      final MapperConfig<?> config, final Annotated annotated,
      final Class<?> builderClass) {
    return null;
  }

  /**
   * @see com.fasterxml.jackson.databind.cfg.HandlerInstantiator#typeIdResolverInstance(com.fasterxml.jackson.databind.cfg.MapperConfig,
   *      com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Class)
   */
  @Override
  public TypeIdResolver typeIdResolverInstance(final MapperConfig<?> config,
      final Annotated annotated, final Class<?> resolverClass) {
    if (resolverClass == OsgiTypeIdResolver.class) {
      return new OsgiTypeIdResolver(this.bundleContext);
    }
    return null;
  }

}