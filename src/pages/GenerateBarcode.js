import React, { Component } from 'react'; //import react components
var Barcode = require('react-barcode'); //adding react barcode module

class GenerateBarcode extends Component{

    constructor(props){ //constructor in class
        super(props); 

        const urlParams = new URLSearchParams(window.location.search); //getting the url
        this.name = urlParams.get('name'); // getting the name
        this.harvest = urlParams.get('harvest');
        this.inspectby = urlParams.get('inspectby');

        this.state = {
            fields: {},
            errors: {}
        }
       
     }

      makeid() {
        var result           = '';
        var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var charactersLength = 8;
        for ( var i = 0; i < 8; i++ ) {
           result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        return result;
     }

     render(){return(
      
        <div class="container">
            
	<Barcode value={this.name}></Barcode>
   <div>
      <label><b>Name</b>:{this.name}</label><br></br>
      <label>
         <b>Harvest</b>:{this.harvest}
      </label>
      <br></br>
      <label>
         <b>Inspect By</b>:{this.inspectby}
      </label>
   </div>
 
	</div>
     )
     }
    }
    export default GenerateBarcode;