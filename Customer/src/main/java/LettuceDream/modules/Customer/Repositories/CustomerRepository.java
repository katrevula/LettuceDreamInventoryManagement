package LettuceDream.modules.Customer.Repositories;

import LettuceDream.modules.Customer.Models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/***
 * Data access object layer to interact with the database queries to check  if the customer exista and also to find the customer by customer name
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Long>{


    @Query("select t from CustomerModel t where (t.customer_name = :customer_name and t.contact_personal_email_address=:contact_personal_email_address" +
            " and t.street_address=:street_address)")
     CustomerModel isCustomerExists(@Param("customer_name") String customer_name,
                                    @Param("contact_personal_email_address") String contact_personal_email_address,@Param("street_address") String street_address);


    @Query("select t from CustomerModel t where (t.customer_name = :customer_name)")
    CustomerModel findCustomerByName(@Param("customer_name") String customer_name);
}
