'use strict';

import React, { Component } from 'react';
import './css/footer.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Footer extends Component{

    render() {
        return(
            <footer className="border-top border-bottom fixed-bottom">
                <h1 className="App-disclaimer text-justify text-center" >About Services...</h1>
            </footer>
        );
    }
}


export default Footer;