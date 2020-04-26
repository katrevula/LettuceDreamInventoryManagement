package LettuceDream.modules.Customer.Models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import  javax.persistence.GeneratedValue;
import  javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;

/****
 *  Customer Model and the database has the below attributes  and id is auto generated
 */

@Entity
public class CustomerModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_id;

    private String customer_name;
    private String contact_personal_email_address;
    private String contact_person_phone;

    @CreationTimestamp
    private Date date_Registered;
    private String street_address;
    private String city;
    private String state;
    private int zip_code;


    /****
     *
     * @return customer_id
     */
    public long getCustomer_id() {
        return customer_id;
    }

    /***
     *
     * @param customer_id
     */
    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    /***
     *
     * @return customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /***
     *
     * @param customer_name
     */

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    /***
     *
     * @return contact_personal_email_address
     */
    public String getContact_personal_email_address() {
        return contact_personal_email_address;
    }

    /***
     *
      * @param contact_personal_email_address
     */
    public void setContact_personal_email_address(String contact_personal_email_address) {
        this.contact_personal_email_address = contact_personal_email_address;
    }

    /***
     *
     * @return contact_person_phone
     */
    public String getContact_person_phone() {
        return contact_person_phone;
    }

    /***
     *
     * @param contact_person_phone
     */
    public void setContact_person_phone(String contact_person_phone) {
        this.contact_person_phone = contact_person_phone;
    }

    /***
     *
     * @return date_Registered
     */
    public Date getDate_Registered() {
        return date_Registered;
    }

    /***
     *
     * @param date_Registered
     */
    public void setDate_Registered(Date date_Registered) {
        this.date_Registered = date_Registered;
    }

    /***
     *
     * @return street_address
     */
    public String getStreet_address() {
        return street_address;
    }

    /***
     *
     * @param street_address
     */
    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    /***
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /***
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /***
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /***
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /***
     *
     * @return zip_code
     */
    public int getZip_code() {
        return zip_code;
    }

    /***
     *
     * @param zip_code
     */
    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
}
