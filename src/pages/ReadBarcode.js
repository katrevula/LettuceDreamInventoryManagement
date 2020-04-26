import React, { Component } from 'react';

class ReadBarcode extends Component{

    constructor(props){
        super(props);
 
        this.state = {
            fields: {},
            errors: {}
        }
        this.submitForm = this.submitForm.bind(this);
     }
     
     handleValidation(){
       
         let errors = {};
         let formIsValid = true;
 
         
         this.setState({errors: errors});
        return formIsValid;
    }
 
    submitForm(e){
         e.preventDefault();
         let fields = this.state.fields;
         console.log(fields);
         if(this.handleValidation()){
            this.props.history.push('/add-generatebarcode?name='+fields["productname"]+'&&harvest='+fields["harvestdate"]+'&&inspectby='+fields["inspectedby"]);
         }else{
            alert("Form has errors.")
         }
 
     }
 
     handleChange(field, e){         
         let fields = this.state.fields;
         fields[field] = e.target.value;        
         this.setState({fields});
     }
 
    render(){
        return ( 
            <div class="col-lg-12">
                <div class="col-lg-6">
 <form>
    <div class="form-group">
        <label  for="Product Name">Product Name<span style={{color: 'red'}}> *</span><br/></label>
        <input type="text"  ref ="productname" class="form-control" onChange={this.handleChange.bind(this, "productname")} id="Your full name" placeholder="Product Name"/>
      </div>
    <div class="form-group">
          <label for="Bay Number">Bay Number<span style={{color: 'red'}}> *</span><br/></label>
          <select id="Bay Number" class="form-control">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
          </select>
         
        </div>
        <div class="form-group">
          <label style={{float:'left'}} for="Package Type">Package Type<span style={{color: 'red'}}> *</span><br/></label>
          <select id="Package Type" class="form-control">
            <option value="volvo">Package 1</option>
            <option value="saab">Saab</option>
            <option value="opel">Opel</option>
            <option value="audi">Audi</option>
          </select>
 
        </div>
        <div class="form-group">
          <label style={{float:'left'}} for="Harvest Date">Harvest Date<span style={{color: 'red'}}> *</span><br/></label>
          <input type="date" ref ="harvestdate" class="form-control" onChange={this.handleChange.bind(this, "harvestdate")} id="Select HARVEST date" placeholder="Select HARVEST date"/>
        </div>
        <div class="form-group">
          <label style={{float:'left'}}for="Inspected by">Inspected by<span style={{color: 'red'}}> *</span><br/></label>
          <input type="text" ref ="inspectedby" class="form-control" onChange={this.handleChange.bind(this, "inspectedby")} id="Inspected by" placeholder="Inspector Name"/>
        </div>
        <div class="form-group">
          <label style={{float:'left'}} for="Delivery to">Delivery to<span style={{color: 'red'}}> *</span><br/></label>
          <select id="Delivery to" class="form-control">
            <option value="volvo">Please select the customer address</option>
            <option value="saab">Saab</option>
            <option value="opel">Opel</option>
            <option value="audi">Audi</option>
          </select>
         
        </div>
        
      
         <button type="button" onClick={this.submitForm} class="btn btn-primary">Generate</button>
         <br/><br/> <br/><br/>
         
         </form>
         </div>
         </div>
         
 
      

            
    
        );
    }
}

export default ReadBarcode;