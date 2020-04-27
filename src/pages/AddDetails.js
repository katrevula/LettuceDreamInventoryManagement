import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
// importing react date picker
import "react-datepicker/dist/react-datepicker.css";


class AddDetails extends Component{

    // add constructor and initialize state
    constructor(props){
        super(props);
 
        this.state = {
            pname: "",
            pcode: "",
            expiration: ""
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
        const { pname, pcode, expiration } = this.state;
        // returning the Ui to be rendered
        return ( 
        <form>         
        <div className="container-fluid" >
            
            <div className="row"> 
                <div className="col-md-5"></div>
                <div className="col-md-2" >
                <div className="text-primary" >
                    
                    <label htmlFor="main"><b><h3>ADD PRODUCT</h3></b></label>
                </div>
                </div>
                <div className="col-md-5"></div>
            </div>
        
        <div className="row">   
            <div className="col-md-3"></div>
                
                <div className="col-md-4">  
                    
                        <div className="form-group">
                        <label htmlFor="pname"><b>PRODUCT NAME :</b></label><br></br>
                        <input name="pname" type="text" value={pname} onChange={this.handleChange}/>
        
                         <span style={{color: "red"}}></span><br></br>                        

                        <label htmlFor="pcode"><b>PRODUCT CODE :</b></label><br></br>
                        <input name="pcode" type="text" value={pcode} onChange={this.handleChange}/>
        
                         <span style={{color: "red"}}></span><br></br>

                        <label htmlFor="expiration"><b>EXPIRATION :</b></label><br></br>
                        
                        <input name="expiration" type="text"  value={expiration} onChange={this.handleChange}/>
         <span style={{color: "red"}}></span><br></br>
                        <br></br>
                        
                        <div className="row">
                            <div className="col-md-2">
                        
                            </div>
                            </div>           
                        </div>
                </div>                                                
        </div>

        <div className="row"> 
                <div className="col-md-3"></div>
                <div className="col-md-4" >
                    <button type="button" className="btn btn-default bg-success" id="sumbit" value="Submit" onClick={this.handleSubmit} >SUBMIT</button>
                </div>
                <div className="col-md-2">
                    <button type="button" className="btn btn-default bg-success">VIEW LIST</button>
                </div>
                <div className="col-md-3"></div>
            </div><br></br><br></br><br></br><br></br>
            </div>
        </form> 

            
    
        );
    }
}

// exporting the component
export default AddDetails;
