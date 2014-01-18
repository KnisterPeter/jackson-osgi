package test.osgi.serializer.bean2;

import test.osgi.serializer.bean.Bean;

/**
 * @author markusw
 */
public class Bean2 implements Bean {

  private Bean bean;

  /**
   * 
   */
  public Bean2() {
  }

  /**
   * @param bean
   */
  public Bean2(final Bean bean) {
    this.bean = bean;
  }

  /**
   * @return the bean
   */
  public Bean getBean() {
    return this.bean;
  }

  /**
   * @param bean
   *          the bean to set
   */
  public void setBean(final Bean bean) {
    this.bean = bean;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + '[' + this.bean + ']';
  }

}
