import React from "react"

import {Router, Route, Switch} from "react-router-dom"
import createBrowserHistory from "history/createBrowserHistory"

import {Container, Row, Col} from 'reactstrap';

// import 'bootstrap/dist/css/bootstrap.min.css';
// import 'jquery/dist/jquery.min';
// import 'tether/dist/js/tether.min';
// import 'bootstrap/dist/js/bootstrap.min.js';
// import 'popper.js';

import './css/body.css'

import Main from './home';
import Registration from './registration'
import Navigation from './navigation-bar'



const history = createBrowserHistory();

const Routes =()=> (
    <Switch>
        <Route exact path="/" component = {Home}/>
        <Route path="/services" component = {Services}/>
        <Route path="/contacts" component = {Contacts}/>
        <Route path="/registration" component = {Signup}/>
        <Route path="/login" component = {Login}/>
        <Route component={NoMatch} />
    </Switch>
);

const Home = () => (
    <Main/>
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

const Signup = () => (
    <Registration/>
);


const Login = () => (
    <div className="content-body text-justify align-items-center text-center">
        <h2>Login</h2>
    </div>
);

const NoMatch = ({ location }) => (
    <Home/>
);

class Application extends React.Component {
    render() {
        return (
            <Router history ={history}>

                <Container fluid={true}>
                    <Row className="mb-5">
                        <Col>
                            <Navigation/>
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
}


export default Application

