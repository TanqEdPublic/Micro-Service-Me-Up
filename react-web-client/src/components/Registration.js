
import React, { Component } from 'react';

import './css/body.css';


//http://ec2-34-208-221-17.us-west-2.compute.amazonaws.com:8086/reg/user/new
const regUrl = "http://localhost:8091/user/new";

class Registration extends Component{



    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
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
        fetch(regUrl, {
            //mode: 'no-cors',
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: this.state.email,
                password: this.state.password
            })

        }).then((response) => {
            return response.json();
            // console.log(response);
            // console.log(response.json());
        }).then((json) =>{
            console.log(json)

        });
        event.preventDefault();
    }


    render(){

        return(
            <form className="content-body align-items-center " onSubmit={this.handleSubmit}>
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
