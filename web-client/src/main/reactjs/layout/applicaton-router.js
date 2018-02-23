import React from "react"
import {BrowserRouter, Route, Link} from "react-router-dom"
import createBrowserHistory from "history/createBrowserHistory"

import './css/header.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min';
import 'tether/dist/js/tether.min';
import 'bootstrap/dist/js/bootstrap.min.js';

import Body from './body';


const history = createBrowserHistory();

const Home = () => (
    <Body/>
)

const Services = () => (

    <div>
        <h2>Services</h2>
    </div>

)

const Contacts = () => (

    <div>
        <h2>Contacts</h2>
    </div>

)

class Navigation extends React.Component {
    render() {
        return (
            <BrowserRouter history ={history}>
                <nav className="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
                    <button className="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"/>
                    </button>
                    <Link className="navbar-brand" to="/">TanqEd Public</Link>

                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav mr-auto">
                            <li>
                                <Link className="nav-item" to="/services">Services</Link>
                            </li>
                            <li>
                                <Link className="nav-item" to = "/contacts">Contacts</Link>
                            </li>
                        </ul>
                    </div>
                    <Route exact path="/" component = {Home}/>
                    <Route path="/about" component = {Services}/>
                    <Route path="/contacts" component = {Contacts}/>
                </nav>
            </BrowserRouter>
        )
    }
}


export default Navigation

