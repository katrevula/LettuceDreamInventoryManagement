import React, { Component } from 'react';

class AddCustomer extends Component{
     // add constructor and initialize state
    constructor(props){
        super(props);
 
        this.state = {
            pname: "",
            email: "",
            phone: "",
            address: "",
            zip: ""
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
        const { pname, email, phone, address, zip } = this.state;
        // returning the Ui to be rendered
        return ( 
        <form>         
        <div className="container-fluid" >
            
            <div className="row"> 
                <div className="col-md-5"></div>
                <div className="col-md-2" >
                <div className="text-primary" >
                    <label htmlFor="main"><b><h3>Add Customer</h3></b></label>
                </div>
                </div>
                <div className="col-md-5"></div>
            </div>
        
        <div className="row">   
            <div className="col-md-3"></div>
                
                <div className="col-md-4">  
                    
                        <div className="form-group">
                        <label htmlFor="pname"><b>CUSTOMER NAME :</b></label><br></br>
                        <input name="pname" type="text" value={pname} onChange={this.handleChange}/>
                        <span style={{color: "red"}}></span><br></br>                        

                        <label htmlFor="email"><b>EMAIL :</b></label><br></br>
                        <input name="email" type="text" value={email} onChange={this.handleChange}/>
                        <span style={{color: "red"}}></span><br></br>

                        <label htmlFor="phone"><b>PHONE NUMBER :</b></label><br></br>
                        <input name="phone" type="text" value={phone} onChange={this.handleChange}/>
                        <span style={{color: "red"}}></span><br></br>

                        <label htmlFor="address"><b>ADDRESSS :</b></label><br></br>
                        <input name="address" type="text" value={address} onChange={this.handleChange}/>
                        <span style={{color: "red"}}></span><br></br>

                        <label htmlFor="zip"><b>ZIP CODE :</b></label><br></br>
                        <input name="zip" type="text" value={zip} onChange={this.handleChange}/>
                        <span style={{color: "red"}}></span><br></br>

                        
                        <div className="row">
                            <div className="col-md-2">
                           
                            </div>
                            </div>           
                        </div>
                </div>
                       </div>

        <div className="row"> 
                <div className="col-md-3"></div>
               
                <div class="col-md-2" >
                    <button type="button" className="btn btn-default bg-success" id="sumbit" value="Submit" onClick={this.handleSubmit} >SUBMIT</button>
                </div>                
               
                <div className="col-md-3"></div>
            </div><br></br><br></br><br></br><br></br>
            </div>
        </form> 

            
    
        );
    }
}
// exporting the component
export default AddCustomer;
