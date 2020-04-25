import React, {Component} from "react";
import {Button, Card, Form} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faPlusSquare, faSave} from '@fortawesome/free-solid-svg-icons';

export default class AddBay extends Component {

    constructor(props) {

        super(props);
        this.state = {addbayname: ''};
        this.bayChange = this.bayChange.bind(this);
        this.submitBay = this.submitBay.bind(this);

    }

    submitBay(event) {
        alert(this.state.addbayname)
        event.preventDefault();
    }

    bayChange(event) {
        this.setState({
            [event.target.name]: (event.target.value).toUpperCase()
        });
    }

    render() {
        return (


            <Card className="border border-dark bg-dark text-white" style={{width: '18rem'}}>

                <Card.Header as="h3" text-align='center' className="text-center"><FontAwesomeIcon
                    icon={faPlusSquare}/> Add New Bay</Card.Header>
                <Form onSubmit={this.submitBay} id="bayFromID">
                    <Card.Body>
                        <Form.Row>
                            <Form.Group controlId="formaddbayname">
                                <Form.Label>Bay Name</Form.Label>
                                <Form.Control required
                                              type="text"
                                              minlength="1" maxlength="1"
                                              name="addbayname"
                                              value={this.state.addbayname}
                                              onChange={this.bayChange}
                                              className={"text-dark"}
                                              placeholder="Enter Bay Name"/>
                                <Form.Text className="text-muted">
                                    Please Enter an Alphabet.
                                </Form.Text>
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer>
                        <Button variant="primary" type="submit">
                            <FontAwesomeIcon icon={faSave}/> Submit
                        </Button>
                    </Card.Footer>

                </Form>
            </Card>





        )
    }
}



