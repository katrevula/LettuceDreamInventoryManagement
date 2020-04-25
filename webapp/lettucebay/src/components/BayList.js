import React, {Component} from "react";
import {Button, ButtonGroup, Card, Table} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEdit, faList} from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
// import ActionUpdate from "ActionUpdate";
import {Route, Switch} from "react-router-dom";

export default class BayList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            bays: []
        };
    }


    componentDidMount() {
        axios.get("http://localhost:8080/bays")
            .then(response => response.data)
            .then((data) => {
                    this.setState({bays: data});
                }
            )
        ;
    }

    render() {
        return (

            // <div>  sandeep bay</div>
            <Card className="">
                <Card.Header> <FontAwesomeIcon icon={faList}/> Bay List</Card.Header>

                <Card.Body>
                    <Table borderd border-dark hover striped varient="dark">
                        <thead>
                        <tr>
                            <th>S.no</th>
                            <th>Bay Name</th>
                        </tr>
                        </thead>
                        <tbody>

                        {this.state.bays.length === 0 ?
                            <tr align="center">
                                <td colSpan="6"> No bays listed. Go to add bays to add baylist</td>
                            </tr> : this.state.bays.map((bay) => (
                                    <tr key = {bay.bay_id}>
                                        <td>&nbsp;</td>
                                        <td>{bay.bay_Name}</td>
                                        <td>
                                            <ButtonGroup>
                                                <Button size="sm" variant="outline-primary"> <FontAwesomeIcon icon={faEdit}/></Button>{' '}

                                            </ButtonGroup>
                                        </td>
                                    </tr>
                                )
                            )}
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}
