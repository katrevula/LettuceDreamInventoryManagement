import React, { Component } from 'react';
import Checkbox from 'react-simple-checkbox';

class AddPackage extends Component{
    // add constructor and initialize state
    constructor(props){
        super(props);
 
        this.state = {
            ptype: "",
            weight: false,
            count: ""
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

      // to hold the value of the checkbox
      CheckboxTest()
      {
          this.setState({
            weight:!this.state.weight
          })
      }

     // Transforming react components into DOM nodes that a browser can understand and display on the screen
    render(){
        const { ptype, weight, count } = this.state;
        return ( 
        <form>         
        <div class="container-fluid" >
            
            <div class="row"> 
                <div class="col-md-5"></div>
                <div class="col-md-2" >
                <div class="text-primary" >
                    <label for="main"><b><h3>ADD PACKAGE</h3></b></label>      
                </div>
                </div>
                <div class="col-md-5"></div>
            </div>
            <br></br>
        <div class="row"> 
                <div class="col-md-3"></div>
                <div class="col-md-3    ">
                <label htmlFor="ptype"><b>PACKAGE TYPE :</b></label><br></br>
                <input name="ptype" type="text" value={ptype} onChange={this.handleChange}/>
        
                 <span style={{color: "red"}}></span><br></br>
                </div>
                <div class="col-md-2" >
                <label htmlFor="weight"><b>WEIGHT</b></label><br></br>
                
                <input name="weight" type="checkbox" value={false} onChange={this.handleChange}/>
        
                </div>                
                <div class="col-md-2">
                <label for="phn"><b>COUNT</b></label><br></br>
                <input name="count" type="checkbox" value={false} onChange={this.handleChange}/>
        
                                
                </div>
                <div class="row">
                            <div class="col-md-2">
                          
                            </div>
                        </div>           
                    </div>
            </div>
        

        <div class="row"> 
                <div class="col-md-3"></div>
                
                <div class="col-md-3" >
                    <br></br>
                    <button type="button" class="btn btn-default bg-success" id="sumbit" value="Submit" onClick={this.handleSubmit} >SUBMIT</button>
                    
                </div>                
               
            </div>
          
        </form> 

            
    
        );
    }
}

// exporting the component
export default AddPackage;
