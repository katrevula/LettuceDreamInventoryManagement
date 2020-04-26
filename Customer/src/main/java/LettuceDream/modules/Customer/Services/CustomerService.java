package LettuceDream.modules.Customer.Services;

import LettuceDream.modules.Customer.Models.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.Optional;


/***
 * Interface to so that the we can implement in the implementation Service implementation
 */

@Service
public interface CustomerService {

    public CustomerModel addCustomer(CustomerModel customerModel);
    public Optional<CustomerModel> getCustomerById(long customerId);
    public boolean isExistsCustomer(CustomerModel customerModel);
    public CustomerModel updateCustomer(CustomerModel customerModel);
    public CustomerModel isCustomerExists(String name);




}
