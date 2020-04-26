package LettuceDream.modules.Customer.Controllers;

import LettuceDream.modules.Customer.Models.CustomerModel;
import LettuceDream.modules.Customer.Models.ResponeModel;
import LettuceDream.modules.Customer.Services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


/***
 *  Controller for the Customer Class
 */

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    ResponeModel responeModel;


    /***
     *
     * @param customerModel
     * @param uriBuilder
     * @param response
     * @return
     */

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody CustomerModel customerModel, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        System.out.println("**************************");
        System.out.println(customerModel);
        System.out.println("**************************");
        /***
         * checks if the customer exists are not before adding the customer
         */
        if(customerService.isExistsCustomer(customerModel)){
            CustomerModel addedCustomerModel = customerService.addCustomer(customerModel);
            responeModel.setStatus(true);
            responeModel.setStatusCode(HttpStatus.OK.value());
            responeModel.setMessage("success");
            responeModel.setResult(addedCustomerModel);
            headers.setLocation(uriBuilder.path("/api/customer/{id}").buildAndExpand(customerModel.getCustomer_id()).toUri());
            return ResponseEntity.ok().headers(headers).body(responeModel);
        }
        /***
         * else part to show the response code
         */
        else{
            responeModel.setStatus(false);
            responeModel.setStatusCode(HttpStatus.CONFLICT.value());
            responeModel.setMessage("failed");
            responeModel.setResult(new String("user already exists"));
            return ResponseEntity.ok().headers(headers).body(responeModel);
        }
    }

    /***
     *
     * @param customerModel
     * @param uriBuilder
     * @param response
     * @return
     */

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerModel customerModel, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        CustomerModel customerToBeupdated = customerService.isCustomerExists(customerModel.getCustomer_name());

        /***
         * checks if the customer to be updated is not null
         */
        if(customerToBeupdated!=null){
            customerToBeupdated.setContact_personal_email_address(customerModel.getContact_personal_email_address());
            customerToBeupdated.setContact_person_phone(customerModel.getContact_person_phone());
            customerToBeupdated.setStreet_address(customerModel.getStreet_address());
            customerToBeupdated.setCity(customerModel.getCity());
            customerToBeupdated.setState(customerModel.getState());
            customerToBeupdated.setZip_code(customerModel.getZip_code());
            responeModel.setStatus(true);
            responeModel.setStatusCode(HttpStatus.OK.value());
            responeModel.setMessage("success");
            responeModel.setResult(customerService.updateCustomer(customerToBeupdated));
            headers.setLocation(uriBuilder.path("/api/customer/{id}").buildAndExpand(customerModel.getCustomer_id()).toUri());
            return ResponseEntity.ok().headers(headers).body(responeModel);
        }
        /***
         *
         */
        else{
            responeModel.setStatus(false);
            responeModel.setStatusCode(HttpStatus.NOT_FOUND.value());
            responeModel.setMessage("failed");
            responeModel.setResult(new String("Customer with customer Id"+customerModel.getCustomer_id()+"does not exists"));
            return ResponseEntity.ok().headers(headers).body(responeModel);
        }
    }

    /***
     *
     * @param id
     * @param uriBuilder
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        Optional<CustomerModel> customer = customerService.getCustomerById(id);

        /***
         *  gets the customer with id
         */
        customer.ifPresentOrElse(
                 CustomerModel->{ responeModel.setStatus(true);
                 responeModel.setStatusCode(HttpStatus.OK.value());
                 responeModel.setMessage("success");
                 responeModel.setResult(CustomerModel);
          },
                 ()->{
                     responeModel.setStatus(false);
                     responeModel.setStatusCode(HttpStatus.NOT_FOUND.value());
                     responeModel.setMessage("failed");
                     responeModel.setResult(new String("Customer with customer Id"+id+"does not exists"));
                 }
         );


          return ResponseEntity.ok().headers(headers).body(responeModel);
    }

}
