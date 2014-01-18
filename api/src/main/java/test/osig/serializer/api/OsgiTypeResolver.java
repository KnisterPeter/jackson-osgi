package test.osig.serializer.api;

/**
 * This should be implemented for each type which could be deserialized and
 * published by the according bundle as OSGi service. The purpose of this
 * interface is to fetch the correct classloader of the required type and return
 * the correct class.
 * 
 * @author markusw
 */
public interface OsgiTypeResolver {

  /**
   * @return Returns the resolver known type class
   */
  Class<?> resolve();

}
