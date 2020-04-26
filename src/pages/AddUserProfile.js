import React, { Component } from 'react';



class AddUserProfile extends Component{

    constructor(props){
        super(props);
 
        this.state = {
            fields: {},
            errors: {}
            
            
        }
        this.submitForm = this.submitForm.bind(this);
    }
        handleValidation()
        {
         let fields = this.state.fields;
         let errors = {};
         let formIsValid = true;
 
         //Name
         if(!fields["lname"] || !fields["fname"] || !fields["state"] || !fields["dob"]
         || !fields["city"]|| !fields["code"]|| !fields["address"] || !fields["password"]  || !fields["phn"]  )
         {
            formIsValid = false;
            errors["lname"] = "Cannot be empty";
            errors["fname"]= "Cannot be empty";
            errors["state"]= "Cannot be empty";
            errors["dob"]= "Cannot be empty";
            errors["password"]= "Cannot be empty";
            errors["city"]= "Cannot be empty";
            errors["phn"]= "Cannot be empty";
            errors["code"]= "Cannot be empty";
            errors["address"]= "Cannot be empty";
         }
        this.setState({errors: errors});
        return formIsValid;
    }

 
    submitForm(e)
        {
         e.preventDefault();
 
         if(this.handleValidation())
         {
            alert("Form submitted")
         }else{
            alert("Form has errors.")
         }
     }
     handleChange(field, e)
        {         
         let fields = this.state.fields;
         fields[field] = e.target.value;        
         this.setState({fields});
        }
    render()
        {
        return ( 
        <form>         
        <div className="container-fluid" >
            <div className="row"> 
                <div className="col-md-5"></div>
                <div className="col-md-2" >
                <div className="text-primary" >
                    <h3>
                    <label htmlFor="main"><b>add user</b></label>
                    </h3>
                </div>
                </div>
                <div className="col-md-5"></div>
            </div>
        <div className="row">   
            <div className="col-md-3"></div>
                <div className="col-md-4">  
                        <div className="form-group">
                        <label htmlFor="fname"><b>first name : </b></label><br></br> 
                        <input type="text" ref ="fname"  onChange={this.handleChange.bind(this, "fname")} value={this.state.fields["fname"]} /><br></br> 
                        <span style={{color: "red"}}>{this.state.errors["fname"]}</span><br></br>

                        <label htmlFor="dob"><b>date of birth :</b></label><br></br> 
                        <input type="text" ref ="dob"  onChange={this.handleChange.bind(this, "dob")} value={this.state.fields["dob"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["dob"]}</span><br></br>

                        <label htmlFor="address"><b>street address :</b></label><br></br> 
                        <input type="text" ref ="address"  onChange={this.handleChange.bind(this, "address")} value={this.state.fields["address"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["address"]}</span><br></br>

                        <label htmlFor="state"><b>state :</b></label><br></br> 
                        <input type="text" ref ="state"  onChange={this.handleChange.bind(this, "state")} value={this.state.fields["state"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["state"]}</span><br></br>

                        <label htmlFor="accesslevel"><b>access level :</b></label>
                        <br></br>
                        <div className="row">
                            <div className="col-md-2">
                        <button className="btn bg-success dropdown-toggle" width="30%" color="white"  type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a className="dropdown-item" href="Intern">Intern </a>
                            <a className="dropdown-item" href="Volunteer">Volunteer</a>
                            <a className="dropdown-item" href="Admin">Admin</a>
                            </div>  
                            </button>    
                            </div>
                            </div>           
                        </div>
                </div>
                <div className="col-md-4">  
                        <div className="form-group">
                        <label htmlFor="lname"><b>last name :</b>   </label><br></br> 
                        <input type="text" ref ="lname"  onChange={this.handleChange.bind(this, "lname")} value={this.state.fields["lname"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["lname"]}</span><br></br>
 
                        <label htmlFor="password"><b>password :</b></label><br></br> 
                        <input type="password" ref ="password"  onChange={this.handleChange.bind(this, "password")} value={this.state.fields["password"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["password"]}</span><br></br>

                        <label htmlFor="city"><b>city :</b></label><br></br>
                        <input type="text" ref ="city"  onChange={this.handleChange.bind(this, "city")} value={this.state.fields["city"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["city"]}</span><br></br>

                        <label htmlFor="code"><b>zip code :</b></label><br></br> 
                        <input type="text" ref ="code"  onChange={this.handleChange.bind(this, "code")} value={this.state.fields["code"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["code"]}</span><br></br>

                        <label htmlFor="phn"><b>phone number :</b></label><br></br>
                        <input type="text" ref ="phn"  onChange={this.handleChange.bind(this, "phn")} value={this.state.fields["phn"]} /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["phn"]}</span><br></br>

                        </div>
                        <div className="col-md-2"></div>              
                </div>                                                      
        </div>
    
        <div className="row">   
                <div className="col-md-3"></div>
                <div className="col-md-2">
                    <button type="button" className="btn btn-default bg-success">edit</button>
                </div>
                <div className="col-md-2">
                    <button type="button" className="btn btn-default bg-success" id="sumbit" value="Submit" onClick={this.submitForm} >submit</button>
                </div>                
                <div className="col-md-2">
                    <button type="button" className="btn btn-default bg-success">cancel</button>
                </div>
                <div className="col-md-3"></div>
            </div><br></br><br></br><br></br><br></br>
            </div>
        </form> 
        );
    }
}



export default AddUserProfile;