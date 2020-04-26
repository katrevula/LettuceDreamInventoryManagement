package LettuceDream.modules.Customer.Services;

import LettuceDream.modules.Customer.Models.CustomerModel;
import LettuceDream.modules.Customer.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/***
 * Implementation class that implements the Customer service
 */

@Service
public class CustomerServiceImpl implements  CustomerService{


    /***
     * Implementation class that implements the Customer service
     */
    @Autowired
    public  CustomerRepository customerRepository;
    @Override
    public CustomerModel addCustomer(CustomerModel customerModel) {
        return customerRepository.saveAndFlush(customerModel);
    }

    /***
     *
     * @param customerId
     * @return
     */
    @Override
    public Optional<CustomerModel> getCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }

    /***
     *
     * @param customerModel
     * @return
     */
    @Override
    public boolean isExistsCustomer(CustomerModel customerModel){
         return customerRepository.isCustomerExists(customerModel.getCustomer_name(),
                 customerModel.getContact_personal_email_address(),customerModel.getStreet_address())==null;
    }

    /***
     *
     * @param customerModel
     * @return
     */
    @Override
    public CustomerModel updateCustomer(CustomerModel customerModel) {
       return  customerRepository.saveAndFlush(customerModel);
    }

    /***
     *
     * @param name
     * @return
     */
    @Override
    public CustomerModel isCustomerExists(String  name){
        return customerRepository.findCustomerByName(name);
    }
}
