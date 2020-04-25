import React,{Component} from "react";
import {Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";

class NavagationBar extends Component {
    render() {
        return (


            <Navbar bg="dark" variant="dark">

                <Link to={""} className="navbar-brand ">
                    Lettuce Dream

                </Link>
                <Navbar.Brand href="#home"></Navbar.Brand>
                <Nav className="mr-auto">

                    <Link to={"add"} className="navbar-link " >Add Bay</Link>
                    <Link to={"list"} className="navbar-link  ">Bay List</Link>
                </Nav>

            </Navbar>

        );
    }
}

export default NavagationBar;