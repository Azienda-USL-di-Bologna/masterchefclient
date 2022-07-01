package it.bologna.ausl.masterchefclient.exceptions;

/**
 *
 * @author Giuseppe De Marco (gmd)
 */
public class RedisClientException extends Exception {

  /**
   *
   */
  public RedisClientException() {
  }


  /**
   * @param message
   */
  public RedisClientException(String message) {
    super(message);
  }


  /**
   * @param cause
   */
  public RedisClientException(Throwable cause) {
    super(cause);
  }


  /**
   * @param message
   * @param cause
   */
  public RedisClientException(String message, Throwable cause) {
    super(message, cause);
  }

}
