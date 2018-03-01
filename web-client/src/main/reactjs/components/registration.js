'use strict';

import React, { Component } from 'react';
import './css/body.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Registration extends Component{

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'text' ? target.value : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    render(){

        return(
            <form className="content-body align-items-center ">
                <hr/>
                <div className="form-group row">
                    <div className="col-sm-6 offset-sm-3 align-self-center">
                        <label className="sr-only" htmlFor="inlineFormInputGroup">Username</label>
                        <input name="email"
                               type="text"
                               value={this.state.email}
                               onChange={this.handleInputChange}
                               className="form-control mb-sm-2 mb-3"
                               id="inlineFormInputGroup"
                               placeholder="Email"/>

                        <label className="sr-only" htmlFor="inlineFormInput">Password</label>
                        <input name = "password"
                               type="password"
                               value={this.state.password}
                               onChange={this.handleInputChange}
                               className="form-control mb-sm-2 mb-3"
                               id="inlineFormInput"
                               placeholder="Password"/>
                        <hr/>
                        <button className = "btn btn-dark align-self-end mr-5">Sign Up! </button>

                    </div>
                </div>
            </form>
        );
    }
}


export default Registration;
