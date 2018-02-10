'use strict';

import React, { Component } from 'react';
import './css/body.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Body extends Component{

    render(){

        return(
            <div className="App-body">
                <p className="text-justify text-center"> Main Body element. Very long boring text
                    Very long boring textVery long boring textVery long boring
                    textVery long boring text
                </p>
            </div>
        );
    }

}

export default Body;