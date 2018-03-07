
import React, { Component } from 'react';

import './css/body.css';


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

    handleSubmit(event) {

    }

    render(){

        return(
            <form className="content-body align-items-center ">
                <hr/>
                <div className="form-group row">
                    <div className="col-sm-6 offset-sm-3 align-self-center">

                        <input name="email"
                               type="text"
                               value={this.state.email}
                               onChange={this.handleInputChange}
                               className="form-control mb-sm-2 mb-3"
                               id="inlineFormInputGroup"
                               placeholder="Email"/>

                        <input name = "password"
                               type="password"
                               value={this.state.password}
                               onChange={this.handleInputChange}
                               className="form-control mb-sm-2 mb-3"
                               id="inlineFormInput"
                               placeholder="Password"/>
                        <hr/>
                        <button className = "col btn btn-dark mr-5">Sign Up! </button>

                    </div>
                </div>
            </form>
        );
    }
}


export default Registration;
