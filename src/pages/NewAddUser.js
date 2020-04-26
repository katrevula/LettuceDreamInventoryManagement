import React, { Component } from 'react';
import axios from 'axios';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import NewUserList from './AddUser'; 
import {Dropdown} from 'react-bootstrap';

class AddUser extends Component {
	constructor(props) {
        super(props)

		this.state = {

            fields: {},
            errors: {},

			fname: '',
			lname: '',
			dob: '',
			address: '',
			code: '',
			phn: '',
			state: '',
			password: '',
            city: '',
            access:'',
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

	changeHandler = e => {
		this.setState({ [e.target.name]: e.target.value })
    }

    submitHandler = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.post('https:/localhost:8080/api/v1/users', this.state)
			.then(response => {
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
    }
    
	render() {
		const {fname,lname,dob,address,code,phn,state,password,city,access} = this.state
		return (
            
			<div>
			 <form onSubmit={this.submitHandler}>
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
                        <input type="text" name ="fname" value = {fname} ref ="fname" onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "fname")} value={this.state.fields["fname"]}/><br></br> 
                        <span style={{color: "red"}}>{this.state.errors["fname"]}</span><br></br>
                        

                        <label htmlFor="dob"><b>date of birth :</b></label><br></br> 
                        <input type="text" name ="dob" value = {dob} ref ="dob"onChange={this.changeHandler } onEmptied={this.handleChange.bind(this, "dob")} value={this.state.fields["dob"] }/><br></br>
                        <span style={{color: "red"}}>{this.state.errors["dob"]}</span><br></br>
                        

                        <label htmlFor="address"><b>street address :</b></label><br></br> 
                        <input type="text" name ="address" value = {address} ref ="address" onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "address")} value={this.state.fields["address"] }  /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["address"]}</span><br></br>
                        

                        <label htmlFor="state"><b>state :</b></label><br></br> 
                        <input type="text" name ="state" value = {state} ref ="state"  onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "state")} value={this.state.fields["state"] } /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["state"]}</span><br></br>

                        <Dropdown>
                            <Dropdown.Toggle variant="#85C440" id="dropdown-basic" name ="access">
                                Access Level
                            </Dropdown.Toggle>

                            <Dropdown.Menu>
                                <Dropdown.Item href="#/action-1">Admin</Dropdown.Item>
                                <Dropdown.Item href="#/action-2">Intern</Dropdown.Item>
                                <Dropdown.Item href="#/action-3">Volunteer</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>  
        
                    </div>
                	</div>
                	<div className="col-md-4">  
                        <div className="form-group">
                        <label htmlFor="lname"><b>last name :</b>   </label><br></br> 
                        <input type="text" name ="lname" value = {lname} ref ="lname" onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "lname")} value={this.state.fields["lname"]}/><br></br>
                        <span style={{color: "red"}}>{this.state.errors["lname"]}</span><br></br>
                        
 
                        <label htmlFor="password"><b>password :</b></label><br></br> 
                        <input type="password" name ="password" value = {password} ref ="password" onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "password")} value={this.state.fields["password"] } /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["password"]}</span><br></br>
                        

                        <label htmlFor="city"><b>city :</b></label><br></br>
                        <input type="text" name ="city" value = {city} ref ="city" onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "city")} value={this.state.fields["city"] }/><br></br>
                        <span style={{color: "red"}}>{this.state.errors["city"]}</span><br></br>
                        

                        <label htmlFor="code"><b>zip code :</b></label><br></br> 
                        <input type="text" name ="code" value = {code} ref ="code" onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "code")} value={this.state.fields["code"] } /><br></br>
                        <span style={{color: "red"}}>{this.state.errors["code"]}</span><br></br>
                        

                        <label htmlFor="phn"><b>phone number :</b></label><br></br>
                        <input type="text" name ="phn" value = {phn} ref ="phn"  onChange={this.changeHandler} onEmptied={this.handleChange.bind(this, "phn")} value={this.state.fields["phn"] }/><br></br>
                        <span style={{color: "red"}}>{this.state.errors["phn"]}</span><br></br>
                        </div>
                        <div className="col-md-2"></div>              
                </div>                                                      
        </div>
    
        <div className="row">   
                <div className="col-md-3"></div>
                <div className="col-md-2">
                    <button type="submit" onSubmit={this.handleChange} >Submit</button>
                </div>
                <div className="col-md-2">
                    <button type="submit"  >Final Submit</button>
                </div>
                <div className="col-md-3"></div>
            </div><br></br><br></br><br></br><br></br>
            </div>

				</form>
			</div>
		)
	}
}

export default NewAddUser;
