package test.osgi.serializer.bean1;

import test.osgi.serializer.bean.Bean;

/**
 * @author markusw
 */
public class Bean1 implements Bean {

  private String value;

  /**
   * 
   */
  public Bean1() {
  }

  /**
   * @param value
   */
  public Bean1(final String value) {
    this.value = value;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * @param value
   *          the value to set
   */
  public void setValue(final String value) {
    this.value = value;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + '[' + this.value + ']';
  }

}
