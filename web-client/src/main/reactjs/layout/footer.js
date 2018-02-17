'use strict';

import React, { Component } from 'react';
import './css/footer.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Footer extends Component{

    render() {
        return(
                <div className="row border border-dark footer">
                    <div className="col-sm ">
                        <h1 className="app-disclaimer text-justify text-center" >About Services...</h1>
                    </div>
                    <div className="col-sm ">Bla bla bla</div>
                </div>
        );
    }
}


export default Footer;