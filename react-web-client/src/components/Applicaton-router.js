import React from "react";

import {Router, Route, Switch} from "react-router-dom";
import createBrowserHistory from "history/createBrowserHistory";

import {Container, Row, Col} from 'reactstrap';

import './css/body.css';

import Home from './Home';
import Registration from './Registration';
import Navigation from './Navigation-bar';



const history = createBrowserHistory();

const Routes =()=> (
    <Switch>
        <Route exact path="/" component = {Home}/>
        <Route path="/services" component = {Services}/>
        <Route path="/contacts" component = {Contacts}/>
        <Route path="/registration" component = {Registration}/>
        <Route path="/login" component = {Login}/>
        <Route component={NoMatch} />
    </Switch>
);


const Services = () => (

    <div className="content-body text-justify align-items-center text-center">
        <h2>Services</h2>
    </div>

);

const Contacts = () => (

    <div className="content-body text-justify align-items-center`text-center">
        <h2>Contacts</h2>
    </div>

);

const Login = () => (
    <div className="content-body text-justify align-items-center text-center">
        <h2>Login</h2>
    </div>
);

const NoMatch = ({ location }) => (
    <Home/>
);


function Application(){

    // maybe placed in redux store or even better to use auth cookie to decide auth logic
    const authenticated = false;

    // used in login
    const onAuthenticated = (val) => {
        this.setState({
            authenticated: val
        })
    };

    return (
        <Router history ={history}>

            <Container fluid={true}>
                <Row className="mb-5">
                    <Col>
                        <Navigation authenticated={authenticated}/>
                    </Col>
                </Row>
                <hr/>
                <Row className="mb-5">
                    <Col>
                        <Routes/>
                    </Col>
                </Row>
            </Container>

        </Router>
    )

}

export default Application

