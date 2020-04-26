package LettuceDream.modules.Customer.Models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/***
 * Created are response to show status code and status message as helper for the client.
 *
 */

@Component
public class ResponeModel {

    private boolean  status;
    private int statusCode;
    private String message;
    private Object result;

    /***
     *
     * @return status
     */
    public boolean isStatus() {
        return status;
    }

    /***
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /***
     *
     * @return statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /***
     *
     * @param statusCode
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /***
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /***
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /***
     *
     * @return result
     */
    public Object getResult() {
        return result;
    }

    /***
     *
     * @param result
     */
    public void setResult(Object result) {
        this.result = result;
    }
}
