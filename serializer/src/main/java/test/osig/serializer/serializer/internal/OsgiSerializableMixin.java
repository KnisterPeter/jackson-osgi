package test.osig.serializer.serializer.internal;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

/**
 * Mixes this annotations into instances of
 * {@link test.osig.serializer.api.OsgiSerializable}.
 * 
 * @author markusw
 */
@JsonTypeInfo(use = Id.CUSTOM, include = As.PROPERTY, property = "@type")
@JsonTypeIdResolver(OsgiTypeIdResolver.class)
interface OsgiSerializableMixin {
}
