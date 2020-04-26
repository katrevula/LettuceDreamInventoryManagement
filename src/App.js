//importing react componnets
import React,{Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import {NavLink} from 'react-router-dom';
import imgLD from './lettucedream.jpg';
import './App.css';


//mentioning the path of the components
import AddDetails from './pages/AddDetails';
import AddCustomer from './pages/AddCustomer';
import AddBay from './pages/AddBay';
import AddPackage from './pages/AddPackage';
import ReadBarcode from './pages/ReadBarcode';
import GenerateBarcode from './pages/GenerateBarcode';
import ProductionReport from './pages/ProductionReport';
import OrderReport from './pages/OrderReport';



class App extends Component {
  // Rendering the UI of the page starts here
  render()
  {
    return (
      //creating links in the home page and navigating to the respective pages on clicking the generated links
      <Router basename= "/react-auth-ui/">

        
        <div className="App"> 
        
        <nav className="navbar navbar-expand-md navbar-dark fixed-top" >
          <img src= {imgLD} width ="8%" height ="100%" alt ="jjkkkk"/><br></br>
          
        </nav><br></br><br></br><br></br>
        
        <div className="PageSwitcher">

                <NavLink to="/add-user" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Add User / </NavLink>
                
                <NavLink exact to="/add-details" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Add Details /</NavLink>
                <NavLink exact to="/add-customer" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Add Customer /</NavLink>
                <NavLink exact to="/add-bay" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Add Bay /</NavLink>
                <NavLink exact to="/add-package" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Add Package/</NavLink>
                <NavLink exact to="/add-barcode" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Generate Barcode/</NavLink>
                <NavLink to="/add-product" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Production Report/</NavLink>
                <NavLink to="/add-order" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Order Report</NavLink>
               
              </div>

              
              <Route exact path="/add-details" component={AddDetails} />
              <Route exact path="/add-customer" component={AddCustomer} />
              <Route exact path="/add-bay" component={AddBay} />
              <Route exact path="/add-package" component={AddPackage} />
              <Route exact path="/add-barcode" component={ReadBarcode} />
              <Route exact path="/add-generatebarcode" component={GenerateBarcode} />
              <Route exact path="/add-product" component={ProductionReport} /> 
              <Route exact path="/add-order" component={OrderReport} />    
              
              <nav className="navbar navbar-expand-md navbar-dark fixed-bottom" >
                Copy Right@Lettuce Dream
            </nav>
    </div>  
    
    </Router>
    
    );
  }
  }
  
//exporting the component
export default App;
