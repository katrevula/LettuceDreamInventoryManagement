import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";

class OrderReport extends Component{

    constructor(props){
        super(props);
 
        this.state = {
            bayid: "",
            bname: ""
            
        };
     }
     
     handleChange = event => {
        this.setState({
          [event.target.name]: event.target.value
        });
      };
    
      handleSubmit = event => {
        console.log("Submitting");

        console.log(this.state);
      };

    render(){
        const { bayid, bname } = this.state;
        return (     
        <form>         
        <div class="container-fluid" >
            
            <div class="row"> 
                <div class="col-md-5"></div>
                <div class="col-md-2" >
                <div class="text-primary" >
                    <label for="main"><b><h3>Order Report</h3></b></label>
                </div>
                </div>
                <div class="col-md-5"></div>
            </div>
        
        <div class="row">   
            <div className="col-md-3"></div>
                
                <div class="col-md-4">  
                
                    
                        <div class="form-group">

                        <label for="bayid"><b>Order By Date :</b></label><br></br>
                        
            <div>
                <DatePicker
               selected={this.state.startdate} onChange={this.handleChange}
              />
            </div>
                         
                        
                        <div class="row">
                            <div class="col-md-2">
                           
                            </div>
                        </div>           
                    </div>
            </div>
         </div>

        <div class="row"> 
                <div class="col-md-3"></div>
               
                <div class="col-md-2" >
                    <button type="button" class="btn btn-default bg-success" id="sumbit" value="Submit" onClick={this.handleSubmit} >SUBMIT</button>
                </div>                
               
                <div class="col-md-3"></div>
            </div><br></br><br></br><br></br><br></br>
            </div>
        </form> 

            
    
        );
    }
}

export default OrderReport;