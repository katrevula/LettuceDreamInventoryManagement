import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";

class ProductionReport extends Component{
    // add constructor and initialize state
    constructor(props){
        super(props);
 
        this.state = {
            bayid: "",
            bname: ""
            
        };
     }
     
     // called when onchange event is clicked, to set a new state for the input 
     handleChange = event => {
        this.setState({
          [event.target.name]: event.target.value
        });
      };
    
      // to  handle the subission of the form
      handleSubmit = event => {
        console.log("Submitting");

        console.log(this.state);
      };

    // Transforming react components into DOM nodes that a browser can understand and display on the screen
    render(){
        const { bayid, bname } = this.state;
        // returning the Ui to be rendered
        return (     
        <form>         
        <div class="container-fluid" >
            
            <div class="row"> 
                <div class="col-md-5"></div>
                <div class="col-md-2" >
                <div class="text-primary" >
                    <label for="main"><b><h3>Product Report</h3></b></label>
                </div>
                </div>
                <div class="col-md-5"></div>
            </div>
        
        <div class="row">   
            <div className="col-md-3"></div>
                
                <div class="col-md-4">  
                
                    
                        <div class="form-group">

                        <label for="bayid"><b>Production By Date :</b></label><br></br>
                        
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
// exporting the component
export default ProductionReport;
