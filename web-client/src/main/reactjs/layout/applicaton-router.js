import React from "react"
import {Router, Route, Link} from "react-router-dom"
import createBrowserHistory from "history/createBrowserHistory"

import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min';
import 'tether/dist/js/tether.min';
import 'bootstrap/dist/js/bootstrap.min.js';

import Main from './home';



const history = createBrowserHistory();

const Home = () => (
    <Main/>
)

const Services = () => (

    <div className="content-body text-justify text-center">
        <h2>Services</h2>
    </div>

)

const Contacts = () => (

    <div className="content-body text-justify text-center">
        <h2>Contacts</h2>
    </div>

)

const Registration = () => (
    <div className="content-body text-justify text-center">
        <h2>Registration</h2>
    </div>
)


const Login = () => (
    <div className="content-body text-justify text-center">
        <h2>Login</h2>
    </div>
)

class Navigation extends React.Component {
    render() {
        return (
            <Router history ={history}>
                <div className="container-fluid app-body">

                    <div className= "row">
                        <div className="col">
                            <nav className="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                                <button className="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                                    <span className="navbar-toggler-icon"/>
                                </button>
                                <Link className="navbar-brand" to="/">TanqEd Public</Link>

                                <div className="collapse navbar-collapse" id="navbarCollapse">
                                    <div className="col-8">
                                        <ul className="navbar-nav mr-auto">
                                            <li>
                                                <Link className="nav-item nav-link" to="/services">Services</Link>
                                            </li>
                                            <li>
                                                <Link className="nav-item nav-link" to = "/contacts">Contacts</Link>
                                            </li>
                                        </ul>
                                    </div>

                                    <div className="col-4">
                                        <ul className="navbar-nav mr-auto">
                                            <li>
                                                <Link className="nav-item nav-link" to="/registration">Sign Up</Link>
                                            </li>
                                            <li>
                                                <Link className="nav-item nav-link" to = "/login">Login</Link>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                        </div>


                    </div>
                    <div className= "row">
                        <div className="col">
                            <Route exact path="/" component = {Home}/>
                            <Route path="/services" component = {Services}/>
                            <Route path="/contacts" component = {Contacts}/>
                            <Route path="/registration" component = {Registration}/>
                            <Route path="/login" component = {Login}/>
                        </div>
                    </div>
                </div>
            </Router>
        )
    }
}


export default Navigation

