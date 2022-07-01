package it.bologna.ausl.masterchefclient.exceptions;

/**
 *
 * @author Giuseppe De Marco (gmd)
 */
public class MasterChefClientException extends Exception {

  /**
   *
   */
  public MasterChefClientException() {
  }


  /**
   * @param message
   */
  public MasterChefClientException(String message) {
    super(message);
  }


  /**
   * @param cause
   */
  public MasterChefClientException(Throwable cause) {
    super(cause);
  }


  /**
   * @param message
   * @param cause
   */
  public MasterChefClientException(String message, Throwable cause) {
    super(message, cause);
  }

}
