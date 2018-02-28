'use strict';

import React, { Component } from 'react';
import '../css/body.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Main extends Component{

    render(){

        return(
            <div className="content-body text-justify text-center">
                <p> Main Body element. Very long boring text
                    Very long boring textVery long boring textVery long boring
                    textVery long boring text
                </p>
            </div>
        );
    }

}

export default Main;